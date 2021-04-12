package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.SysUsersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:16:51
 */
@Mapper
public interface SysUsersDao extends BaseMapper<SysUsersEntity> {
	
}
