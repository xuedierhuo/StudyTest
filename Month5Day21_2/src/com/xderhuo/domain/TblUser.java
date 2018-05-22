package com.xderhuo.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author XDerhuo
 */
@Table(name = "tbl_user")
public class TblUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_gender")
    private String userGender;
    @Column(name = "user_registerTime")
    private Date userRegisterTime;
    @Column(name = "user_lastLoginTime")
    private Date userLastLoginTime;
    @Column(name = "deptno")
    private Integer deptno;
    @Column(name = "password")
    private String password;

    
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public TblUser() {
    }

    public TblUser(Integer userId, String userName, String userGender, Date userRegisterTime, Date userLastLoginTime, Integer deptno, String password) {

        this.userId = userId;
        this.userName = userName;
        this.userGender = userGender;
        this.userRegisterTime = userRegisterTime;
        this.userLastLoginTime = userLastLoginTime;
        this.deptno = deptno;
        this.password = password;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
