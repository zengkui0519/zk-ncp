package com.zk.ncp.model;

import lombok.Data;

import java.util.Date;

/**
 * @description 新冠疫苗接种情况人员表
 * @author ZengKui
 * @date 2021/04/17 00:01
 */
@Data
public class NcpVaccinationPerson {
    /**
     * 主键ID
     */
    private Integer personId;

    /**
     * 用户LDAP
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 单位ID
     */
    private Integer orgId;

    /**
     * 单位名称
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
     * 接种状态：0未接种、1已接种、2完成接种
     */
    private String vaccinationStatus;

    /**
     * 未接种原因：1无接种意愿、2存在接种禁忌无法接种、3有接种意愿但暂无接种资源、4已报名接种但暂未进行接种
     */
    private String reason;

    /**
     * 接种次数（后续扩展字段，体内抗体消失后再次接种使用，也可能接种多种疫苗）
     */
    private Integer vaccinationTimes;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

}