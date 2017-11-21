package com.biocare.account.em;

public class ACErrorCodeTest {
    @org.junit.Test
    public void check() throws Exception {
        for (AccountErrorCode acErrorCode : AccountErrorCode.values()) {
            acErrorCode.check();
        }
    }

}