package com.biocare.common.dubbo;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.biocare.common.bean.RequestWrapper;
import com.biocare.common.bean.ResponseWrapper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * kryo serialization class
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/2 16:55
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<>();
        classes.add(RequestWrapper.class);
        classes.add(ResponseWrapper.class);
        return classes;
    }
}
