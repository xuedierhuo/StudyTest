package com.xderhuo.domain;

public class School {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school.id
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school.sname
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    private String sname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school.id
     *
     * @return the value of school.id
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school.id
     *
     * @param id the value for school.id
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school.sname
     *
     * @return the value of school.sname
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public String getSname() {
        return sname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school.sname
     *
     * @param sname the value for school.sname
     *
     * @mbg.generated Fri May 25 12:06:03 CST 2018
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }
}