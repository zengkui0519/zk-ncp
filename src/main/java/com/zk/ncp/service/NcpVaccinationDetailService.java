package com.zk.ncp.service;

import com.zk.ncp.model.NcpVaccinationDetail;

import java.util.List;

public interface NcpVaccinationDetailService {

    boolean saveNcpVaccinationDetailList(Integer recordId, List<NcpVaccinationDetail> ncpVaccinationDetailList);

    void deleteNcpVaccinationDetails(List<Integer> recordIdList);

    void deleteNcpVaccinationDetails(Integer recordId);
}
