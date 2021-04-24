package com.zk.ncp.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class NcpVaccinationPersonListVO {

    // 主键ID
    private Long personId;

    // 用户LDAP
    private String userCode;

    // 用户姓名
    private String userName;

    // EHS系统的单位ID
    private Long orgId;

    // EHS组织单位名称
    private String orgName;

    // 国籍或地区：1中国、2中国香港、3中国澳门、4中国台湾、5其他国家
    private String nationalityOrRegion;

    // 工作所在省
    private String workProvince;
    private String workProvinceName;

    // 工作所在市
    private String workCity;
    private String workCityName;

    // 联系方式
    private String tel;

    // 接种状态：0未接种、1已接种
    private String vaccinationStatus;

    // 未接种原因：1无接种意愿、2存在接种禁忌无法接种、3有接种意愿但暂无接种资源、4已报名接种但暂未进行接种
    private String reason;

    // 修改时间
    private Date updateTime;

    private Long recordId;

    // 接种疫苗类型：1重组新冠病毒疫苗（5型腺病毒载体）2新冠病毒灭活疫苗（Vero细胞）3重组新冠病毒疫苗（CHO细胞）
    private String vaccinationType;

    // 所选接种疫苗规定的接种次数
    private Integer requiredTimes;

    // 已完成接种次数
    private Integer completionTimes;

    // 接种完成率：0～100，保留小数点后一位
    private Double finishRate;

    private Long detailId;

    // 接种地: 0境外、1境内，境内精确到市
    private String vaccinationPlace;

    // 接种日期
    private Date vaccinationDate;

    // 接种省
    private String vaccinationProvince;
    private String vaccinationProvinceName;

    // 接种市
    private String vaccinationCity;
    private String vaccinationCityName;

}