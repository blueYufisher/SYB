package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Guides;
import cn.edu.gdut.llc.share.dao.GuidesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 15:49
 **/
@Service
public class GuidesServiceImpl implements GuidesService {

    @Autowired
    @Qualifier("guidesDaoImpl")
    private GuidesDao guidesDao;

    @Override
    /**
     * describe: 根据id查Guide
     * class_name: getGuidesById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.Guides
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:44
     **/
    public Guides getGuidesById(Integer id) {
        return guidesDao.getGuidesById(id);
    }

    @Override
    /**
     * describe: 根据id和type查询Guides
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    public List<Guides> findGuideByIdAndType(int id, String type) {
        return guidesDao.findGuideByIdAndType(id, type);
    }

    @Override
    /**
     * describe: 根据type查出该组的Guides并进行分页
     * class_name: findGuidesByTypeList
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:12
     **/
    public SCresponse<Guides> findGuidesByTypeList(CSparam<Guides> pm) {
        // 将传入的参数转换成Dao成需要的参数
        SMParam<Guides> param = new SMParam<Guides>();
        param.setPageSize(pm.getPageSize());
        param.setStartNum((pm.getCurrentPage() - 1) * pm.getPageSize());
        param.setParamObj(pm.getParamObj());

        // 查询总记录数
        int totalRecord = guidesDao.countGuidesByType(pm.getParamObj().getType());

        // 查询满足条件的所有记录
        SCresponse<Guides> response = new SCresponse<Guides>();
        response.setResultList(guidesDao.findGuidesByTypeList(param));
        // 计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }
}
