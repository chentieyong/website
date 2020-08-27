package com.shenzhou.entity.depthNavigator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chent on 2017/9/29.
 */
public class ApiDepthNavigatorInfo implements Serializable {
    private String id;
    private String name;
    private String description;
    private String largeIcon = "";
    private Long orderSeq;
    private String parentID;
    private String samllIcon = "";
    private String functionUrl;
    private List<ApiDepthNavigatorInfo> nodes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getSamllIcon() {
        return samllIcon;
    }

    public void setSamllIcon(String samllIcon) {
        this.samllIcon = samllIcon;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApiDepthNavigatorInfo> getNodes() {
        return nodes;
    }

    public void setNodes(List<ApiDepthNavigatorInfo> nodes) {
        this.nodes = nodes;
    }
}
