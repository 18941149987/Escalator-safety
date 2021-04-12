package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.SysUsersEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:16:51
 */
public interface SysUsersService extends IService<SysUsersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

