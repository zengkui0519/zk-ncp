package com.zk.ncp.model;

import lombok.Data;

import java.util.Date;

/**
 * @description 人员新冠疫苗接种详情表
 * @author ZengKui
 * @date 2021/04/17 00:03
 */
@Data
public class NcpVaccinationDetail {
    /**
     * 主键ID
     */
    private Integer detailId;

    /**
     * 接种疫苗记录ID
     */
    private Integer recordId;

    /**
     * 接种人员ID
     */
    private Integer personId;

    /**
     * 接种地: 0境外、1境内，境内精确到市
     */
    private String vaccinationPlace;

    /**
     * 接种日期
     */
    private Date vaccinationDate;

    /**
     * 接种省
     */
    private String vaccinationProvince;

    /**
     * 接种市
     */
    private Date vaccinationCity;

}