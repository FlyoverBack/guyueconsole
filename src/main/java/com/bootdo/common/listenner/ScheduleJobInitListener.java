package com.bootdo.common.listenner;

import com.bootdo.common.redis.utils.MyStartupRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bootdo.common.quartz.utils.QuartzManager;
import com.bootdo.common.service.JobService;

@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {

	@Autowired
	JobService scheduleJobService;
	@Autowired
	MyStartupRunner myStartupRunner;

	@Autowired
	QuartzManager quartzManager;

	@Override
	public void run(String... arg0) throws Exception {
		try {
			scheduleJobService.initSchedule();
			//跟随服务启动自定义的方法
			myStartupRunner.setServletContext(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}