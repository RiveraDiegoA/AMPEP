package com.riveraprojects.ampep.Models;

public class Advertisement {
    private String title, desc, teacher, date;

    public Advertisement(String title, String desc, String teacher, String date) {
        this.title = title;
        this.desc = desc;
        this.teacher = teacher;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
