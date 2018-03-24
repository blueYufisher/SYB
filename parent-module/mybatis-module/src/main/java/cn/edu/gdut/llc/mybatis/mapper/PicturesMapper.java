package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.Pictures;
import cn.edu.gdut.llc.mybatis.model.PicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PicturesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int countByExample(PicturesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByExample(PicturesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByPrimaryKey(Integer picId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insert(Pictures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insertSelective(Pictures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    List<Pictures> selectByExample(PicturesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    Pictures selectByPrimaryKey(Integer picId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExampleSelective(@Param("record") Pictures record, @Param("example") PicturesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExample(@Param("record") Pictures record, @Param("example") PicturesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKeySelective(Pictures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKey(Pictures record);
}