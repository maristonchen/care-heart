package com.biocare.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.biocare.platform.bean.Banner;
import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.mapper.BannerMapper;
import com.biocare.platform.query.BannerQuery;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.query.TemplateTableQuery;
import com.biocare.platform.service.BannerService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.query.BaseQuery;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import com.yhxd.tools.web.page.DTPage;
import com.yhxd.tools.web.result.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:38
 */
@Service("bannerService")
public class BannerServiceImpl extends AbstractBaseService<Banner, BannerQuery> implements BannerService {

    /**
     * banner mapper
     */
    @Resource
    private BannerMapper bannerMapper;

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Banner, BannerQuery> getMapper() {
        return this.bannerMapper;
    }


    /**
     * 分页动态条件查询（列表展示用）
     * @param
     * @return
     */
    @Override
    public JsonResult queryDynamic(){
        //根据vo构造query
        BannerQuery bannerQuery = new BannerQuery();

        BaseQuery.Criteria criteria = bannerQuery.createCriteria();

        //分页
        DTPage<Banner> dtPage = new DTPage<Banner>();
        dtPage.setStart(0);
        dtPage.setLength(10);

        List<Banner> bannerList = queryList(bannerQuery,Banner.class);
        dtPage.handler(bannerList);
        //查询总数
        int count = queryCount(bannerQuery);
        System.out.println(JSON.toJSONString(bannerList));
        return new JsonResult(200, "获取列表数据成功",dtPage.getData(), count);
    }
}
