package com.biocare.platform.bean;

import java.io.Serializable;

/**
 * banner ad
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:25
 */
public class Banner implements Serializable {

    private static final long serialVersionUID = -1118520615207297105L;

    /**
     * banner id
     */
    private String bannerId;

    /**
     * system id
     */
    private String systemId;

    /**
     *  the url of the picture
     */
    private String picUrl;
}
