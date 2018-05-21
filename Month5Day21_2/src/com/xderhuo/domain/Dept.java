package com.xderhuo.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author XDerhuo
 */
@Table(name = "dept")
public class Dept {
    @Id
    private float deptno;
    private String dname;
    private String loc;

    public float getDeptno() {
        return deptno;
    }

    public void setDeptno(float deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept() {

    }

    public Dept(float deptno, String dname, String loc) {

        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
