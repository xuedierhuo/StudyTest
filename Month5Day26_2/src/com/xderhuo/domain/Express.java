package com.xderhuo.domain;

import java.util.Date;

import javax.persistence.Id;

//  快递信息  实体类
public class Express {
	@Id
    private Integer eid; //主键
    private String addresser; //发件人
    private Long addresserPhone; //发件人电话

    private String receiver; //收件人
    private Long receiverPhone;   //收件人电话

    private String area;  //快递区域
    private String type;  // 快递类型    1-文件  2-其他
    private Integer postcode;  //邮编  

    private String addr;  //收件地址   
    private String remark; // 备注   

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser == null ? null : addresser.trim();
    }

    public Long getAddresserPhone() {
        return addresserPhone;
    }

    public void setAddresserPhone(Long addresserPhone) {
        this.addresserPhone = addresserPhone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public Long getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(Long receiverPhone) {
        this.receiverPhone = receiverPhone;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}