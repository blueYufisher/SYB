package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

public interface PoliciesService {

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
     * 获取Policie并且分页
     * @param param
     * @return
     */
    SCresponse<Policies> getLimiPolicies(CSparam<Policies> param);

    /**
     * 获取数据库当汇总的Policie的总的条数
     * @param paramObj
     * @return
     */
    int getTotalRecord(Policies paramObj);
}
