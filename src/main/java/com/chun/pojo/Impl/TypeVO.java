package com.chun.pojo.Impl;

import com.chun.pojo.Type;

public class TypeVO extends Type {
    private int page;// 每页显示数量
    private int limit;
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
