package com.shenzhou.utils;

import org.springframework.context.ApplicationContext;

public abstract class SpringContext {
    static private ApplicationContext _Context = null;

    static private synchronized void SetContextForOnce(
            ApplicationContext Context) {
        if (_Context == null) {
            _Context = Context;
        }
    }

    static void SetContext(ApplicationContext Context) {
        if (_Context == null) {
            SetContextForOnce(Context);
        }
    }

    static public <T> T GetBean(Class<T> Class) {
        return _Context.getBean(Class);
    }

    static public Object GetBean(String Name) {
        return _Context.getBean(Name);
    }
}
