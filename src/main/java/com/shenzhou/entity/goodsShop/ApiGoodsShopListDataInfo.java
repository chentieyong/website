package com.shenzhou.entity.goodsShop;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */
public class ApiGoodsShopListDataInfo {
    private Integer total;
    private Integer currentPage;
    private Integer currentPgeNumber;
    private Integer pageNumber;
    private Integer totalPage;
    private boolean hasNextPage;
    private List<GoodsShop> rows;

    public List<GoodsShop> getRows() {
        return rows;
    }

    public void setRows(List<GoodsShop> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentPgeNumber() {
        return currentPgeNumber;
    }

    public void setCurrentPgeNumber(Integer currentPgeNumber) {
        this.currentPgeNumber = currentPgeNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
