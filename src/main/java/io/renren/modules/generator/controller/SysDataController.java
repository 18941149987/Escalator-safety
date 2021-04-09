package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.SysDataEntity;
import io.renren.modules.generator.service.SysDataService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 数据表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 15:14:11
 */
@RestController
@RequestMapping("generator/sysdata")
public class SysDataController {
    @Autowired
    private SysDataService sysDataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysdata:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:sysdata:info")
    public R info(@PathVariable("id") Integer id){
		SysDataEntity sysData = sysDataService.getById(id);

        return R.ok().put("sysData", sysData);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysdata:save")
    public R save(@RequestBody SysDataEntity sysData){
		sysDataService.save(sysData);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysdata:update")
    public R update(@RequestBody SysDataEntity sysData){
		sysDataService.updateById(sysData);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysdata:delete")
    public R delete(@RequestBody Integer[] ids){
		sysDataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
