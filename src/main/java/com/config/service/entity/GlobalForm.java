package com.config.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GlobalForm")
@ApiModel("表单类")
public class GlobalForm implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalForm() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id; // 主键ID

    @ApiModelProperty("系统标识")
    private String flag;

    @ApiModelProperty("前置ID标识，非前置的为null")
    private String prepositionId; // 非前置的为NULL

    @ApiModelProperty("表单名称")
    private String formName; // 表单名称

    @ApiModelProperty("表单在当前系统的唯一ID")
    private String formId; //

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "forms_id",referencedColumnName = "id") // 为了方便现将主键维护权交给一的一方
    private List<GlobalFormField> fields = new ArrayList<>();

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

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<GlobalFormField> getFields() {
        return fields;
    }

    public void setFields(List<GlobalFormField> fields) {
        this.fields = fields;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
}
