package com.sky.statistics.web.model;

import java.util.Date;

public class UserLog {
    private Long id;
    private User userID;
    private String userSerialNum;
    private String logInfo;
    private Date logTime;
    private String IP;
    private String methodName;
    private String modelName;


    public UserLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getUserSerialNum() {
        return userSerialNum;
    }

    public void setUserSerialNum(String userSerialNum) {
        this.userSerialNum = userSerialNum;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
