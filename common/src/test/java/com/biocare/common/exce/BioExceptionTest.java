package com.biocare.common.exce;

import com.biocare.common.em.GlobalErrorCode;
import com.biocare.common.exception.BioException;
import org.junit.Test;

public class BioExceptionTest {
    @Test
    public void toStringTest() {
        BioException e = new BioException(GlobalErrorCode.SUCCESS);
        System.out.println(e);
        BioException bioException = new BioException("null");
        System.out.println(bioException);

    }

}