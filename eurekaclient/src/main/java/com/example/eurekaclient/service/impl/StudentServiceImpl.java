package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.dao.mapper.product.StudentMapper;
import com.example.eurekaclient.dto.StudentDto;
import com.example.eurekaclient.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    StudentMapper studentMapper;
    /**
     * 分页获取
     *
     * @param offset
     * @param pageSize
     * @return
     */
    @Override
    public List<StudentDto> selectStudentList(int offset, int pageSize) {
        return studentMapper.selectStudentList(offset,pageSize);
    }
}
