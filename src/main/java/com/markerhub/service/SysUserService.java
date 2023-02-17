package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysRole;
import com.markerhub.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getByUsername(String username);

    String getUserAuthorityInfo(Long userId);

    void clearUserAuthorityInfo(String username);

    void clearUserAuthorityInfoByRoleId(Long roleId);

    void clearUserAuthorityInfoByMenuId(Long menuId);


    boolean existsEmail(String emailAddress) ;

    List<SysUser> findAllUsers();

    List<SysUser> getAllManagers();

    SysUser getUserRoleByName(String name);


    static boolean userIsAdmin(List<SysRole> sysRoles) {
        return sysRoles.stream().anyMatch(k -> "admin".equalsIgnoreCase(k.getCode()));
    }

    static boolean userIsManager(List<SysRole> sysRoles) {
        return sysRoles.stream().anyMatch(k -> "manager".equalsIgnoreCase(k.getCode()));
    }

    List<SysUser> getAllTeachers();

    String getEmailAddress(Long id);
}
