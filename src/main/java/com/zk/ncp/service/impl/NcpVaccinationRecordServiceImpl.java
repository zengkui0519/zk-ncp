package com.zk.ncp.service.impl;

import com.zk.ncp.mapper.NcpVaccinationRecordMapper;
import com.zk.ncp.model.vo.NcpVaccinationRecordVO;
import com.zk.ncp.service.NcpVaccinationDetailService;
import com.zk.ncp.service.NcpVaccinationRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.NumberFormat;
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
    public boolean saveNcpVaccinationRecordAndDetail(Long personId, List<NcpVaccinationRecordVO> ncpVaccinationRecordList) {
        if (CollectionUtils.isEmpty(ncpVaccinationRecordList)) {
            logger.info("新冠疫苗接种记录为空");
            return true;
        }

        Date now = new Date();
        for (NcpVaccinationRecordVO item : ncpVaccinationRecordList) {
            item.setPersonId(personId);
            int requiredTimes = getRequiredTimesByVaccinationType(item.getVaccinationType());
            item.setRequiredTimes(requiredTimes);
            int completionTimes = item.getNcpVaccinationDetailList().size();
            item.setCompletionTimes(completionTimes);
            double finishRate = calculateFinishRate(completionTimes, requiredTimes);
            item.setFinishRate(finishRate);
            if (null == item.getRecordId()) {
                item.setCreateTime(now);
                item.setModifyTime(now);
                ncpVaccinationRecordMapper.insert(item);
                continue;
            }
            item.setModifyTime(now);
            ncpVaccinationRecordMapper.updateByPrimaryKey(item);
        }

        for (NcpVaccinationRecordVO item : ncpVaccinationRecordList) {
            if (!ncpVaccinationDetailService.saveNcpVaccinationDetailList(item.getRecordId(), item.getNcpVaccinationDetailList())) {
                return false;
            }
        }
        logger.info("保存新冠疫苗接种记录成功");
        return true;
    }

    private double calculateFinishRate(int completionTimes, int requiredTimes) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后1位
        numberFormat.setMaximumFractionDigits(1);
        String finishRateStr = numberFormat.format((double) completionTimes / (double) requiredTimes * 100);
        double finishRate = Double.parseDouble(finishRateStr);
        return finishRate;
    }

    private int getRequiredTimesByVaccinationType(String vaccinationType) {
        switch (vaccinationType) {
            case "1": //重组新冠病毒疫苗（5型腺病毒载体）
                return 1;
            case "2": //新冠病毒灭活疫苗（Vero细胞）
                return 2;
            case "3": //重组新冠病毒疫苗（CHO细胞）
                return 3;
            default:
                logger.error("新冠疫苗类型错误");
                return 0;
        }
    }

    @Override
    public List<Long> getNcpVaccinationRecordIdList(Long personId) {
        return ncpVaccinationRecordMapper.selectNcpVaccinationRecordIdList(personId);
    }

    @Override
    public void deleteNcpVaccinationRecords(Long personId) {
        ncpVaccinationRecordMapper.deleteNcpVaccinationRecords(personId);
    }

}
