package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.SysUsersDao;
import io.renren.modules.generator.entity.SysUsersEntity;
import io.renren.modules.generator.service.SysUsersService;


@Service("sysUsersService")
public class SysUsersServiceImpl extends ServiceImpl<SysUsersDao, SysUsersEntity> implements SysUsersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}