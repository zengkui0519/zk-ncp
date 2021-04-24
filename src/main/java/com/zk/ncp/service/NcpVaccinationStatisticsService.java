package com.zk.ncp.service;

import com.zk.ncp.model.vo.NcpStatisticsRequestVO;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface NcpVaccinationStatisticsService {

    void handleAreaData();

    Map<String, Object> queryAreaData(NcpStatisticsRequestVO requestVO);

}
