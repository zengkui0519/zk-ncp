package com.zk.ncp.model;

import lombok.Data;

import java.util.Date;

/**
 * @description 新冠疫苗接种情况记录表
 * @author ZengKui
 * @date 2021/04/17 00:02
 */
@Data
public class NcpVaccinationRecord {
    /**
     * 主键ID
     */
    private Integer recordId;

    /**
     * 接种人员ID
     */
    private Integer personId;

    /**
     * 接种疫苗类型：1新冠病毒灭活疫苗（Vero细胞）2重组新冠病毒疫苗（5型腺病毒载体）3重组新冠病毒疫苗（CHO细胞）
     */
    private String vaccinationType;

    /**
     * 所选接种疫苗规定的接种次数
     */
    private String requiredTimes;

    /**
     * 已完成接种次数
     */
    private String completionTimes;

    /**
     * 创建时间
     */
    private Date createTime;

}