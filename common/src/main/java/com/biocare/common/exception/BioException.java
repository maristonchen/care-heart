package com.biocare.common.exception;

import com.biocare.common.em.ErrorCode;
import com.biocare.common.em.GlobalErrorCode;

/**
 * Biocare exception
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 22:00
 */
public class BioException extends RuntimeException {


    private static final long serialVersionUID = -8391459716804482029L;
    /**
     * error code
     */
    private ErrorCode errorCode;


    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BioException() {
        super("system occurs an error ,please contact with administrator");
        this.errorCode = GlobalErrorCode.FAIL;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BioException(String message) {
        super(message);
        this.errorCode = GlobalErrorCode.FAIL;
    }

    /**
     * Constructs a new runtime exception with the specified  error info of {@link ErrorCode}
     *
     * @param errorCode error code info
     */
    public BioException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new biocare exception with the specified detail message and error info
     *
     * @param errorCode error code info
     * @param message   detail message
     */
    public BioException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;

    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public static BioException create(ErrorCode errorCode) {
        return new BioException(errorCode);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("The Biocare Exception is [");
        if (this.errorCode == null) {
            info.append(super.getLocalizedMessage());
        } else {
            info.append(this.errorCode.name()).append("]:[").append(this.errorCode.getCode()).append("]:[").append(this.errorCode.getMsg());
            if (this.errorCode == GlobalErrorCode.FAIL) {
                info.append("]:[").append(super.getLocalizedMessage());
            }
        }
        info.append("]");
        return info.toString();
    }

}
