package com.sky.statistics.web.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
//此注解的作用是只检查属性不检查方法，解决Jackson序列化bean时变量名大小写改变的问题
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility= JsonAutoDetect.Visibility.NONE)
public class User implements Serializable{
    private Long id;
    @NotEmpty(message="{user.username.null}")
    private String userName;
//    @NotEmpty(message="{user.password.null}")
//    @Size(min=8, max=16,message="{user.password.size}")
    private String password;
    private String serialNumber;
    @NotEmpty(message="{user.uuid.null}")
    private String uuid;
    private String salt;
    private int state;
//    @Max(value=150,message="{user.age.error}")
    private int age;
    private String address;
    private String company;
    private String phone;
    @Email(message = "{user.email.error}")
    private String email;
    private String ip;
    private String client;
    private Date lastLoginTime;
    private String headURL;
    private String creator;
    private Date createTime;
    private String dsc;


    public User() {
    }

    public User(Long id) {
        this.id = id;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", uuid='" + uuid + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                ", client='" + client + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", headURL='" + headURL + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", dsc='" + dsc + '\'' +
                '}';
    }
}
