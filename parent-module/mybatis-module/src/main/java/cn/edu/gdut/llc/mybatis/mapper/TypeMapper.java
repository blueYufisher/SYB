package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.Type;
import cn.edu.gdut.llc.mybatis.model.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int countByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insert(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int insertSelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    List<Type> selectByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    Type selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKeySelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    int updateByPrimaryKey(Type record);
}