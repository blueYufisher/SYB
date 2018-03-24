package cn.edu.gdut.llc.share.service;


import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Knowledges;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * @author ZHAN
 *
 */
public interface KnowledgesService {
    /** 根据id获取Knowledges
     * @param id
     * @return Knowledges
     */
    Knowledges getKnowledgesById(Integer id);

    /**
     * 获取按时间排序的前num个Knowledges
     * @param num
     * @return
     */
    List<Knowledges> getKnowledgesByNum(int num);

    /**
     * 获取Knowledges并且分页
     * @param SMParam<Knowledges> param
     * @return List<Knowledges>
     */
    SCresponse<Knowledges> getLimitKnowledges(CSparam<Knowledges> param);

    /**
     * 获取数据库当汇总的Knowledges的总的条数
     * @param Knowledges对象paramObj
     * @return int总数量
     */
    int getTotalRecord(Knowledges paramObj);

    /**根据id删除Knowledges
     * @param id
     */
    void deleteKnowledges(int id);

    /**添加Knowledges
     * @param act
     */
    void addKnowledges(Knowledges act);

    /**修改Knowledges
     * @param act
     */
    void modifyKnowledges(Knowledges act);
}
