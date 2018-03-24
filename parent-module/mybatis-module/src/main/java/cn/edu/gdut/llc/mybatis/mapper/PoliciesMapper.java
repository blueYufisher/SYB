package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.mybatis.model.PoliciesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoliciesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int countByExample(PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByExample(PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insert(Policies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insertSelective(Policies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    List<Policies> selectByExampleWithBLOBs(PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    List<Policies> selectByExample(PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    Policies selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExampleSelective(@Param("record") Policies record, @Param("example") PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Policies record, @Param("example") PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExample(@Param("record") Policies record, @Param("example") PoliciesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKeySelective(Policies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Policies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table policies
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKey(Policies record);
}