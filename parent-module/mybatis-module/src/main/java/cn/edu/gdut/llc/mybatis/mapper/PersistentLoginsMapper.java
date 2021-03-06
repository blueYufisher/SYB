package cn.edu.gdut.llc.mybatis.mapper;

import cn.edu.gdut.llc.mybatis.model.PersistentLogins;
import cn.edu.gdut.llc.mybatis.model.PersistentLoginsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersistentLoginsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int countByExample(PersistentLoginsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int deleteByExample(PersistentLoginsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int deleteByPrimaryKey(String series);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int insert(PersistentLogins record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int insertSelective(PersistentLogins record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    List<PersistentLogins> selectByExample(PersistentLoginsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    PersistentLogins selectByPrimaryKey(String series);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByExampleSelective(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByExample(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByPrimaryKeySelective(PersistentLogins record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table persistent_logins
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    int updateByPrimaryKey(PersistentLogins record);
}