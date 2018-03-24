package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Knowledges;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

public interface SelfKnowledgesMapper {
    /**
     *获取按时间排序的前num个Knowledge
     * @param num
     * @return
     */
    List<Knowledges> findKnowledgesByNum(int num);

    /**
     *获取Knowledge并且分页
     * @param param
     * @return
     */
    List<Knowledges> findLimitKnowledges(SMParam<Knowledges> param);
}