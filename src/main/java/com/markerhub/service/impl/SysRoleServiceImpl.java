package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.markerhub.entity.SysRole;
import com.markerhub.mapper.SysRoleMapper;
import com.markerhub.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

	@Autowired
	private SysRoleMapper roleMapper;

	@Override
	public List<SysRole> listRolesByUserId(Long userId) {

		List<SysRole> sysRoles = this.list(new QueryWrapper<SysRole>()
				.inSql("id", "select role_id from sys_user_role where user_id = " + userId));

		return sysRoles;
	}




	//@Override
	//public List<SysRole> getUserRole(String name) {
	//	List<SysRole> userRole = roleMapper.getUserRole(name);
	//	return userRole;
	//}
}
