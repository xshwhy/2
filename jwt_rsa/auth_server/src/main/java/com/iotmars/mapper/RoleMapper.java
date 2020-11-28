package com.iotmars.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iotmars.po.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xsh
 * @date: 2020/11/27 9:15
 */
@Repository
public interface RoleMapper extends BaseMapper<SysRole> {


    /**
     * 根据用户id查询角色
     * @param uid
     * @return
     */
    public List<SysRole> findByUid(@Param(value = "uid") Integer uid);

}
