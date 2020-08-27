package com.shenzhou.entity.base;

import java.io.Serializable;

/**
 * Created by apple on 16-2-29.
 */
public class Register implements Serializable {
    private String memberID;
    private String msg;

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
