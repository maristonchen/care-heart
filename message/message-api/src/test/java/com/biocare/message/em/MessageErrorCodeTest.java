package com.biocare.message.em;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageErrorCodeTest {
    @Test
    public void check() throws Exception {
        for (MessageErrorCode messageErrorCode : MessageErrorCode.values()) {
            messageErrorCode.check();

        }
    }

}