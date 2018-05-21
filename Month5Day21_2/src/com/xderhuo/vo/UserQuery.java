package com.xderhuo.vo;

public class UserQuery {
    /**
     * 查询页数
     */
    private Integer page;
    /**
     * 每页个数
     */
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
