package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Tutor;
import cn.edu.gdut.llc.share.dao.TutorDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:30
 **/
@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    @Qualifier("tutorDaoImpl")
    private TutorDao tutorDao;

    @Override
    public Tutor getTutorById(Integer id) {
        /**
         * describe: 根据id获取Tutor
         * class_name: getTutorById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Tutor
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:24
         **/
        return tutorDao.getTutorById(id);
    }

    @Override
    public List<Tutor> getTutorByNum(int num) {
        /**
         * describe: 获取按时间排序的前num个Tutor
         * class_name: getTutorByNum
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Tutor>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:26
         **/
        return tutorDao.getTutorByNum(num);
    }

    @Override
    public SCresponse<Tutor> getLimitTutor(CSparam<Tutor> pm) {
        /**
         * describe: TODO
         * class_name: getLimitTutor
         * param: [param]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Tutor>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:32
         **/
        //查询结果数据集
        SMParam<Tutor> param = new SMParam<Tutor>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<Tutor> resultList = tutorDao.getLimitTutor(param);

        //查询总记录数
        Tutor a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = tutorDao.getTotalRecord(pm.getParamObj());


        SCresponse<Tutor> response = new SCresponse<Tutor>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);

        return response;

    }

    @Override
    public int getTotalRecord(Tutor paramObj) {
        /**
         * describe: 获取数据库当汇总的Tutor的总的条数
         * class_name: getTotalRecord
         * param: [paramObj]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:28
         **/
        return 0;
    }

    @Override
    public void deleteTutor(int id) {

    }

    @Override
    public void addTutor(Tutor act) {

    }

    @Override
    public void modifyTutor(Tutor act) {

    }
}
