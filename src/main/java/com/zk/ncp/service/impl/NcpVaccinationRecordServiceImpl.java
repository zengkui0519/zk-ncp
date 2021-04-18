package com.zk.ncp.service.impl;

import com.zk.ncp.mapper.NcpVaccinationRecordMapper;
import com.zk.ncp.model.vo.NcpVaccinationRecordVo;
import com.zk.ncp.service.NcpVaccinationDetailService;
import com.zk.ncp.service.NcpVaccinationRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NcpVaccinationRecordServiceImpl implements NcpVaccinationRecordService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NcpVaccinationRecordMapper ncpVaccinationRecordMapper;

    @Resource
    private NcpVaccinationDetailService ncpVaccinationDetailService;

    @Override
    public boolean saveNcpVaccinationRecordAndDetail(Integer personId, List<NcpVaccinationRecordVo> ncpVaccinationRecordList) {
        if (CollectionUtils.isEmpty(ncpVaccinationRecordList)) {
            logger.info("新冠疫苗接种记录为空");
            return true;
        }

        Date now = new Date();
        for (NcpVaccinationRecordVo item : ncpVaccinationRecordList) {
            item.setPersonId(personId);
            if (null == item.getRecordId()) {
                item.setCreateTime(now);
                ncpVaccinationRecordMapper.insert(item);
                continue;
            }
            ncpVaccinationRecordMapper.updateByPrimaryKey(item);
        }

        for (NcpVaccinationRecordVo item : ncpVaccinationRecordList) {
            if (!ncpVaccinationDetailService.saveNcpVaccinationDetailList(item.getRecordId(), item.getNcpVaccinationDetailList())) {
                return false;
            }
        }
        logger.info("保存新冠疫苗接种记录成功");
        return true;
    }

    @Override
    public List<Integer> getNcpVaccinationRecordIdList(Integer personId) {
        return ncpVaccinationRecordMapper.selectNcpVaccinationRecordIdList(personId);
    }

    @Override
    public void deleteNcpVaccinationRecords(Integer personId) {
        ncpVaccinationRecordMapper.deleteNcpVaccinationRecords(personId);
    }

}
