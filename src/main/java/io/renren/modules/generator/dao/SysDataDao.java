package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.SysDataEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 数据表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:14:11
 */
@Mapper
public interface SysDataDao extends BaseMapper<SysDataEntity> {

    void insert(@Param("param") Map map);

    List<Map> data(@Param("date") List<String> LastWeekDays);

}
