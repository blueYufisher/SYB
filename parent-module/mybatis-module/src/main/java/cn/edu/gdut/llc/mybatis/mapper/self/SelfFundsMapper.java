package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Funds;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-10 14:25
 **/
public interface SelfFundsMapper {

    /**
     *获取按时间排序的前num个Funds
     * @param num
     * @return
     */
    List<Funds> findFundsByNum(int num);

    /**
     *获取Funds并且分页
     * @param param
     * @return
     */
    List<Funds> findLimitFunds(SMParam<Funds> param);
}
