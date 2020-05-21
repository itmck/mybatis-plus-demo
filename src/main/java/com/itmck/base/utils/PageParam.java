package com.itmck.base.utils;

/**
 * Create by it_mck 2019/9/15 15:22
 *
 * @Description: mysql分页
 * @Version: 1.0
 */

public class PageParam {

    private int currentPage;//当前页
    private int limit;
    private int offSet;


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    //只要使用给page和limit赋值，那么offset自动计算出来
    public int getOffset() {

        this.offSet = (currentPage - 1) * limit;
        return offSet;
    }
}
