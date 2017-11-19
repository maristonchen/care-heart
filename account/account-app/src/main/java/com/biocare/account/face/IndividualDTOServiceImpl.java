package com.biocare.account.face;

import com.biocare.account.api.IndividualDTOService;
import com.biocare.account.bean.Individual;
import com.biocare.account.dto.IndividualDTO;
import com.biocare.account.query.IndividualQuery;
import com.biocare.account.service.IndividualService;
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
@Service("individualDTOService")
public class IndividualDTOServiceImpl implements IndividualDTOService {

    /**
     * individual service interface
     */
    @Resource
    private IndividualService individualService;

    /**
     * query  Individual info by  his phone
     *
     * @param phone phone num
     * @return {@link IndividualDTO}
     */
    @Override
    public IndividualDTO query(String phone) {
        IndividualQuery query = new IndividualQuery();
        List<Individual> individuals = individualService.queryList(query);
        IndividualDTO individualDTO = null;
        if (CollectionUtil.isNotEmpty(individuals)) {
            individualDTO = new IndividualDTO();
            BeanUtils.copyProperties(individuals.get(0), individualDTO);
        }
        return individualDTO;
    }
}
