package io.renren.modules.generator.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.SysDataEntity;

/**
 * 数据表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:14:11
 */
public interface SysDataService extends IService<SysDataEntity> {

    R url();

}

