package cn.edu.gdut.llc.share.dao.impl;


import cn.edu.gdut.llc.mybatis.mapper.KnowledgesMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfKnowledgesMapper;
import cn.edu.gdut.llc.mybatis.model.Knowledges;
import cn.edu.gdut.llc.mybatis.model.KnowledgesExample;
import cn.edu.gdut.llc.share.dao.KnowledgesDao;

import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZHAN
 */
@Repository
public class KnowledgesDaoImpl implements KnowledgesDao{

    @Autowired
    private KnowledgesMapper knowledgesMapper;

    @Autowired
    private SelfKnowledgesMapper selfKnowledgesMapper;

    @Override
    /** 根据id获取Knowledges
     * @param id
     * @return Knowledges
     */
    public Knowledges getKnowledgesById(Integer id) {
        return knowledgesMapper.selectByPrimaryKey(id);
    }

    @Override
    /**
     * 获取按时间排序的前num个Knowledges
     * @param num
     * @return
     */
    public List<Knowledges> getKnowledgesByNum(int num) {
        List<Knowledges> list = selfKnowledgesMapper.findKnowledgesByNum(num);
        System.out.println(list);
        return list;
    }

    @Override
    /**
     * 获取Knowledges并且分页
     * @param SMParam<Knowledges> param
     * @return List<Knowledges>
     */
    public List<Knowledges> getLimitKnowledges(SMParam<Knowledges> param) {
        System.out.println("Dao");
        System.out.println();
        List<Knowledges> test = selfKnowledgesMapper.findLimitKnowledges(param);
        System.out.println(test);
        return test;
    }

    @Override
    /**
     * 获取数据库当汇总的Knowledges的总的条数
     * @param Knowledges对象paramObj
     * @return int总数量
     */
    public int getTotalRecord(Knowledges paramObj) {
        KnowledgesExample knowledgesExample = new KnowledgesExample();
        return knowledgesMapper.countByExample(knowledgesExample);
    }

    @Override
    public void deleteKnowledges(int id) {

    }

    @Override
    public void addKnowledges(Knowledges act) {

    }

    @Override
    public void modifyKnowledges(Knowledges act) {

    }
}
