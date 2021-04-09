package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.SysDataDao;
import io.renren.modules.generator.entity.SysDataEntity;
import io.renren.modules.generator.service.SysDataService;


@Service("sysDataService")
public class SysDataServiceImpl extends ServiceImpl<SysDataDao, SysDataEntity> implements SysDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDataEntity> page = this.page(
                new Query<SysDataEntity>().getPage(params),
                new QueryWrapper<SysDataEntity>()
        );

        return new PageUtils(page);
    }

}