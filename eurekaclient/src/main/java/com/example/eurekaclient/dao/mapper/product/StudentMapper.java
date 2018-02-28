package com.example.eurekaclient.dao.mapper.product;

import com.example.eurekaclient.dao.sqlprovider.StudentProvider;
import com.example.eurekaclient.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 分页获取
     *
     * @return
     */
    @SelectProvider(type = StudentProvider.class, method = "selectStudentList")
    List<StudentDto> selectStudentList(@Param("offset") int offset,
                                                      @Param("pageSize") int pageSize);
}
