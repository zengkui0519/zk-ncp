package com.zk.ncp.model.vo;

import com.zk.ncp.model.NcpVaccinationPerson;
import lombok.Data;

import java.util.List;

@Data
public class NcpVaccinationPersonVO extends NcpVaccinationPerson {

    List<NcpVaccinationRecordVO> ncpVaccinationRecordList;

    private Long userId;

    private String workProvinceName;

    private String workCityName;

}
