package com.zk.ncp.service.impl;

import com.zk.ncp.model.base.SysUser;
import com.zk.ncp.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public SysUser getUser(String token) {
        SysUser user = new SysUser();
        user.setUserId(1l);
        user.setUserCode("zengkui");
        user.setUserName("曾魁");

        return user;
    }

    @Override
    public SysUser getUserByUserCode(String userCode) {
        SysUser user = new SysUser();
        user.setUserId(1l);
        user.setUserCode("zengkui");
        user.setUserName("曾魁");

        return user;
    }
}
