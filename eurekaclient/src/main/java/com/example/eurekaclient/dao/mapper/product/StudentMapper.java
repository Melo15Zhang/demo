package com.example.eurekaclient.dao.mapper.product;

import com.example.eurekaclient.dao.sqlprovider.StudentProvider;
import com.example.eurekaclient.dto.StudentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 分页获取
     *
     * @return
     */
    @SelectProvider(type = StudentProvider.class, method = "selectStudentList")
    List<StudentDto> selectStudentList(@Param("offset") int offset,@Param("pageSize") int pageSize);
    /**
     * 批量插入学生信息
     *
     * @param list
     * @return
     */
    @InsertProvider(type = StudentProvider.class, method = "batchInsert")
    public int batchInsert(List<StudentDto> list);

    /**
     * 更新。
     *
     * @param id
     * @param subjects
     * @return
     */
    @UpdateProvider(type = StudentProvider.class, method = "update")
    int update(@Param("id") long id,@Param("subjects") int subjects);

    /**
     * 删除。
     *
     * @param ids
     * @return
     */
    @DeleteProvider(type = StudentProvider.class, method = "delete")
    int delete(List<Long> ids);
}
