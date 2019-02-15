package com.config.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GlobalTableField")
@ApiModel("表格字段类")
public class GlobalTableField implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalTableField() {
    }

    public GlobalTableField(String fieldName, String displayName, Boolean isHidden, String description) {
        this.fieldName = fieldName;
        this.displayName = displayName;
        this.isHidden = isHidden;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id; // 主键ID

    @ManyToOne
    @JoinColumn(name = "tables_id",referencedColumnName = "id") // 为了方便现将主键维护权交给一的一方
    @JsonIgnore
    private GlobalTable globalTable;

    @ApiModelProperty("字段名称")
    private String fieldName; // 字段名称

    @ApiModelProperty("表头展示名称")
    private String displayName; // 表头展示名称

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

    public GlobalTable getGlobalTable() {
        return globalTable;
    }

    public void setGlobalTable(GlobalTable globalTable) {
        this.globalTable = globalTable;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
}
