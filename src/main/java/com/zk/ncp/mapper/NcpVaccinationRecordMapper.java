package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationRecord;

import java.util.List;

public interface NcpVaccinationRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(NcpVaccinationRecord record);

    int insertSelective(NcpVaccinationRecord record);

    NcpVaccinationRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(NcpVaccinationRecord record);

    int updateByPrimaryKey(NcpVaccinationRecord record);

    List<Integer> selectNcpVaccinationRecordIdList(Integer personId);

    void deleteNcpVaccinationRecords(Integer personId);
}