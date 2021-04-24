package com.zk.ncp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zk.ncp.mapper.NcpVaccinationStatisticsMapper;
import com.zk.ncp.model.NcpVaccinationAreaStatistics;
import com.zk.ncp.model.vo.NcpStatisticsRequestVO;
import com.zk.ncp.model.vo.NcpVaccinationAreaStatisticsVO;
import com.zk.ncp.service.NcpVaccinationStatisticsService;
import com.zk.ncp.utils.SysConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class NcpVaccinationStatisticsServiceImpl implements NcpVaccinationStatisticsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private NcpVaccinationStatisticsMapper statisticsMapper;

    @Override
    public void handleAreaData() {
        // 查询所有的城市级的areaId,用NcpVaccinationAreaStatistics接受方便批量存
        List<NcpVaccinationAreaStatistics> cityIds = statisticsMapper.selectAllCityLevelAreaIds();
        // 批量插入，sql查询结果直接插入
        statisticsMapper.insertAreaStatisticsList(cityIds);
    }

    @Override
    public Map<String, Object> queryAreaData(NcpStatisticsRequestVO requestVO) {
        Map<String, Object> result = new HashMap<>();
        Page<Object> page = PageHelper.startPage(requestVO.getStart(), requestVO.getLimit());
        List<NcpVaccinationAreaStatisticsVO> dataList = new ArrayList<>();
        if (StringUtils.isEmpty(requestVO.getWorkProvince()) && StringUtils.isEmpty(requestVO.getWorkCity())) {
            // 查询所有省的统计数据
            dataList = statisticsMapper.selectProvinceLevelAreaStatistics(requestVO);
            result.put(SysConstants.Public.DATA_LIST, dataList);
            result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
            return result;
        }

        // 查询指定省所有市的数据，或者查询某个市的数据
        dataList = statisticsMapper.selectCityLevelAreaStatistics(requestVO);

        result.put(SysConstants.Public.DATA_LIST, dataList);
        result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
        return result;
    }

}
