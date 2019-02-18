package com.config.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GlobalTableChoosenField")
@ApiModel("表格筛选字段类")
public class GlobalTableChoosenField implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalTableChoosenField() {
    }

    public GlobalTableChoosenField(String fieldName, String displayName,String description, Integer indexs) {
        this.fieldName = fieldName;
        this.displayName = displayName;
        this.description = description;
        this.indexs = indexs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id; // 主键ID

    @ManyToOne
    @JoinColumn(name = "tables_filter_id",referencedColumnName = "id") // 为了方便现将主键维护权交给一的一方
    @JsonIgnore
    private GlobalTable globalTable;

    @ApiModelProperty("字段名称")
    private String fieldName; // 字段名称

    @ApiModelProperty("筛选展示名称")
    private String displayName; // 筛选展示名称

    @ApiModelProperty("字段描述")
    private String description; // 字段描述

    @ApiModelProperty("是否勾选")
    private Boolean isChoosen=false; // 是否勾选

    @ApiModelProperty("排序字段")
    private Integer indexs; //排序字段

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getChoosen() {
        return isChoosen;
    }

    public void setChoosen(Boolean choosen) {
        isChoosen = choosen;
    }

    public Integer getIndexs() {
        return indexs;
    }

    public void setIndexs(Integer indexs) {
        this.indexs = indexs;
    }

}
