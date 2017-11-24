package com.biocare.account.face;

import com.biocare.account.api.IndividualDTOService;
import com.biocare.account.bean.Individual;
import com.biocare.account.dto.IndividualDTO;
import com.biocare.account.query.IndividualQuery;
import com.biocare.account.service.IndividualService;
import com.biocare.common.bean.RequestWrapper;
import com.biocare.common.bean.ResponseWrapper;
import com.biocare.common.em.GlobalErrorCode;
import com.yhxd.tools.base.collection.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 13:35
 */
@Service("individualDTOService")
public class IndividualDTOServiceImpl implements IndividualDTOService {

    /**
      *  system log
      */
    private Logger logger = LoggerFactory.getLogger(IndividualDTOServiceImpl.class);

    /**
     * individual service interface
     */
    @Resource
    private IndividualService individualService;

    /**
     * query  Individual info by  his phone
     *
     * @param request request
     * @return {@link ResponseWrapper}
     */
    @Override
    public ResponseWrapper queryOneByCondition(RequestWrapper request) {
        ResponseWrapper wrapper;
        try {
            IndividualQuery query = request.getContent(IndividualQuery.class);
            List<Individual> individuals = individualService.queryList(query);
            IndividualDTO individualDTO = null;
            if (CollectionUtil.isNotEmpty(individuals)) {
                individualDTO = new IndividualDTO();
                BeanUtils.copyProperties(individuals.get(0), individualDTO);
            }
            wrapper = ResponseWrapper.create(GlobalErrorCode.SUCCESS, individualDTO);
        } catch (Exception e) {
            logger.error("Query individual info occurs an error ,that is [{}:{}]",e.getStackTrace()[0],e.getMessage());
            wrapper = ResponseWrapper.create(e);
        }
        return wrapper;
    }

}
