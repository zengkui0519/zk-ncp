package com.zk.ncp.model.vo;

import com.zk.ncp.model.NcpVaccinationDetail;
import com.zk.ncp.model.NcpVaccinationRecord;
import lombok.Data;

import java.util.List;

@Data
public class NcpVaccinationRecordVo extends NcpVaccinationRecord {

    private List<NcpVaccinationDetail> ncpVaccinationDetailList;

}
