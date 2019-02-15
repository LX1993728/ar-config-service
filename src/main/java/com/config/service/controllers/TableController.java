package com.config.service.controllers;

import com.config.service.entity.GlobalForm;
import com.config.service.entity.GlobalFormField;
import com.config.service.entity.GlobalTable;
import com.config.service.entity.GlobalTableField;
import com.config.service.repository.GeneralService;
import com.config.service.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/table")
@Api(value = "4.表格项",tags = {"(提交相关的表格配置)"})
public class TableController {
    @Autowired
    private GeneralService generalService;

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
            params.put("flag", flag.trim());
        }
        if (prepositionId != null) {
            params.put("prepositionId", prepositionId);
        }
        final PageVO pageVO = generalService.criteriaQuery(page, pageSize, GlobalTable.class, null, params,"id");
        return pageVO;
    }

    @ApiOperation(value = "添加或更新（若是更新 id不为null）", tags = {""})
    @PostMapping("/addOrUpdate")
    public Object addOrUpdate(@RequestBody GlobalTable globalTable) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("isSuccess",true);
        if (globalTable == null && globalTable.getFlag() == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","invalid param");
            return  resultMap;
        }

        if ("PREPOSITION".equals(globalTable.getFlag()) && globalTable.getPrepositionId() == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","前置系统的prepositionId 不能为null");
            return  resultMap;
        }

        if (globalTable.getId() == null){ // 添加操作
            generalService.persisent(globalTable);
            resultMap.put("message","add success");
        }else { // 更新操作
            generalService.merge(globalTable);
            Map<String, Object> params = new HashMap<>();
            params.put("globalTable",null);
            generalService.delete(GlobalTableField.class,null,params);
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

        final Object table = generalService.findById(GlobalTable.class, id);
        if (table == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","Not found");
            return resultMap;
        }
        generalService.delete(table);
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

        final Object table = generalService.findById(GlobalTable.class, id);
        if (table == null){
            resultMap.put("isSuccess",false);
            resultMap.put("message","invalid param");
            return resultMap;
        }
        return table;
    }

}