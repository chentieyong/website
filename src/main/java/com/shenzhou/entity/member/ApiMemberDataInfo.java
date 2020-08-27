package com.shenzhou.entity.member;

import java.util.List;

/**
 * Created by cty on 2016/11/17.
 */
public class ApiMemberDataInfo {
    private List<ApiMemberDto> rows;

    public List<ApiMemberDto> getRows() {
        return rows;
    }

    public void setRows(List<ApiMemberDto> rows) {
        this.rows = rows;
    }
}
