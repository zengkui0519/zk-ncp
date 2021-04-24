package com.zk.ncp.controller;

import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.model.vo.NcpVaccinationParamsVO;
import com.zk.ncp.model.vo.NcpVaccinationPersonVO;
import com.zk.ncp.service.BaseService;
import com.zk.ncp.service.NcpVaccinationPersonService;
import com.zk.ncp.utils.ResultMessage;
import com.zk.ncp.utils.SysConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description 新冠疫苗接种人员情况接口
 * @author zengkui
 * @date 2021/4/15 3:40 下午
 */
@RestController
@RequestMapping("/ncpVaccinationPerson")
public class NcpVaccinationPersonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NcpVaccinationPersonService ncpVaccinationPersonService;

    @Resource
    private BaseService baseService;

    /**
     * @description 新冠疫苗接种人员情况列表分页查询
     * @param token
     * @param paramsVO
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:21 下午
     */
    @PostMapping(value = "/getNcpVaccinationPersonList")
    public ResultMessage getNcpVaccinationPersonList(@RequestHeader("token") String token, NcpVaccinationParamsVO paramsVO) {
        SysUser user = baseService.getUser(token);
        return ResultMessage.success(ncpVaccinationPersonService.getNcpVaccinationPersonList(user, paramsVO));
    }

    /**
     * @description 查询用户能看到的列表的已接种人数
     * @param token
     * @param paramsVO
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:21 下午
     */
    @PostMapping(value = "/viewTheNumberOfVaccinatedPeople")
    public ResultMessage viewTheNumberOfVaccinatedPeople(@RequestHeader("token") String token, NcpVaccinationParamsVO paramsVO) {
        SysUser user = baseService.getUser(token);
        return ResultMessage.success(ncpVaccinationPersonService.viewTheNumberOfVaccinatedPeople(user, paramsVO));
    }

    /**
     * @description 保存或更新新冠疫苗接种人员情况
     * @param token
     * @param personVO
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:23 下午
     */
    @PostMapping(value = "/saveOrUpdateNcpVaccinationPerson")
    public ResultMessage saveOrUpdateNcpVaccinationPerson(@RequestHeader("token") String token, @RequestBody NcpVaccinationPersonVO personVO) {
        SysUser user = baseService.getUser(token);
        if (null == user) {
            // 没有token就是从rest转发过来的请求
            user = baseService.getUserByUserCode(personVO.getUserCode().toUpperCase());
        }
        Map<String, Object> result = ncpVaccinationPersonService.saveOrUpdateNcpVaccinationPerson(user, personVO);

        if (SysConstants.Public.SUCCESS.equals(result.get("msg").toString())) {
            logger.info("保存或更新新冠疫苗接种人员情况成功");
            return ResultMessage.success(result);
        }
        return ResultMessage.success(result.get("msg").toString());
    }

    /**
     * @description 通过personId查询新冠疫苗接种人员情况（PC）
     * @param personId
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:24 下午
     */
    @GetMapping(value = "/getNcpVaccinationPersonByPersonId")
    public ResultMessage getNcpVaccinationPersonByPersonId(Long personId) {
        logger.info("getNcpVaccinationPersonByPersonId personId: {}" + personId);
        NcpVaccinationPersonVO result = ncpVaccinationPersonService.getNcpVaccinationPersonByPersonId(personId);
        return ResultMessage.success(result);
    }

    /**
     * @description 通过userCode查询新冠疫苗接种人员情况（移动端）
     * @param userCode
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:25 下午
     */
    @GetMapping(value = "/getNcpVaccinationPersonByUserCode")
    public ResultMessage getNcpVaccinationPersonByUserCode(String userCode) {
        logger.info("getNcpVaccinationPersonByUserCode userCode: {}" + userCode);
        NcpVaccinationPersonVO result = ncpVaccinationPersonService.getNcpVaccinationPersonByUserCode(userCode);
        return ResultMessage.success(result);
    }

    /**
     * @description 删除新冠疫苗接种人员情况
     * @param personId
     * @return com.zk.ncp.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/23 10:26 下午
     */
    @PostMapping(value = "/deleteNcpVaccinationPerson")
    public ResultMessage deleteNcpVaccinationPerson(Long personId) {
        boolean result = ncpVaccinationPersonService.deleteNcpVaccinationPerson(personId);
        return ResultMessage.success(result);
    }
}
