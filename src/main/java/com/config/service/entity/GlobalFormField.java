package com.config.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GlobalFormField")
@ApiModel("表单字段类")
public class GlobalFormField implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalFormField() {
    }

    public GlobalFormField(String fieldName, String defaultValue, Boolean isRequire, String regex, Boolean isHidden, String description) {
        this.fieldName = fieldName;
        this.defaultValue = defaultValue;
        this.isRequire = isRequire;
        this.regex = regex;
        this.isHidden = isHidden;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id; // 主键ID

    @ManyToOne
    @JoinColumn(name = "forms_id",referencedColumnName = "id") // 为了方便现将主键维护权交给一的一方
    @JsonIgnore
    private GlobalForm globalForm;

    @ApiModelProperty("字段名称")
    private String fieldName; // 字段名称

    @ApiModelProperty("字段默认值")
    private String defaultValue; // 字段默认值

    @ApiModelProperty("是否必须填写")
    private Boolean isRequire; // 是否必须

    @ApiModelProperty("正则表达式（js 校验规则）")
    private String regex; // 正则表达式（js 校验规则）

    @ApiModelProperty("是否隐藏")
    private Boolean isHidden; // 是否隐藏

    @ApiModelProperty("字段描述")
    private String description; // 字段描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getRequire() {
        return isRequire;
    }

    public void setRequire(Boolean require) {
        isRequire = require;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GlobalForm getGlobalForm() {
        return globalForm;
    }

    public void setGlobalForm(GlobalForm globalForm) {
        this.globalForm = globalForm;
    }
}
