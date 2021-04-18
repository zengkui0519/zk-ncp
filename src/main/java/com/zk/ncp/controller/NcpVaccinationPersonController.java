package com.zk.ncp.controller;

import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.model.vo.NcpVaccinationPersonVo;
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
     * @return ResultMessage
     * @author zengkui
     * @date 2021/4/18 11:56 下午
     */
    @PostMapping(value = "/getNcpVaccinationPersonList")
    public ResultMessage getNcpVaccinationPersonList(@RequestHeader("token") String token, @RequestBody NcpVaccinationPersonVo personVo) {
        SysUser user = baseService.getUser(token);
        return ResultMessage.success(ncpVaccinationPersonService.getNcpVaccinationPersonList(user, personVo));
    }

    /**
     * @description 保存或更新新冠疫苗接种人员情况
     * @param token
     * @return ResultMessage
     * @author zengkui
     * @date 2021/4/18 11:56 下午
     */
    @PostMapping(value = "/saveOrUpdateNcpVaccinationPerson")
    public ResultMessage saveOrUpdateNcpVaccinationPerson(@RequestHeader("token") String token, @RequestBody NcpVaccinationPersonVo personVo) {
        SysUser user = baseService.getUser(token);
        Map<String, Object> result = ncpVaccinationPersonService.saveOrUpdateNcpVaccinationPerson(user, personVo);

        if (SysConstants.Public.SUCCESS.equals(result.get("message") + "")) {
            logger.info("保存或更新新冠疫苗接种人员情况成功");
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result.get("message") + "");
    }

    /**
     * @description 删除新冠疫苗接种人员情况
     * @param personId
     * @return ResultMessage
     * @author zengkui
     * @date 2021/4/18 11:56 下午
     */
    @PostMapping(value = "/deleteNcpVaccinationPerson")
    public ResultMessage deleteNcpVaccinationPerson(Integer personId) {
        boolean result = ncpVaccinationPersonService.deleteNcpVaccinationPerson(personId);
        return ResultMessage.success(result);
    }
}
