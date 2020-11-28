package com.iotmars.service.impl;

import com.iotmars.mapper.RoleMapper;
import com.iotmars.mapper.UserMapper;
import com.iotmars.po.SysRole;
import com.iotmars.po.SysUser;
import com.iotmars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xsh
 * @date: 2020/11/27 9:37
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = userMapper.findByName(s);
        Integer id = sysUser.getId();
        List<SysRole> sysRoles = roleMapper.findByUid(id);
        sysUser.setRoles(sysRoles);
        return sysUser;
    }
}
