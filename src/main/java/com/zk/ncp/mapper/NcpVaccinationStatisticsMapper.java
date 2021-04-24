package com.zk.ncp.mapper;

import com.zk.ncp.model.NcpVaccinationAreaStatistics;
import com.zk.ncp.model.vo.NcpStatisticsRequestVO;
import com.zk.ncp.model.vo.NcpVaccinationAreaStatisticsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NcpVaccinationStatisticsMapper {

    List<NcpVaccinationAreaStatistics> selectAllCityLevelAreaIds();

    void insertAreaStatisticsList(List<NcpVaccinationAreaStatistics> list);

    /** 查询接种情况 */
    List<Map<String, Object>> queryVaccinationRecord(Map<String, Object> bean);

    /** 清空整个统计表 */
    int deleteAllOrgStatistics(Map<String, Object> bean);

    /** 批量新增数据 */
    int insertOrgStatisticsBatch(Map<String, Object> bean);

    /** 批量修改数据 */
    int updateOrgStatisticsBatch(Map<String, Object> bean);

    /** 查询接种统计结果 */
    List<Map<String, Object>> queryVaccinationStatistics(Map<String, Object> bean);

    /** 查询用户信息 */
    List<Map<String, Object>> queryUserInfo(Map<String, Object> bean);

    /** 查询所有已填报基础信息表的组织 **/
    List<Map<String, Object>> getAllOrgEmployeeNums(@Param("year") String year, @Param("quater") String quater);

    List<NcpVaccinationAreaStatisticsVO> selectCityLevelAreaStatistics(NcpStatisticsRequestVO requestVO);

    List<NcpVaccinationAreaStatisticsVO> selectProvinceLevelAreaStatistics(NcpStatisticsRequestVO requestVO);
}
