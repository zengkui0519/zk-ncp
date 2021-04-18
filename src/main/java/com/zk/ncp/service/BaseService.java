package com.zk.ncp.service;

import com.zk.ncp.model.base.SysUser;

public interface BaseService {

    SysUser getUser(String token);

}
