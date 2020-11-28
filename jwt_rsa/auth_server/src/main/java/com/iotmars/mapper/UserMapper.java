package com.iotmars.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iotmars.po.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: xsh
 * @date: 2020/11/26 19:04
 */
@Repository
public interface UserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名称查询角色
     * @param username
     * @return
     */
    public SysUser findByName(@Param(value = "username") String username);

}
