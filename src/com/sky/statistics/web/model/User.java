package com.sky.statistics.web.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private Long id;
    @NotNull(message="名字不能为空")
    private String userName;
    @Size(min=8, max=16,message="密码长度8~16位")
    private String password;
    private String serialNumber;
    private String IMEI;
    @Max(value=150,message="年龄最大不能超过150")
    private String salt;
    private int age;
    private String address;
    private String company;
    private String phone;
    private String IP;
    private String client;
    private Date lastLoginTime;
    private String headURL;
    private String creator;
    private Date createTime;
    private String dsc;


    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getHeadURL() {
        return headURL;
    }

    public void setHeadURL(String headURL) {
        this.headURL = headURL;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", IMEI='" + IMEI + '\'' +
                ", salt='" + salt + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", IP='" + IP + '\'' +
                ", client='" + client + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", headURL='" + headURL + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", dsc='" + dsc + '\'' +
                '}';
    }
}
