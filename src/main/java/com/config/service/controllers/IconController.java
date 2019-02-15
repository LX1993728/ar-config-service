package com.config.service.controllers;

import com.config.service.entity.GlobalIcon;
import com.config.service.repository.GeneralService;
import com.config.service.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import system.fastdfs.starter.processors.FdfsClientWrapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/icon")
@Api(tags = {"图标项"},value = "3.图标项")
public class IconController {
    @Autowired
    private GeneralService generalService;

    @Autowired
    private FdfsClientWrapper fdfsClientWrapper;

    @ApiOperation(value = "获取分页数据", tags = {""})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "flag", value = "系统标识", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "prepositionId", value = "部委前置的ID标识", required = false, paramType = "query", dataType = "String")
    })
    @GetMapping("/page")
    public Object getPageData(Long page, Long pageSize, String flag, String prepositionId) {
        Map<String, Object> params = new HashMap<>();
        if (flag != null) {
            params.put("flag", flag);
        }
        if (prepositionId != null) {
            params.put("prepositionId", prepositionId);
        }
        final PageVO pageVO = generalService.criteriaQuery(page, pageSize, GlobalIcon.class, null, params,"id");
        return pageVO;
    }

    @ApiOperation(value = "添加或更新（若是更新 id不为null）", tags = {""})
    @PostMapping("/addOrUpdate")
    public Object addOrUpdate(@RequestBody GlobalIcon globalIcon) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("isSuccess",true);
        if (globalIcon == null && globalIcon.getFlag() == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","flag 不能为空");
            return  resultMap;
        }

        if ("PREPOSITION".equals(globalIcon.getFlag()) && globalIcon.getPrepositionId() == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","前置系统的prepositionId 不能为null");
            return  resultMap;
        }

        if (globalIcon.getId() == null){ // 添加操作
            generalService.persisent(globalIcon);
            resultMap.put("message","add icon success");
        }else { // 更新操作
            generalService.merge(globalIcon);
            resultMap.put("message","update success");
        }
        return resultMap;
    }


    @ApiOperation(value = "删除操作", tags = {""})
    @PostMapping("/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, paramType = "query", dataType = "Long")
    })
    public Object delete(Long id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("isSuccess",true);

        if (id == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","id cannot be null");
            return resultMap;
        }

        final Object icon = generalService.findById(GlobalIcon.class, id);
        if (icon == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","Not found");
            return resultMap;
        }
        generalService.delete(icon);
        return resultMap;
    }

    @ApiOperation(value = "根据主键查询操作", tags = {""})
    @PostMapping("/findById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, paramType = "query", dataType = "Long")
    })
    public Object findById(Long id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        if (id == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","id cannot be null");
            return resultMap;
        }
        final Object icon = generalService.findById(GlobalIcon.class, id);
        if (icon == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","not found");
            return resultMap;
        }
        return icon;
    }

    @ApiOperation(value = "上传ICON", tags = {""})
    @PostMapping("/upload")
    public Object uploadIcon(@RequestParam("file")MultipartFile file, HttpServletResponse response){
        if (file == null){
            response.setStatus(400);
            return "文件不能为空";
        }

        String url = null;
        try {
            url =   fdfsClientWrapper.uploadFile(file);
        }catch (IOException e){
            response.setStatus(500);
            e.printStackTrace();
        }finally {
            return url;
        }
    }

}
