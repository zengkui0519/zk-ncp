package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationPerson;
import com.zk.ncp.model.vo.NcpVaccinationParamsVO;
import com.zk.ncp.model.vo.NcpVaccinationPersonVO;

import java.util.List;
import java.util.Map;

public interface NcpVaccinationPersonMapper {

    int insert(NcpVaccinationPerson record);

    int updateByPrimaryKey(NcpVaccinationPerson record);

    List<NcpVaccinationPersonVO> selectNcpVaccinationPersonList(NcpVaccinationParamsVO paramsVO);

    void deleteNcpVaccinationPerson(Long personId);

    NcpVaccinationPersonVO selectNcpVaccinationPerson(Map<String, Object> params);

    int selectTheNumberOfVaccinatedPeople(NcpVaccinationParamsVO paramsVO);
}




