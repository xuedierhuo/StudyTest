package com.xderhuo.domain;

public class Grade {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grade.cid
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grade.cname
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    private String cname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grade.id
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    private Integer id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grade.cid
     *
     * @return the value of grade.cid
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grade.cid
     *
     * @param cid the value for grade.cid
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grade.cname
     *
     * @return the value of grade.cname
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grade.cname
     *
     * @param cname the value for grade.cname
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grade.id
     *
     * @return the value of grade.id
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grade.id
     *
     * @param id the value for grade.id
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }
}