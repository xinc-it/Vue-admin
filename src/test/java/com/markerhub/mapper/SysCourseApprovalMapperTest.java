package com.markerhub.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.vo.CourseApprovalVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Date：2022/3/16
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@SpringBootTest
class SysCourseApprovalMapperTest {

    @Autowired
    private SysCourseApprovalMapper courseApprovalMapper;

    @Test
    void getAllCourseApproval() {
        Page<CourseApprovalVO> page = new Page<>(1, 10);
        page=courseApprovalMapper.getAllCourseApproval(page, "");
        System.out.println(page.getRecords());
    }
}