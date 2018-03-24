package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.mybatis.model.PoliciesExample;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelfPoliciesMapper {
    /**
     *获取按时间排序的前num个Policies
     * @param num
     * @return
     */
    List<Policies> findPoliciesByNum(int num);

    /**
     * 获取Policies并且分页
     * @param param
     * @return
     */
    List<Policies> findLimitPolicies(SMParam<Policies> param);
}