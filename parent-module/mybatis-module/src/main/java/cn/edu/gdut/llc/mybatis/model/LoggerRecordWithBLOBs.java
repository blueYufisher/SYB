package cn.edu.gdut.llc.mybatis.model;

public class LoggerRecordWithBLOBs extends LoggerRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.param_data
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String paramData;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logger_record.return_data
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    private String returnData;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.param_data
     *
     * @return the value of logger_record.param_data
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getParamData() {
        return paramData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.param_data
     *
     * @param paramData the value for logger_record.param_data
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logger_record.return_data
     *
     * @return the value of logger_record.return_data
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public String getReturnData() {
        return returnData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logger_record.return_data
     *
     * @param returnData the value for logger_record.return_data
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    public void setReturnData(String returnData) {
        this.returnData = returnData == null ? null : returnData.trim();
    }
}