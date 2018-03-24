package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Funds;
import cn.edu.gdut.llc.share.dao.FundsDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.FundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-10 14:33
 **/
@Service
public class FundsServiceImpl implements FundsService {
    @Autowired
    @Qualifier("fundsDaoImpl")
    private FundsDao fundsDao;

    /**
     * 根据id获取Funds
     *
     * @param id
     * @return Funds
     */
    @Override
    public Funds getFundsById(Integer id) {
        return fundsDao.getFundsById(id);
    }

    /**
     * 获取按时间排序的前num个Funds
     *
     * @param num
     * @return
     */
    @Override
    public List<Funds> getFundsByNum(int num) {
        return fundsDao.getFundsByNum(num);
    }

    /**
     * 获取Funds并且分页
     *
     * @param CSparam<Funds> param
     * @return List<Funds>
     */
    @Override
    public SCresponse<Funds> getLimitFunds(CSparam<Funds> pm) {
        //查询结果数据集
        SMParam<Funds> param = new SMParam<Funds>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<Funds> resultList = fundsDao.getLimitFunds(param);

        //查询总记录数
        Funds a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = fundsDao.getTotalRecord(pm.getParamObj());


        SCresponse<Funds> response = new SCresponse<Funds>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);

        return response;
    }

    /**
     * 获取数据库当汇总的Funds的总的条数
     *
     * @param Funds对象paramObj
     * @return int总数量
     */
    @Override
    public int getTotalRecord(Funds paramObj) {
        return 0;
    }

    /**
     * 根据id删除Funds
     *
     * @param id
     */
    @Override
    public void deleteFunds(int id) {
    }

    /**
     * 添加Funds
     *
     * @param act
     */
    @Override
    public void addFunds(Funds act) {
    }

    /**
     * 修改Funds
     *
     * @param act
     */
    @Override
    public void modifyFunds(Funds act) {
    }
}
