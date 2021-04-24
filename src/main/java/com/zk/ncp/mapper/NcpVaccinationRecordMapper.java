package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationRecord;
import com.zk.ncp.model.vo.NcpVaccinationRecordVO;

import java.util.List;

public interface NcpVaccinationRecordMapper {

    int insert(NcpVaccinationRecord record);

    int updateByPrimaryKey(NcpVaccinationRecord record);

    List<Long> selectNcpVaccinationRecordIdList(Long personId);

    List<NcpVaccinationRecordVO> selectNcpVaccinationRecordList(Long personId);

    void deleteNcpVaccinationRecords(Long personId);

}




