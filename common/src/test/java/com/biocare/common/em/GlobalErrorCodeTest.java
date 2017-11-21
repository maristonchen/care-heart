package com.biocare.common.em;

public class GlobalErrorCodeTest {
    @org.junit.Test
    public void check() throws Exception {

        for (GlobalErrorCode globalErrorCode : GlobalErrorCode.values()) {
            globalErrorCode.check();

        }
    }

}