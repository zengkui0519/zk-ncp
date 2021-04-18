package com.zk.ncp.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ZengKui
 * @description 系统用户表
 * @date 2021/03/16 13:58
 */
@Data
public class SysUser {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户手机号
     */
    private String userTel;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户状态：A有效 I无效
     */
    private String userStatus;

    private String createUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;

    private String updateUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;

}