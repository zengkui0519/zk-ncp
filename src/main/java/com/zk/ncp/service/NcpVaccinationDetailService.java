package com.zk.ncp.service;

import com.zk.ncp.model.vo.NcpVaccinationDetailVO;

import java.util.List;

public interface NcpVaccinationDetailService {

    boolean saveNcpVaccinationDetailList(Long recordId, List<NcpVaccinationDetailVO> ncpVaccinationDetailList);

    void deleteNcpVaccinationDetails(List<Long> recordIdList);

    void deleteNcpVaccinationDetails(Long recordId);
}
