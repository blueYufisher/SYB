package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.ProjPic;
import cn.edu.gdut.llc.mybatis.model.ProjPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjPicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int countByExample(ProjPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int deleteByExample(ProjPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int insert(ProjPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int insertSelective(ProjPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    List<ProjPic> selectByExample(ProjPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    ProjPic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByExampleSelective(@Param("record") ProjPic record, @Param("example") ProjPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByExample(@Param("record") ProjPic record, @Param("example") ProjPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByPrimaryKeySelective(ProjPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_pic
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByPrimaryKey(ProjPic record);
}