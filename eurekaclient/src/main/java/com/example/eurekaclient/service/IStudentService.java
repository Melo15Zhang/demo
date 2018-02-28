package com.example.eurekaclient.service;

import com.example.eurekaclient.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    /**
     * 分页获取
     *
     * @return
     */
    List<StudentDto> selectStudentList(int offset, int pageSize);
}
