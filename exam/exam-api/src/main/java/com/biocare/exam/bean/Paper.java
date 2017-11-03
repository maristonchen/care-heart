package com.biocare.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Test paper
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 15:43
 */
public class Paper implements Serializable {


    private static final long serialVersionUID = -4390117930297108995L;


    /**
     * questions
     */
    private List<Question> questions;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
