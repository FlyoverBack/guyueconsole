package com.bootdo.common.redis.utils;

import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyStartupRunner{
    private static final Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);
    @Autowired
    private DictService dictService;
    public static List<DictDO> initDataList = new ArrayList<>();

    public void setServletContext(ServletContext servletContext) {
        //跟随服务启动加载系统数据字典列表
        Map<String, Object> map = new HashMap<>();
        logger.info("*******************一条长长的分割线，开始加载数据字典数据*********************");
        initDataList = dictService.list(map);
        logger.info("===================================================获取数据共计："+initDataList.size()+"条");
        logger.info("*******************一条长长的分割线，加载数据字典数据结束*********************");
    }
}
