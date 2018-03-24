package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.FundsMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfFundsMapper;
import cn.edu.gdut.llc.mybatis.model.Funds;
import cn.edu.gdut.llc.mybatis.model.FundsExample;
import cn.edu.gdut.llc.share.dao.FundsDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-10 14:30
 **/
@Repository
public class FundsDaoImpl implements FundsDao{

    @Autowired
    private FundsMapper fundsMapper;

    @Autowired
    private SelfFundsMapper selfFundsMapper;

    /**
     * 根据id获取Funds
     *
     * @param id
     * @return Funds
     */
    @Override
    public Funds getFundsById(Integer id) {
        return fundsMapper.selectByPrimaryKey(id);
    }


    /**
     * 获取按时间排序的前num个Funds
     *
     * @param num
     * @return
     */
    @Override
    public List<Funds> getFundsByNum(int num) {
        List<Funds> list = selfFundsMapper.findFundsByNum(num);
        System.out.println(list);
        return list;
    }

    /**
     * 获取Funds并且分页
     *
     * @param SMParam<Funds> param
     * @return List<Funds>
     */
    @Override
    public List<Funds> getLimitFunds(SMParam<Funds> param) {
        System.out.println("Dao");
        System.out.println();
        List<Funds> test = selfFundsMapper.findLimitFunds(param);
        System.out.println(test);
        return test;
    }

    /**
     * 获取数据库当汇总的Funds的总的条数
     *
     * @param Funds对象paramObj
     * @return int总数量
     */
    @Override
    public int getTotalRecord(Funds paramObj) {
        // TODO Auto-generated method stub
        FundsExample fundsExample = new FundsExample();
        return fundsMapper.countByExample(fundsExample);
    }

    @Override
    public void deleteFunds(int id) {

    }

    @Override
    public void addFunds(Funds act) {

    }

    @Override
    public void modifyFunds(Funds act) {

    }
    
}
