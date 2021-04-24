package com.zk.ncp.service;

import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.model.vo.NcpVaccinationParamsVO;
import com.zk.ncp.model.vo.NcpVaccinationPersonVO;

import java.util.Map;

public interface NcpVaccinationPersonService {

    Map<String, Object> getNcpVaccinationPersonList(SysUser user, NcpVaccinationParamsVO params);

    int viewTheNumberOfVaccinatedPeople(SysUser user, NcpVaccinationParamsVO params);

    Map<String, Object> saveOrUpdateNcpVaccinationPerson(SysUser user, NcpVaccinationPersonVO personVO);

    boolean deleteNcpVaccinationPerson(Long personId);

    NcpVaccinationPersonVO getNcpVaccinationPersonByUserCode(String userCode);

    NcpVaccinationPersonVO getNcpVaccinationPersonByPersonId(Long personId);

}
