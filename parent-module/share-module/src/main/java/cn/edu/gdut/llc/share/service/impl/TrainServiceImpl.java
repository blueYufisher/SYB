package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Train;
import cn.edu.gdut.llc.share.dao.TrainDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:10
 **/
@Service
public class TrainServiceImpl implements TrainService {


    @Autowired
    @Qualifier("trainDaoImpl")
    private TrainDao trainDao;

    @Override
    public Train getTrainById(Integer id) {
        /**
         * describe: 根据id获取Train
         * class_name: getTrainById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Train
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:24
         **/
        return trainDao.getTrainById(id);
    }

    @Override
    public List<Train> getTrainByNum(int num) {
        /**
         * describe: 获取按时间排序的前num个Train
         * class_name: getTrainByNum
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Train>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:26
         **/
        return trainDao.getTrainByNum(num);
    }

    @Override
    public SCresponse<Train> getLimitTrain(CSparam<Train> pm) {
        /**
         * describe: TODO
         * class_name: getLimitTrain
         * param: [param]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Train>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:32
         **/
        //查询结果数据集
        SMParam<Train> param = new SMParam<Train>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<Train> resultList = trainDao.getLimitTrain(param);

        //查询总记录数
        Train a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = trainDao.getTotalRecord(pm.getParamObj());


        SCresponse<Train> response = new SCresponse<Train>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);

        return response;

    }

    @Override
    public int getTotalRecord(Train paramObj) {
        /**
         * describe: 获取数据库当汇总的Train的总的条数
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
    public void deleteTrain(int id) {

    }

    @Override
    public void addTrain(Train act) {

    }

    @Override
    public void modifyTrain(Train act) {

    }
}
