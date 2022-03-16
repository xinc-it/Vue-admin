package com.markerhub.service.impl;

import com.markerhub.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Date：2022/3/15
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@SpringBootTest
class SysUserServiceImplTest {

    @Autowired
    private SysUserService sysUserService;


    @Test
    void getUserRoleByName() {
        System.out.println(sysUserService.getUserRoleByName("admin"));
    }
}