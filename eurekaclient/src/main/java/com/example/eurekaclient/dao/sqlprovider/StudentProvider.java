package com.example.eurekaclient.dao.sqlprovider;

import com.example.eurekaclient.dto.StudentDto;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class StudentProvider {

    public String selectStudentList() {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, name, subjects from student ");
        sb.append("order by id desc limit #{offset},#{pageSize} ");
        return sb.toString();
    }

    public String batchInsert(Map<String, List<StudentDto>> map) {
        List<StudentDto> list = map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into student ( name, subjects) ");
        sb.append("values ");

        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(MessageFormat.format("(#'{'list[{0}].name'}',#'{'list[{0}].subjects'}')",String.valueOf(i)));
        }
        return sb.toString();
    }

    public String update() {
        StringBuilder sb = new StringBuilder();
        sb.append("update student set subjects=#{subjects} ");
        sb.append("where id=#{id}");
        return sb.toString();
    }

    public String delete(Map<String, List<Long>> map) {
        List<Long> list = map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("delete from student ");
        sb.append("where id in (");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(MessageFormat.format("#'{'list[{0}]'}'",String.valueOf(i)));
        }
        sb.append(")");
        return sb.toString();
    }
}
