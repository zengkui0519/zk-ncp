package com.zk.ncp.model;

import java.beans.Transient;
import java.io.Serializable;

public class BasePageRequest implements Serializable {

    private static final long serialVersionUID = 2946171514847303726L;

    // 分页索引, 从1开始
    private Integer start = 1;

    /**
     * 分页大小(支持不分页的查询，eg查询完整的表格树, 所以pageSize初始化为Null)
     * 如因pageSize为null报异常，请先自行判断pageSize为什么会null
     * 如果允许为null且数据量不大，则可不做分页查询只做排序PageHelper.orderby()
     * 如果不允许为null且数据量很大，请问问为什么从前端请求时不传入分页参数pageSize?
     */
    private Integer limit = 20;

    private Integer startNew = 0;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = (start/this.limit)+1;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStartNew() {
        return startNew;
    }

    public void setStartNew(Integer startNew) {
        this.startNew = startNew;
    }
}