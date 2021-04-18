package com.zk.ncp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zk.ncp.mapper.NcpVaccinationPersonMapper;
import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.model.vo.NcpVaccinationPersonVo;
import com.zk.ncp.service.NcpVaccinationDetailService;
import com.zk.ncp.service.NcpVaccinationPersonService;
import com.zk.ncp.service.NcpVaccinationRecordService;
import com.zk.ncp.utils.SysConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String, Object> getNcpVaccinationPersonList(SysUser user, NcpVaccinationPersonVo personVo) {
        Page<Object> page = PageHelper.startPage(1, 20);
        List<NcpVaccinationPersonVo> dataList = ncpVaccinationPersonMapper.selectNcpVaccinationPersonList(personVo);

        Map<String, Object> result = new HashMap<>();
        result.put(SysConstants.Public.DATA_LIST, dataList);
        result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> saveOrUpdateNcpVaccinationPerson(SysUser user, NcpVaccinationPersonVo personVo) {
        Date now = new Date();
        boolean saveOrUpdateResult;
        if (null == personVo.getPersonId()) {
            personVo.setCreateTime(now);
            personVo.setCreateUser(user.getUserCode());
            personVo.setUpdateTime(now);
            personVo.setUpdateUser(user.getUserCode());
            // 保存人员信息
            saveOrUpdateResult = ncpVaccinationPersonMapper.insert(personVo) > 0;
        } else {
            personVo.setUpdateTime(now);
            personVo.setUpdateUser(user.getUserCode());
            // 更新人员信息
            saveOrUpdateResult = ncpVaccinationPersonMapper.updateByPrimaryKey(personVo) > 0;
        }

        Map<String, Object> result = new ConcurrentHashMap<>();
        boolean saveRecordAndDetailResult;
        if (saveOrUpdateResult) {
            saveRecordAndDetailResult = ncpVaccinationRecordService.saveNcpVaccinationRecordAndDetail(personVo.getPersonId(), personVo.getNcpVaccinationRecordList());
        } else {
            result.put("msg", "保存用户基本信息失败");
            return result;
        }

        if (saveRecordAndDetailResult) {
            result.put("personId", personVo.getPersonId());
            result.put("msg", "SUCCESS");
            return result;
        }

        result.put("msg", "保存用户新冠疫苗接种记录或详情失败");
        return result;
    }

    @Override
    public boolean deleteNcpVaccinationPerson(Integer personId) {
        if (null == personId) {
            logger.info("personId is null");
            return false;
        }

        List<Integer> recordIdList = ncpVaccinationRecordService.getNcpVaccinationRecordIdList(personId);
        if (!CollectionUtils.isEmpty(recordIdList)) {
            ncpVaccinationDetailService.deleteNcpVaccinationDetails(recordIdList);
            ncpVaccinationRecordService.deleteNcpVaccinationRecords(personId);
        }

        ncpVaccinationPersonMapper.deleteNcpVaccinationPerson(personId);
        return true;
    }

}
