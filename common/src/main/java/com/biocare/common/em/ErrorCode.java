package com.biocare.common.em;

/**
 * error code and message
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 12:04
 */
public interface ErrorCode {

    /**
     * the error name
     *
     * @return string
     */
    String name();

    /**
     * get error code
     *
     * @return string
     */
    String getCode();

    /**
     * get error message
     *
     * @return string
     */
    String getMsg();

    /**
     * Check if the code is repeated and the range of code
     */
    void check();

}
