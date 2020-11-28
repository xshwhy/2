package com.iotmars.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author: xsh
 * @date: 2020/11/26 19:12
 */
@Data
@TableName(value = "sys_role")
@Accessors(chain = true)
public class SysRole implements GrantedAuthority {

    private static final long serialVersionUID = -4821814024018492633L;

    private Integer id;

    private String roleName;

    private String roleDesc;


    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
