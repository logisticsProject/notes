package com.xwm.notes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Note 实体类
 */

public class Note implements Serializable {

    private Integer id;

    private String title;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    public Note() {
    }

    public Note(int id, String title, String content, Date time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
