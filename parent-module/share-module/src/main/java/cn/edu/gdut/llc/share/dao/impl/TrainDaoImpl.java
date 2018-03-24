package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.TrainMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfTrainMapper;
import cn.edu.gdut.llc.mybatis.model.Train;
import cn.edu.gdut.llc.mybatis.model.TrainExample;
import cn.edu.gdut.llc.share.dao.TrainDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:07
 **/
@Repository
public class TrainDaoImpl implements TrainDao {

    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private SelfTrainMapper selfTrainMapper;

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
        return trainMapper.selectByPrimaryKey(id);
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
        List<Train> list = selfTrainMapper.findTrainByNum(num);
        System.out.println(list);
        return list;
    }

    @Override
    public List<Train> getLimitTrain(SMParam<Train> param) {
        /**
         * describe: 获取Train并且分页
         * class_name: getLimitTrain
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Train>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:27
         **/
        List<Train> list = selfTrainMapper.findLimitTrain(param);
        System.out.println(list);
        return list;
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
        TrainExample tutorExample = new TrainExample();
        return trainMapper.countByExample(tutorExample);
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
