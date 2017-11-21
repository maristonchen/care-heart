package com.biocare.exam.em;

import static org.junit.Assert.*;

public class ExamErrorCodeTest {
    @org.junit.Test
    public void check() throws Exception {

        for (ExamErrorCode examErrorCode : ExamErrorCode.values()) {
            examErrorCode.check();

        }
    }

}