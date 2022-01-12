package com.gec.spring5.transaction.test;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class UserLog {

    public static  final Logger LOGGER = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        LOGGER.warn("hello ");
        LOGGER.debug("hello");
        LOGGER.trace("hello");
    }
}
