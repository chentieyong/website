package com.shenzhou.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyContextAware implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext Context)
            throws BeansException {
        // TODO Auto-generated method stub
        SpringContext.SetContext(Context);
    }

}
