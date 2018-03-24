package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.PoliciesMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfPoliciesMapper;
import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.mybatis.model.PoliciesExample;
import cn.edu.gdut.llc.share.dao.PoliciesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  @author ZHAN
 */
@Repository
public class PoliciesDaoImpl implements PoliciesDao{
    @Autowired
    private PoliciesMapper policiesMapper;

    @Autowired
    private SelfPoliciesMapper selfPoliciesMapper;

    @Override
    public Policies getPoliciesById(Integer id) {
        return policiesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Policies> getPoliciesByNum(int num) {
        List<Policies> list = selfPoliciesMapper.findPoliciesByNum(num);
        System.out.println(list);
        return list;
    }

    @Override
    public List<Policies> getLimiPolicies(SMParam<Policies> param) {
        System.out.println("Dao");
        System.out.println();
        List<Policies> test = selfPoliciesMapper.findLimitPolicies(param);
        System.out.println(test);
        return test;
    }

    @Override
    public int getTotalRecord(Policies paramObj) {
        PoliciesExample policiesExample = new PoliciesExample();
        return policiesMapper.countByExample(policiesExample);
    }
}
