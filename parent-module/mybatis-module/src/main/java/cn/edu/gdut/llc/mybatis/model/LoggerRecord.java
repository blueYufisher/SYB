package cn.edu.gdut.llc.mybatis.model;

import java.util.Date;

public class LoggerRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.id
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.client_ip
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String clientIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.uri
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String uri;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.category
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.method
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String method;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.session_id
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String sessionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.time
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.return_time
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String returnTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.http_status_code
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String httpStatusCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.time_consuming
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private Integer timeConsuming;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.id
     *
     * @return the value of logger_record.id
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.id
     *
     * @param id the value for logger_record.id
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.client_ip
     *
     * @return the value of logger_record.client_ip
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.client_ip
     *
     * @param clientIp the value for logger_record.client_ip
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.uri
     *
     * @return the value of logger_record.uri
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getUri() {
        return uri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.uri
     *
     * @param uri the value for logger_record.uri
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.category
     *
     * @return the value of logger_record.category
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.category
     *
     * @param category the value for logger_record.category
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.method
     *
     * @return the value of logger_record.method
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.method
     *
     * @param method the value for logger_record.method
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.session_id
     *
     * @return the value of logger_record.session_id
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.session_id
     *
     * @param sessionId the value for logger_record.session_id
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.time
     *
     * @return the value of logger_record.time
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.time
     *
     * @param time the value for logger_record.time
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.return_time
     *
     * @return the value of logger_record.return_time
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getReturnTime() {
        return returnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.return_time
     *
     * @param returnTime the value for logger_record.return_time
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime == null ? null : returnTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.http_status_code
     *
     * @return the value of logger_record.http_status_code
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.http_status_code
     *
     * @param httpStatusCode the value for logger_record.http_status_code
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode == null ? null : httpStatusCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.time_consuming
     *
     * @return the value of logger_record.time_consuming
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public Integer getTimeConsuming() {
        return timeConsuming;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.time_consuming
     *
     * @param timeConsuming the value for logger_record.time_consuming
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setTimeConsuming(Integer timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}