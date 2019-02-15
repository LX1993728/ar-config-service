package com.config.service.controllers;

import com.config.service.entity.*;
import com.config.service.repository.GeneralService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api(tags = {"test"},value = "902.(预留)添加测试数据")
public class TestController {

    @Autowired
    private GeneralService generalService;

    @GetMapping("/add")
    public Object add(){
        // add 100 Title
        for (int i = 0; i < 100; i++) {
            final GlobalTitle title = new GlobalTitle();
            if (i >=0 && i <30){
                title.setContent("菏泽前置-1");
                title.setFlag("PREPOSITION");
                title.setPrepositionId("1");
            }else if (i >=30 && i< 60){
                title.setContent("菏泽前置-2");
                title.setFlag("PREPOSITION");
                title.setPrepositionId("2");
            }if (i >=60 && i<=100){
                title.setContent("菏泽指挥系统");
                title.setFlag("REPORT");
                title.setPrepositionId(null);
            }
            generalService.persisent(title);
        }

        // add 100 form
        for (int i = 0; i < 100; i++) {
            final GlobalForm form = new GlobalForm();
            if (i >=0 && i <30){
                form.setFlag("PREPOSITION");
                form.setPrepositionId("1");
            }else if (i >=30 && i< 60){
                form.setFlag("PREPOSITION");
                form.setPrepositionId("2");
            }if (i >=60 && i<=100){
                form.setFlag("REPORT");
                form.setPrepositionId(null);
            }
            form.setFormId("formId_"+i);

            List<GlobalFormField> fields = new ArrayList<>();
            fields.add( new GlobalFormField("name"+i,"zhansgan"+i,Boolean.TRUE,"",false,"姓名"+i));
            fields.add( new GlobalFormField("age"+i,"1"+i,Boolean.TRUE,"",true,"年龄"+i));
            fields.add( new GlobalFormField("sex"+i,"man"+i,Boolean.TRUE,"",false,"性别"+i));
            fields.add( new GlobalFormField("qq"+i,"1332323"+i,Boolean.TRUE,"",false,"QQ"+i));

            form.setFields(fields);

            generalService.persisent(form);

        }

        // add 100 ICON
        for (int i = 0; i < 100; i++) {
            final GlobalIcon icon = new GlobalIcon();
            if (i >=0 && i <30){
                icon.setFlag("PREPOSITION");
                icon.setPrepositionId("1");
            }else if (i >=30 && i< 60){
                icon.setFlag("PREPOSITION");
                icon.setPrepositionId("2");
            }if (i >=60 && i<=100){
                icon.setFlag("REPORT");
                icon.setPrepositionId(null);
            }
            icon.setName("icon_edit");
            icon.setUrl("http://wwww.image.url");
            generalService.persisent(icon);
        }

        // add 100 table
        for (int i = 0; i < 100; i++) {
            final GlobalTable table = new GlobalTable();
            if (i >=0 && i <30){
                table.setFlag("PREPOSITION");
                table.setPrepositionId("1");
            }else if (i >=30 && i< 60){
                table.setFlag("PREPOSITION");
                table.setPrepositionId("2");
            }if (i >=60 && i<=100){
                table.setFlag("REPORT");
                table.setPrepositionId(null);
            }
           table.setTableId("TableId-"+i);

            List<GlobalTableField> fields = new ArrayList<>();
            fields.add( new GlobalTableField("name"+i,"名称"+i,Boolean.TRUE,"姓名"+i));
            fields.add( new GlobalTableField("age"+i,"年龄"+i,Boolean.TRUE,"年龄"+i));
            fields.add( new GlobalTableField("sex"+i,"性别"+i,Boolean.TRUE,"性别"+i));
            fields.add( new GlobalTableField("qq"+i,"QQ号"+i,Boolean.TRUE,"QQ"+i));

            table.setFields(fields);

            generalService.persisent(table);

        }


        return "success";
    }

}
