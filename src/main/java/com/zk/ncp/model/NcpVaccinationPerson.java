package com.zk.ncp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class NcpVaccinationPerson {

    private Long personId;

    /**
     * 用户LDAP
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * EHS系统的单位ID
     */
    private Long orgId;

    /**
     * HR系统的组织编码
     */
    private String orgCode;

    /**
     * EHS组织单位名称
     */
    private String orgName;

    /**
     * 国籍或地区：1中国、2中国香港、3中国澳门、4中国台湾、5其他国家
     */
    private String nationalityOrRegion;

    /**
     * 工作所在省
     */
    private String workProvince;

    /**
     * 工作所在市
     */
    private String workCity;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 接种状态：0未接种、1已接种
     */
    private String vaccinationStatus;

    /**
     * 未接种原因：1无接种意愿、2存在接种禁忌无法接种、3有接种意愿但暂无接种资源、4已报名接种但暂未进行接种
     */
    private String reason;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;

}