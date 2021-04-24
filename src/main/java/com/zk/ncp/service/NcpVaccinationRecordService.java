package com.zk.ncp.service;

import com.zk.ncp.model.vo.NcpVaccinationRecordVO;

import java.util.List;

public interface NcpVaccinationRecordService {

    boolean saveNcpVaccinationRecordAndDetail(Long personId, List<NcpVaccinationRecordVO> ncpVaccinationRecordList);

    List<Long> getNcpVaccinationRecordIdList(Long personId);

    void deleteNcpVaccinationRecords(Long personId);
}
