package io.renren.modules.generator.schedule;

import io.renren.modules.generator.service.SysDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class Task {

	@Resource
	private SysDataService sysDataService;

	/**
	 * 每日维度统计
	 */
	@Scheduled(cron = "0/10 * * * * *")
	public void url(){
		sysDataService.url();
	}

}
