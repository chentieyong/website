package com.shenzhou.entity.base;

import java.io.Serializable;


public class ApiBaseResponseInfo<T> implements Serializable {

    private ApiBaseResponseHeaderInfo header;

    private T body;

    public ApiBaseResponseHeaderInfo getHeader() {
        return header;
    }

    public void setHeader(ApiBaseResponseHeaderInfo header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
