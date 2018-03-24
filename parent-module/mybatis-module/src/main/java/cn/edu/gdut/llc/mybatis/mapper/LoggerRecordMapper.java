package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.LoggerRecord;
import cn.edu.gdut.llc.mybatis.model.LoggerRecordExample;
import cn.edu.gdut.llc.mybatis.model.LoggerRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoggerRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int countByExample(LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int deleteByExample(LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int insert(LoggerRecordWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int insertSelective(LoggerRecordWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    List<LoggerRecordWithBLOBs> selectByExampleWithBLOBs(LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    List<LoggerRecord> selectByExample(LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    LoggerRecordWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") LoggerRecordWithBLOBs record, @Param("example") LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") LoggerRecordWithBLOBs record, @Param("example") LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int updateByExample(@Param("record") LoggerRecord record, @Param("example") LoggerRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int updateByPrimaryKeySelective(LoggerRecordWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(LoggerRecordWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logger_record
     *
     * @mbggenerated Sun Jan 14 21:00:04 CST 2018
     */
    int updateByPrimaryKey(LoggerRecord record);
}