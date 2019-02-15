package com.config.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GlobalIcon")
@ApiModel("配置项-图标类")
public class GlobalIcon  implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalIcon() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id; // 主键ID

    @ApiModelProperty("系统标识")
    private String flag; // 系统标识

    @ApiModelProperty("非前置的为null")
    private String prepositionId; // 非前置的为NULL

    @ApiModelProperty("icon名称")
    private String name; // icon名称

    @ApiModelProperty("图片地址")
    private String url; // 图片地址

    @ApiModelProperty("ICON描述")
    private String description; // ICON描述

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
