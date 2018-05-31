package com.xderhuo.domain;

import java.util.List;

public class BookBean {
    private Long total;
    private List<Book> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Book> getRows() {
        return rows;
    }

    public void setRows(List<Book> rows) {
        this.rows = rows;
    }
}
