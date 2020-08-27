package com.shenzhou.entity;

import com.shenzhou.entity.member.Member;

import java.io.Serializable;

public class ApiLoginResponseBodyInfo implements Serializable {

    private String sessionID;

    private Member member;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
