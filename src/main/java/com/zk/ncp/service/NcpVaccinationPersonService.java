package com.zk.ncp.service;

import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.model.vo.NcpVaccinationPersonVo;

import java.util.Map;

public interface NcpVaccinationPersonService {

    Map<String, Object> getNcpVaccinationPersonList(SysUser user, NcpVaccinationPersonVo personVo);

    Map<String, Object> saveOrUpdateNcpVaccinationPerson(SysUser user, NcpVaccinationPersonVo personVo);

    boolean deleteNcpVaccinationPerson(Integer personId);
}
