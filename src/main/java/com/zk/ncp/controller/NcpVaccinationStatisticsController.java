package com.zk.ncp.controller;

import com.zk.ncp.model.vo.NcpStatisticsRequestVO;
import com.zk.ncp.service.NcpVaccinationStatisticsService;
import com.zk.ncp.utils.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/statistics")
public class NcpVaccinationStatisticsController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private NcpVaccinationStatisticsService statisticsService;

    @Resource
    private HttpServletResponse response;

    /**
     * @description 统计接种信息(按地区)
     * @param
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:15 下午
     */
    @PostMapping("/handleAreaData")
    public ResultMessage handleAreaData() {
        statisticsService.handleAreaData();
        return ResultMessage.success();
    }

    /**
     * @description 查询接种情况统计信息(按地区)
     * @param requestVO
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:15 下午
     */
    @PostMapping("/queryAreaData")
    public ResultMessage queryAreaData(NcpStatisticsRequestVO requestVO) {
        logger.info("queryAreaData");
        return ResultMessage.success(statisticsService.queryAreaData(requestVO));
    }

    /**
     * @description 导出接种情况统计信息(按地区)
     * @param requestVO
     * @return void
     * @author zengkui
     * @date 2021/4/23 10:16 下午
     */
    @PostMapping(value = "/exportAreaData")
    public void exportAreaData(NcpStatisticsRequestVO requestVO) {
//        statisticsService.exportAreaData(requestVO, response);
    }
}
