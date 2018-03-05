package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.dao.mapper.product.StudentMapper;
import com.example.eurekaclient.dto.StudentDto;
import com.example.eurekaclient.service.CommonService;
import com.example.eurekaclient.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl extends CommonService implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    // 失效时间
    private static final int STUDENT_CACHE_EXPIRES = 2 * 3600;

    /**
     * 分页获取
     *
     * @param offset
     * @param pageSize
     * @return
     */
    @Override
    public List<StudentDto> selectStudentList(int offset, int pageSize) {
        String key = getStudentCacheKey(offset / pageSize +1);
        List<StudentDto> list = this.redisClient.getList(key, StudentDto.class);
        if (null == list) {
            list = selectStudentDB(offset, pageSize);
            if (list == null) {
                list = new ArrayList<>();
            }
            this.redisClient.setObject(key, list, STUDENT_CACHE_EXPIRES);
        }
        return list;
    }

    /**
     * 分页获取-DB
     *
     * @param offset
     * @param pageSize
     * @return
     */
    private List<StudentDto> selectStudentDB(int offset, int pageSize) {
        return studentMapper.selectStudentList(offset, pageSize);
    }
}
