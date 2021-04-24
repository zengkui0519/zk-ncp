package com.zk.ncp.model.vo;

import com.zk.ncp.model.BasePageRequest;
import lombok.Data;

@Data
public class NcpStatisticsRequestVO extends BasePageRequest {

    private String workProvince;

    private String workCity;

    private String statisticDate;

}