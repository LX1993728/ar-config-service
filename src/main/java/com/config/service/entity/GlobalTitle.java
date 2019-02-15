package com.config.service.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GlobalTitle")
public class GlobalTitle implements Serializable {
    private static final long serialVersionUID = 1L;

    public GlobalTitle() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    private String flag;

    private String prepositionId; // 非前置的为NULL

    private String content; // 标题内容

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
