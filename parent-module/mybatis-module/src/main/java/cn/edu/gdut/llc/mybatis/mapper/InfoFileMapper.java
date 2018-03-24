package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.InfoFile;
import cn.edu.gdut.llc.mybatis.model.InfoFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int countByExample(InfoFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByExample(InfoFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByPrimaryKey(Integer infoFileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insert(InfoFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insertSelective(InfoFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    List<InfoFile> selectByExample(InfoFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    InfoFile selectByPrimaryKey(Integer infoFileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExampleSelective(@Param("record") InfoFile record, @Param("example") InfoFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExample(@Param("record") InfoFile record, @Param("example") InfoFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKeySelective(InfoFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info_file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKey(InfoFile record);
}