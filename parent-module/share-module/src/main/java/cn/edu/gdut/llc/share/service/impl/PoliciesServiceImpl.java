package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.share.dao.PoliciesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.PoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliciesServiceImpl implements PoliciesService {

    @Autowired
    @Qualifier("policiesDaoImpl")
    private PoliciesDao policiesDao;


    /**
     * 根据id获取Policies
     *
     * @param id
     * @return
     */
    @Override
    public Policies getPoliciesById(Integer id) {
        return policiesDao.getPoliciesById(id);
    }

    /**
     * 获取按时间排序的前num个Policies
     *
     * @param num
     * @return
     */
    @Override
    public List<Policies> getPoliciesByNum(int num) {
        return policiesDao.getPoliciesByNum(num);
    }

    /**
     * 获取Policies并且分页
     *
     * @param pm
     * @return
     */
    @Override
    public SCresponse<Policies> getLimiPolicies(CSparam<Policies> pm) {
        //查询结果数据集
        SMParam<Policies> param = new SMParam<Policies>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<Policies> resultList = policiesDao.getLimiPolicies(param);

        //查询总记录数
        Policies policies = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = policiesDao.getTotalRecord(pm.getParamObj());

        SCresponse<Policies> response = new SCresponse<Policies>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);

        return response;
    }

    /**
     * 获取数据库当汇总的Policie的总的条数
     *
     * @param paramObj
     * @return
     */
    @Override
    public int getTotalRecord(Policies paramObj) {
        return 0;
    }
}
