package io.renren.modules.generator.controller;

import io.renren.common.utils.R;
import io.renren.modules.generator.entity.SysDataEntity;
import io.renren.modules.generator.service.SysDataService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 数据表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:14:11
 */
@RestController
@RequestMapping("/generator/sysdata")
public class SysDataController {

    @Autowired
    private SysDataService sysDataService;

    /**
     * 获取OneNet云平台接口数据
     * @return
     */
    @GetMapping("/url")
    public R url() {

        return R.ok(sysDataService.url());
    }

    /**
     * 查询数据用于展示
     * @return
     */
    @GetMapping("/data")
    public R data(){

        List<Map> list = sysDataService.data();

        return R.ok(list);
    }

}
