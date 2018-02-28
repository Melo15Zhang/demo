package com.example.eurekaclient.dao.sqlprovider;

public class StudentProvider {

    public String selectStudentList() {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, name, subjects from student ");
        sb.append("order by id desc limit #{offset},#{pageSize} ");
        return sb.toString();
    }
}
