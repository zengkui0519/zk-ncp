package com.zk.ncp.model;

import lombok.Data;

@Data
public class NcpVaccinationAreaStatistics {
    /**
     * 主键
     */
    private Long sId;

    /**
     * 地区id
     */
    private Long areaId;

    /**
     * 已接种人数
     */
    private Long vaccinationNum;

    /**
     * 已完成接种人数
     */
    private Long finishNum;

    /**
     * 截止日期(统计小于等于该日期数据)
     */
    private String statisticDate;

}