package com.biocare.institute.em;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstituteErrorCodeTest {
    @Test
    public void check() throws Exception {

        for (InstituteErrorCode instituteErrorCode : InstituteErrorCode.values()) {
            instituteErrorCode.check();
            
        }
    }

}