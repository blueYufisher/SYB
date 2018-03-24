package cn.edu.gdut.llc.mybatis.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.real_name
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sex
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.mail
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String mail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.qq
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String qq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.weichat
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String weichat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.userface
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String userface;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.depart_id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer departId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.log_count
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer logCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.log_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Date logTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.remark
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ip_address
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String ipAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.state
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.role
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.real_name
     *
     * @return the value of user.real_name
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.real_name
     *
     * @param realName the value for user.real_name
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sex
     *
     * @return the value of user.sex
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sex
     *
     * @param sex the value for user.sex
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.mail
     *
     * @return the value of user.mail
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.mail
     *
     * @param mail the value for user.mail
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.qq
     *
     * @return the value of user.qq
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.qq
     *
     * @param qq the value for user.qq
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.weichat
     *
     * @return the value of user.weichat
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getWeichat() {
        return weichat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.weichat
     *
     * @param weichat the value for user.weichat
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setWeichat(String weichat) {
        this.weichat = weichat == null ? null : weichat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.userface
     *
     * @return the value of user.userface
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getUserface() {
        return userface;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.userface
     *
     * @param userface the value for user.userface
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setUserface(String userface) {
        this.userface = userface == null ? null : userface.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.depart_id
     *
     * @return the value of user.depart_id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getDepartId() {
        return departId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.depart_id
     *
     * @param departId the value for user.depart_id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.log_count
     *
     * @return the value of user.log_count
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getLogCount() {
        return logCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.log_count
     *
     * @param logCount the value for user.log_count
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setLogCount(Integer logCount) {
        this.logCount = logCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.log_time
     *
     * @return the value of user.log_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.log_time
     *
     * @param logTime the value for user.log_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.remark
     *
     * @return the value of user.remark
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.remark
     *
     * @param remark the value for user.remark
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ip_address
     *
     * @return the value of user.ip_address
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ip_address
     *
     * @param ipAddress the value for user.ip_address
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.state
     *
     * @return the value of user.state
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.state
     *
     * @param state the value for user.state
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.role
     *
     * @return the value of user.role
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.role
     *
     * @param role the value for user.role
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setRole(Integer role) {
        this.role = role;
    }
}