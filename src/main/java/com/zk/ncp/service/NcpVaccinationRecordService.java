package com.zk.ncp.service;

import com.zk.ncp.model.vo.NcpVaccinationRecordVo;

import java.util.List;

public interface NcpVaccinationRecordService {

    boolean saveNcpVaccinationRecordAndDetail(Integer personId, List<NcpVaccinationRecordVo> ncpVaccinationRecordList);

    List<Integer> getNcpVaccinationRecordIdList(Integer personId);

    void deleteNcpVaccinationRecords(Integer personId);
}
