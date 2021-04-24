package com.zk.ncp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class NcpVaccinationRecord {

    private Long recordId;

    /**
     * 接种人员ID
     */
    private Long personId;

    /**
     * 接种疫苗类型：1重组新冠病毒疫苗（5型腺病毒载体）2新冠病毒灭活疫苗（Vero细胞）3重组新冠病毒疫苗（CHO细胞）
     */
    private String vaccinationType;

    /**
     * 所选接种疫苗规定的接种次数
     */
    private Integer requiredTimes;

    /**
     * 已完成接种次数
     */
    private Integer completionTimes;

    /**
     * 接种完成率：0～100，保留小数点后一位
     */
    private Double finishRate;

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
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date modifyTime;

}