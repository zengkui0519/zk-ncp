package com.zk.ncp.utils;

/**
 * @author zengkui
 * @description 系统常量类（跟业务没有关联）
 * @date 2021/4/11 12:04 上午
 */
public interface SysConstants {

    class Public {
        // 有效
        public static final String A = "A";

        // 无效
        public static final String I = "I";

        // 查询结果返回给前台计数使用
        public static final String DATA_LIST = "dataList";

        // 查询结果返回给前台计数使用
        public static final String TOTAL_COUNT = "totalCount";

        // 查询结果成功描述
        public static final String SUCCESS = "SUCCESS";

        // 登录token过期时间
        public final static int TOKEN_EXPIRE_SECOND = 60 * 30;
    }

}
