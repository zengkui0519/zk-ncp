package com.zk.ncp.model.vo;

import com.zk.ncp.model.BasePageRequest;
import lombok.Data;

@Data
public class NcpVaccinationParamsVO extends BasePageRequest {

    // 用户姓名
    private String userName;

    // 国籍或地区：1中国、2中国香港、3中国澳门、4中国台湾、5其他国家
    private String nationalityOrRegion;

    // 工作所在省
    private String workProvince;

    // 工作所在市
    private String workCity;

    // 接种状态：0未接种、1已接种
    private String vaccinationStatus;

    // 接种疫苗类型：1重组新冠病毒疫苗（5型腺病毒载体）2新冠病毒灭活疫苗（Vero细胞）3重组新冠病毒疫苗（CHO细胞）
    private String vaccinationType;

    // 接种地: 0境外、1境内，境内精确到市
    private String vaccinationPlace;

    // 接种省
    private String vaccinationProvince;

    // 接种市
    private String vaccinationCity;

    // 未接种原因：1无接种意愿、2存在接种禁忌无法接种、3有接种意愿但暂无接种资源、4已报名接种但暂未进行接种
    private String reason;

    // 接种完成率：0～100，保留小数点后一位
    private Double finishRate;

    // 用户ID
    private Long userId;

    // EHS系统的单位ID
    private Long orgId;

}
