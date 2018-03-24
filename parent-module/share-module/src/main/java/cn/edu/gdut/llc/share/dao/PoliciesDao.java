package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.mybatis.model.Project;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * @author ZHAN
 */
public interface PoliciesDao {
    /**
     * 根据id获取Policies
     * @param id
     * @return
     */
    Policies getPoliciesById(Integer id);

    /**
     * 获取按时间排序的前num个Policies
     * @param num
     * @return
     */
    List<Policies> getPoliciesByNum(int num);

    /**
     * 获取Policies并且分页
     * @param param
     * @return
     */
    List<Policies> getLimiPolicies(SMParam<Policies> param);

    /**
     * 获取数据库当汇总的Policies的总的条数
     * @param paramObj
     * @return
     */
    int getTotalRecord(Policies paramObj);
}
