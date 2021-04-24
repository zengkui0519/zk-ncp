package com.zk.ncp.model.vo;

import com.zk.ncp.model.NcpVaccinationRecord;
import lombok.Data;

import java.util.List;

@Data
public class NcpVaccinationRecordVO extends NcpVaccinationRecord {

    private List<NcpVaccinationDetailVO> ncpVaccinationDetailList;

}
