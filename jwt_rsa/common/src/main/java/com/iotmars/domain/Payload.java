package com.iotmars.domain;

import lombok.Data;

import java.util.Date;

/**
 * 方便后期获取token中的用户信息,将token中载荷部分单独封装成一个对象
 *
 * @author: xsh
 * @date: 2020/11/27 11:38
 */
@Data
public class Payload<T> {


    private String id;

    private T userInfo;

    private Date expiration;

}
