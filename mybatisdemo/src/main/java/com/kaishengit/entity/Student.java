package com.kaishengit.entity;

import java.util.Date;

/**
 * Created by zhao on 2017/10/22.
 * @author zhao
 */
public class Student {
    private Integer studId;
    private String name;
    private String email;
    private Date dob;

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public Integer getStudId() {
        return studId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
