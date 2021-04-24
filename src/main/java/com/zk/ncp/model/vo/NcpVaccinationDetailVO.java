package com.zk.ncp.model.vo;

import com.zk.ncp.model.NcpVaccinationDetail;
import lombok.Data;

@Data
public class NcpVaccinationDetailVO extends NcpVaccinationDetail {

    // 接种省名称
    private String vaccinationProvinceName;

    // 接种市名称
    private String vaccinationCityName;

    // 接种市名称
    private Integer sort;

}