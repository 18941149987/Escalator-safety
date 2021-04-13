package io.renren.modules.generator.service.impl;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.renren.common.utils.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.generator.dao.SysDataDao;
import io.renren.modules.generator.entity.SysDataEntity;
import io.renren.modules.generator.service.SysDataService;
import io.renren.modules.generator.utils.DayUtil;
import io.renren.modules.generator.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


@Service("sysDataService")
public class SysDataServiceImpl extends ServiceImpl<SysDataDao, SysDataEntity> implements SysDataService {

    // 如果设备在线
    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;

    @Autowired
    private SysDataDao sysDataDao;

    @Value("${zwfw.midurl.url}")
    private String url;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R url() {

        System.out.println(url);
        System.out.println("定时任务");

        Map map = HttpClientUtil.get(url);

        // 获取数据 JSON 转 Map
        Map data = JSON.parseObject(String.valueOf(map.get("data")));

        // 获取当前设备是否在线
        boolean status = Convert.toBool(data.get("online"));

        // 获取数据
        Map map2 = new HashMap();

        // 如果设备处于在线状态
        if (status == ONLINE) {
            // 获取数据
            List<Map> list = (List<Map>) data.get("datastreams");

            for(Map map1 : list) {
                if (Objects.isNull(map1.get("unit")) || ("").equals(map1.get("unit"))) {
                    map1.put("unit", "0");
                }
                if (Objects.isNull(map1.get("unit_symbol")) || ("").equals(map1.get("unit_symbol"))) {
                    map1.put("unit_symbol", "0");
                }

                // 组装数据
                map2.put(map1.get("id"), map1.get("unit"));
            }

            // 获取当前系统时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map2.put("create_time", df.format(new Date()));

            // 存入数据库
            sysDataDao.insert(map2);

        }

        return R.ok(data);
    }


    @Override
    public R data(){

        // 组装返回数据格式
        Map mapData = new HashMap();

        // 获取近七天日期
        List<String> LastWeekDays = DayUtil.LastWeekDays(7);
        // echars日期数组
        List<String> dateList = new ArrayList<>();
        List<String> smokList = new ArrayList<>();
        List<String> shockList = new ArrayList<>();
        List<String> temperatureList = new ArrayList<>();
        List<String> pressureList = new ArrayList<>();
        List<String> flameList = new ArrayList<>();
        // 获取全部数据
        List<Map> data = sysDataDao.data(LastWeekDays);
        // 获取日期
        for (Map map : data) {
            dateList.add(Convert.toStr(map.get("ctime")));
            smokList.add(Convert.toStr(map.get("smok")));
            shockList.add(Convert.toStr(map.get("shock")));
            temperatureList.add(Convert.toStr(map.get("temperature")));
            pressureList.add(Convert.toStr(map.get("pressure")));
            flameList.add(Convert.toStr(map.get("flame")));
        }

//        mapData.put("data", data);
        mapData.put("date", dateList);
        mapData.put("smokList", smokList);
        mapData.put("shockList", shockList);
        mapData.put("temperatureList", temperatureList);
        mapData.put("pressureList", pressureList);
        mapData.put("flameList", flameList);

        return R.ok().put("data", mapData);
    }
}