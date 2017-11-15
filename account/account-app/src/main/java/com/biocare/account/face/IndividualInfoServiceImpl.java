package com.biocare.account.face;

import com.biocare.account.api.IndividualInfoService;
import com.biocare.account.bean.Individual;
import com.biocare.account.dto.IndividualInfo;
import com.biocare.account.query.IndividualQuery;
import com.biocare.account.service.base.IndividualService;
import com.yhxd.tools.base.collection.CollectionUtil;
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
@Service("individualInfoService")
public class IndividualInfoServiceImpl implements IndividualInfoService {

    /**
     * individual service interface
     */
    @Resource
    private IndividualService individualService;

    /**
     * query  Individual info by  his phone
     *
     * @param phone phone num
     * @return {@link IndividualInfo}
     */
    @Override
    public IndividualInfo query(String phone) {
        IndividualQuery query = new IndividualQuery();
        List<Individual> individuals = individualService.queryList(query);
        IndividualInfo individualInfo = null;
        if (CollectionUtil.isNotEmpty(individuals)) {
            individualInfo = new IndividualInfo();
            BeanUtils.copyProperties(individuals.get(0), individualInfo);
        }
        return individualInfo;
    }
}
