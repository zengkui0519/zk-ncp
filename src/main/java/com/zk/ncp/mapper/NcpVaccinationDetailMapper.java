package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationDetail;

public interface NcpVaccinationDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(NcpVaccinationDetail record);

    NcpVaccinationDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(NcpVaccinationDetail record);

    int updateByPrimaryKey(NcpVaccinationDetail record);

    void deleteNcpVaccinationDetailsByRecordId(Integer recordId);

}