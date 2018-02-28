package com.example.eurekaclient.dto;

public class StudentDto {

    private long id;

    private String name;

    private int subjects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubjects() {
        return subjects;
    }

    public void setSubjects(int subjects) {
        this.subjects = subjects;
    }
}
