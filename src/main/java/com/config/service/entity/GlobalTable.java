package com.config.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GlobalTable")
@ApiModel("列表类")
public class GlobalTable implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalTable() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id; // 主键ID

    @ApiModelProperty("系统标识")
    private String flag;

    @ApiModelProperty("前置ID标识，非前置的为null")
    private String prepositionId; // 非前置的为NULL

    @ApiModelProperty("表格名称")
    private String tableName; // 表格名称

    @ApiModelProperty("表格在当前系统的唯一ID")
    private String tableId; //

    private String description; // 关于此表格的描述

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "tables_id",referencedColumnName = "id") // 为了方便现将主键维护权交给一的一方
    private List<GlobalTableField> fields = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPrepositionId() {
        return prepositionId;
    }

    public void setPrepositionId(String prepositionId) {
        this.prepositionId = prepositionId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GlobalTableField> getFields() {
        return fields;
    }

    public void setFields(List<GlobalTableField> fields) {
        this.fields = fields;
    }
}
