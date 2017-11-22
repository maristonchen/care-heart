package com.biocare.common.em;

import org.junit.Test;

public class GlobalErrorCodeTest {
    @Test
    public void check() throws Exception {

        for (GlobalErrorCode globalErrorCode : GlobalErrorCode.values()) {
            globalErrorCode.check();

        }
    }

    @Test
    public void toStringTest() {

        System.out.println(GlobalErrorCode.SUCCESS);

    }

}