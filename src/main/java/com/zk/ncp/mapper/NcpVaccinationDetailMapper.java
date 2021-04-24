package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationDetail;
import com.zk.ncp.model.vo.NcpVaccinationDetailVO;

import java.util.List;

public interface NcpVaccinationDetailMapper {

    int insert(NcpVaccinationDetail record);

    int updateByPrimaryKey(NcpVaccinationDetail record);

    void deleteNcpVaccinationDetailsByRecordId(Long recordId);

    List<NcpVaccinationDetailVO> selectNcpVaccinationDetailList(Long recordId);

}




