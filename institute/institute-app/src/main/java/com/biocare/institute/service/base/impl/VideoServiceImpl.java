package com.biocare.institute.service.base.impl;

import com.biocare.institute.bean.Video;
import com.biocare.institute.query.VideoQuery;
import com.biocare.institute.service.base.VideoService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 8:11
 */
@Service("videoService")
public class VideoServiceImpl extends AbstractBaseService<Video, VideoQuery> implements VideoService {


    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Video, VideoQuery> getMapper() {
        return null;
    }
}
