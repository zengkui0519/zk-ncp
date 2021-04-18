package com.zk.ncp.model.vo;

import com.zk.ncp.model.NcpVaccinationPerson;
import lombok.Data;

import java.util.List;

@Data
public class NcpVaccinationPersonVo extends NcpVaccinationPerson {

    List<NcpVaccinationRecordVo> ncpVaccinationRecordList;

}
