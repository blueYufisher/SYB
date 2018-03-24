package cn.edu.gdut.llc.share.service.impl;


import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Knowledges;
import cn.edu.gdut.llc.share.dao.KnowledgesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.KnowledgesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHAN
 */
@Service
public class KnowledgesServiceImpl implements KnowledgesService {

    @Autowired
    @Qualifier("knowledgesDaoImpl")
    private KnowledgesDao knowledgesDao;

    @Override
    /** 根据id获取Knowledges
     * @param id
     * @return Knowledges
     */
    public Knowledges getKnowledgesById(Integer id) {
        return knowledgesDao.getKnowledgesById(id);
    }

    @Override
    /**
     * 获取按时间排序的前num个Knowledges
     * @param num
     * @return
     */
    public List<Knowledges> getKnowledgesByNum(int num) {
        return knowledgesDao.getKnowledgesByNum(num);
    }

    @Override
    /**
     * 获取Knowledges并且分页
     * @param SMParam<Knowledges> param
     * @return List<Knowledges>
     */
    public SCresponse<Knowledges> getLimitKnowledges(CSparam<Knowledges> pm) {
        //查询结果数据集
        SMParam<Knowledges> param = new SMParam<Knowledges>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<Knowledges> resultList = knowledgesDao.getLimitKnowledges(param);

        //查询总记录数
        Knowledges a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = knowledgesDao.getTotalRecord(pm.getParamObj());


        SCresponse<Knowledges> response = new SCresponse<Knowledges>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);

        return response;
    }

    @Override
    /**
     * 获取数据库当汇总的Knowledges的总的条数
     * @param Knowledges对象paramObj
     * @return int总数量
     */
    public int getTotalRecord(Knowledges paramObj) {
        return 0;
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
