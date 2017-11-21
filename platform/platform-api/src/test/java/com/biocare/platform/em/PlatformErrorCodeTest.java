package com.biocare.platform.em;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlatformErrorCodeTest {
    @Test
    public void check() throws Exception {

        for (PlatformErrorCode platformErrorCode : PlatformErrorCode.values()) {
            platformErrorCode.check();
        }
    }

}