package com.zk.ncp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description 人员新冠疫苗接种详情表
 * @author zengkui
 * @date 2021/4/23 10:06 下午
 */
@Data
public class NcpVaccinationDetail {

    private Long detailId;

    /**
     * 接种疫苗记录ID
     */
    private Long recordId;

    /**
     * 接种地: 1中国、2中国香港、3中国澳门、4中国台湾、5其他国家
     */
    private String vaccinationPlace;

    /**
     * 接种日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date vaccinationDate;

    /**
     * 接种省
     */
    private String vaccinationProvince;

    /**
     * 接种市
     */
    private String vaccinationCity;

}