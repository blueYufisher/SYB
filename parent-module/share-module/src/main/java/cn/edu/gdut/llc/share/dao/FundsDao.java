package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Funds;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-10 14:30
 **/
public interface FundsDao {
    /** 根据id获取Funds
     * @param id
     * @return Funds
     */
    Funds getFundsById(Integer id);

    /**
     * 获取按时间排序的前num个Funds
     * @param num
     * @return
     */
    List<Funds> getFundsByNum(int num);

    /**
     * 获取Funds并且分页
     * @param SMParam<Funds> param
     * @return List<Funds>
     */
    List<Funds> getLimitFunds(SMParam<Funds> param);

    /**
     * 获取数据库当汇总的Funds的总的条数
     * @param Funds对象paramObj
     * @return int总数量
     */
    int getTotalRecord(Funds paramObj);

    /**根据id删除Funds
     * @param id
     */
    void deleteFunds(int id);

    /**添加Funds
     * @param act
     */
    void addFunds(Funds act);

    /**修改Funds
     * @param act
     */
    void modifyFunds(Funds act);
}
