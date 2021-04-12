package io.renren.modules.generator.service.impl;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import io.renren.common.utils.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.generator.dao.SysDataDao;
import io.renren.modules.generator.entity.SysDataEntity;
import io.renren.modules.generator.service.SysDataService;
import io.renren.modules.generator.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysDataService")
public class SysDataServiceImpl extends ServiceImpl<SysDataDao, SysDataEntity> implements SysDataService {

    @Value("${zwfw.midurl.url}")
    private String url;

    @Override
    public R url() {

        System.out.println(url);

        Map map = HttpClientUtil.get(url);

        return R.ok(map);
    }
}