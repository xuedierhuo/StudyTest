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
    /**
     * 用户姓名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
