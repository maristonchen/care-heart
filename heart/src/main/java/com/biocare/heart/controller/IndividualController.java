package com.biocare.heart.controller;

import com.biocare.account.api.IndividualDTOService;
import com.biocare.account.query.IndividualQuery;
import com.biocare.common.bean.RequestWrapper;
import com.biocare.common.bean.ResponseWrapper;
import com.biocare.heart.vo.IndividualVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/22 21:49
 */
@Controller
@RequestMapping("/individual")
public class IndividualController {

    /**
      *  system log
      */
    private Logger logger = LoggerFactory.getLogger(IndividualController.class);

    @Resource
    private IndividualDTOService individualDTOService;

    @RequestMapping("/query")
    @ResponseBody
    IndividualVO queryIndividual() {
        IndividualQuery query = new IndividualQuery();
//        query.setName("testName");
//        ResponseWrapper responseWrapper = individualDTOService.queryOneByCondition(RequestWrapper.create(query));
//        logger.info("Response wrapper is {}",responseWrapper);
        IndividualVO individualVO = new IndividualVO();
        individualVO.setEmail("maristonchen@126.com");
//        individualVO.setName("mariston");
        return individualVO;
    }
}
