package com.zk.ncp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zk.ncp.mapper.NcpVaccinationPersonMapper;
import com.zk.ncp.model.NcpVaccinationDetail;
import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.model.vo.NcpVaccinationDetailVO;
import com.zk.ncp.model.vo.NcpVaccinationParamsVO;
import com.zk.ncp.model.vo.NcpVaccinationPersonVO;
import com.zk.ncp.model.vo.NcpVaccinationRecordVO;
import com.zk.ncp.service.NcpVaccinationDetailService;
import com.zk.ncp.service.NcpVaccinationPersonService;
import com.zk.ncp.service.NcpVaccinationRecordService;
import com.zk.ncp.utils.SysConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NcpVaccinationPersonServiceImpl implements NcpVaccinationPersonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NcpVaccinationPersonMapper ncpVaccinationPersonMapper;

    @Resource
    private NcpVaccinationRecordService ncpVaccinationRecordService;

    @Resource
    private NcpVaccinationDetailService ncpVaccinationDetailService;

    @Override
    public Map<String, Object> getNcpVaccinationPersonList(SysUser user, NcpVaccinationParamsVO params) {
        if (null == params.getOrgId()) {
            params.setUserId(user.getUserId());
        }
        Page<Object> page = PageHelper.startPage(params.getStart(), params.getLimit());
        List<NcpVaccinationPersonVO> dataList = ncpVaccinationPersonMapper.selectNcpVaccinationPersonList(params);

        Map<String, Object> result = new HashMap<>();
        result.put(SysConstants.Public.DATA_LIST, dataList);
        result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
        return result;
    }

    @Override
    public int viewTheNumberOfVaccinatedPeople(SysUser user, NcpVaccinationParamsVO params) {
        if (null == params.getOrgId()) {
            params.setUserId(user.getUserId());
        }
        return ncpVaccinationPersonMapper.selectTheNumberOfVaccinatedPeople(params);
    }

    @Override
    public Map<String, Object> saveOrUpdateNcpVaccinationPerson(SysUser user, NcpVaccinationPersonVO personVO) {
        Date now = new Date();
        boolean saveOrUpdateResult;
        if (null == personVO.getPersonId()) {
            personVO.setCreateTime(now);
            personVO.setCreateUser(user.getUserCode());
            personVO.setUpdateTime(now);
            personVO.setUpdateUser(user.getUserCode());
            // 保存人员信息
            saveOrUpdateResult = ncpVaccinationPersonMapper.insert(personVO) > 0;
        } else {
            personVO.setUpdateTime(now);
            personVO.setUpdateUser(user.getUserCode());
            // 更新人员信息
            saveOrUpdateResult = ncpVaccinationPersonMapper.updateByPrimaryKey(personVO) > 0;
        }

        Map<String, Object> result = new ConcurrentHashMap<>();
        boolean saveRecordAndDetailResult;
        if (saveOrUpdateResult) {
            saveRecordAndDetailResult = ncpVaccinationRecordService.saveNcpVaccinationRecordAndDetail(personVO.getPersonId(), personVO.getNcpVaccinationRecordList());
        } else {
            result.put("msg", "保存用户基本信息失败");
            return result;
        }

        if (saveRecordAndDetailResult) {
            result.put("personId", personVO.getPersonId());
            result.put("msg", "SUCCESS");
            return result;
        }

        result.put("msg", "保存用户新冠疫苗接种记录或详情失败");
        return result;
    }

    @Override
    public Map<String, Object> saveNcpVaccinationRecord(NcpVaccinationRecordVO recordVO) {
        List<NcpVaccinationRecordVO> ncpVaccinationRecordList = new ArrayList<>();
        ncpVaccinationRecordList.add(recordVO);

        Map<String, Object> result = new HashMap<>();
        if (ncpVaccinationRecordService.saveNcpVaccinationRecordAndDetail(recordVO.getPersonId(), ncpVaccinationRecordList)) {
            result.put("msg", "SUCCESS");
            return result;
        }
        result.put("msg", "保存人员某种新冠疫苗接种情况失败");
        return result;
    }

    @Override
    public Map<String, Object> saveNcpVaccinationDetail(NcpVaccinationDetail detail) {
        List<NcpVaccinationDetailVO> detailList = new ArrayList<>();
        detailList.add((NcpVaccinationDetailVO) detail);

        Map<String, Object> result = new HashMap<>();
        if (ncpVaccinationDetailService.saveNcpVaccinationDetailList(detail.getRecordId(), detailList)) {
            result.put("msg", "SUCCESS");
            return result;
        }
        result.put("msg", "保存某种新冠疫苗接种详情失败");
        return result;
    }

    @Override
    public boolean deleteNcpVaccinationPerson(Long personId) {
        if (null == personId) {
            logger.info("personId is null");
            return false;
        }

        List<Long> recordIdList = ncpVaccinationRecordService.getNcpVaccinationRecordIdList(personId);
        if (!CollectionUtils.isEmpty(recordIdList)) {
            ncpVaccinationDetailService.deleteNcpVaccinationDetails(recordIdList);
            ncpVaccinationRecordService.deleteNcpVaccinationRecords(personId);
        }

        ncpVaccinationPersonMapper.deleteNcpVaccinationPerson(personId);
        return true;
    }

    @Override
    public NcpVaccinationPersonVO getNcpVaccinationPersonByUserCode(String userCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("userCode", userCode.toUpperCase());
        return ncpVaccinationPersonMapper.selectNcpVaccinationPerson(params);
    }

    @Override
    public NcpVaccinationPersonVO getNcpVaccinationPersonByPersonId(Long personId) {
        Map<String, Object> params = new HashMap<>();
        params.put("personId", personId);
        return ncpVaccinationPersonMapper.selectNcpVaccinationPerson(params);
    }

}
