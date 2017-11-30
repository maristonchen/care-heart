package com.biocare.platform.service.impl;

import com.biocare.platform.bean.Banner;
import com.biocare.platform.query.BannerQuery;
import com.biocare.platform.service.BannerService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-global.xml"})
public class BannerServiceImplTest {

    @Resource
    private BannerService bannerService ;

    @Test
    public void queryList() throws Exception {
        BannerQuery bannerQuery = new BannerQuery();
        BannerQuery.Criteria criteria = bannerQuery.createCriteria();
//        criteria.andLike("picUrl", "localhost:80");
        criteria.andEqualTo("systemId", "platform");


        List<Banner> bannerList = bannerService.queryList(bannerQuery,Banner.class);
        System.out.println(bannerList);
    }

    @Test
    public void save() throws Exception {
        Banner banner = new Banner();
        banner.setBannerId(RandomStringUtils.random(12,true,true));
        banner.setPicUrl("http://localhost:80/b.jpg");
        banner.setSystemId("platform");
        bannerService.save(banner);
    }

}