package com.kaishengit.entity;

import java.io.Serializable;

/**
 * Created by zhao on 2017/10/24.
 */
public class Author implements Serializable {

    private Integer id;
    private String authorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
