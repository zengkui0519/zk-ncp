package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationPerson;
import com.zk.ncp.model.vo.NcpVaccinationPersonVo;

import java.util.List;

public interface NcpVaccinationPersonMapper {
    int deleteByPrimaryKey(Integer personId);

    int insert(NcpVaccinationPerson record);

    int insertSelective(NcpVaccinationPerson record);

    NcpVaccinationPerson selectByPrimaryKey(Integer personId);

    int updateByPrimaryKeySelective(NcpVaccinationPerson record);

    int updateByPrimaryKey(NcpVaccinationPerson record);

    List<NcpVaccinationPersonVo> selectNcpVaccinationPersonList(NcpVaccinationPersonVo personVo);

    void deleteNcpVaccinationPerson(Integer personId);
}