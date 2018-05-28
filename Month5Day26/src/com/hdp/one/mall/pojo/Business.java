package com.hdp.one.mall.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * 商家管理及商家审核表的 pojo 类
 *
 * @author firmin_lee
 * @date 2018/5/11 20:35
 * @link firmin-li.com
 * @mail firmin_li@163.com
 */
@Table(name = "mall_bmm")
public class Business {

    /**
     * 商家id
     */
    @Id
    private Integer bid;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 公司手机
     */
    private String companyMobilePhone;

    /**
     * 公司电话
     */
    private String companyPhone;

    /**
     * 公司详细地址
     */
    private String companyAddress;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人qq
     */
    private String contactQq;

    /**
     * 联系人手机
     */
    private String contactMobilePhone;

    /**
     * 联系人email
     */
    private String contactEmail;

    /**
     * 营业执照号
     */
    private String businessNumber;

    /**
     * 税务登记证号
     */
    private String registrationNumber;

    /**
     * 组织机构代码
     */
    private String organizationCode;

    /**
     * 法定代表人
     */
    private String legalRepresentative;

    /**
     * 法定代表人身份证号
     */
    private String legalRepresentativeId;

    /**
     * 开户行名称
     */
    private String bankName;

    /**
     * 开户行支行
     */
    private String bankBranch;

    /**
     * 状态码
     * 0 - 待审核
     * 1 - 审核通过
     * 2 - 审核不通过
     * 3 - 关闭商家
     */
    private Integer status;

    /**
     * 银行账号
     */
    private String bankAccount;

    public Business(Integer bid, String companyName, String companyMobilePhone, String companyPhone, String companyAddress, String contactName, String contactQQ, String contactMobilePhone, String contactEmail, String businessNumber, String registrationNumber, String organizationCode, String legalRepresentative, String legalRepresentativeId, String bankName, String bankBranch, int status, String bankAccount) {
        this.bid = bid;
        this.companyName = companyName;
        this.companyMobilePhone = companyMobilePhone;
        this.companyPhone = companyPhone;
        this.companyAddress = companyAddress;
        this.contactName = contactName;
        this.contactQq = contactQQ;
        this.contactMobilePhone = contactMobilePhone;
        this.contactEmail = contactEmail;
        this.businessNumber = businessNumber;
        this.registrationNumber = registrationNumber;
        this.organizationCode = organizationCode;
        this.legalRepresentative = legalRepresentative;
        this.legalRepresentativeId = legalRepresentativeId;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.status = status;
        this.bankAccount = bankAccount;
    }

    public Business() {

    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyMobilePhone() {
        return companyMobilePhone;
    }

    public void setCompanyMobilePhone(String companyMobilePhone) {
        this.companyMobilePhone = companyMobilePhone;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactQq() {
        return contactQq;
    }

    public void setContactQq(String contactQq) {
        this.contactQq = contactQq;
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public void setContactMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getLegalRepresentativeId() {
        return legalRepresentativeId;
    }

    public void setLegalRepresentativeId(String legalRepresentativeId) {
        this.legalRepresentativeId = legalRepresentativeId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
