package com.zk.ncp.service.impl;

import com.zk.ncp.mapper.NcpVaccinationDetailMapper;
import com.zk.ncp.model.NcpVaccinationDetail;
import com.zk.ncp.model.vo.NcpVaccinationDetailVO;
import com.zk.ncp.service.NcpVaccinationDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NcpVaccinationDetailServiceImpl implements NcpVaccinationDetailService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NcpVaccinationDetailMapper ncpVaccinationDetailMapper;

    @Override
    public boolean saveNcpVaccinationDetailList(Long recordId, List<NcpVaccinationDetailVO> ncpVaccinationDetailList) {
        if (CollectionUtils.isEmpty(ncpVaccinationDetailList)) {
            logger.info("人员接种新冠疫苗明细为空");
            return false;
        }

        for (NcpVaccinationDetail detail : ncpVaccinationDetailList) {
            detail.setRecordId(recordId);
            if (null == detail.getDetailId()) {
                ncpVaccinationDetailMapper.insert(detail);
                continue;
            }
            ncpVaccinationDetailMapper.updateByPrimaryKey(detail);
        }
        logger.info("人员接种新冠疫苗明细保存成功");
        return true;
    }

    @Override
    public void deleteNcpVaccinationDetails(List<Long> recordIdList) {
        if (CollectionUtils.isEmpty(recordIdList)) {
            return;
        }

        for (Long recordId : recordIdList) {
            deleteNcpVaccinationDetails(recordId);
        }
    }

    @Override
    public void deleteNcpVaccinationDetails(Long recordId) {
        if (null == recordId) {
            return;
        }

        ncpVaccinationDetailMapper.deleteNcpVaccinationDetailsByRecordId(recordId);
    }

}
