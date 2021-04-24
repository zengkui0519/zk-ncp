package com.zk.ncp.model.vo;

import lombok.Data;

@Data
public class NcpVaccinationAreaStatisticsVO {

    private String areaName;

    /**
     * 已接种人数
     */
    private Long vaccinationNum;

    /**
     * 已完成接种人数
     */
    private Long finishNum;

    private String statisticDate;

}