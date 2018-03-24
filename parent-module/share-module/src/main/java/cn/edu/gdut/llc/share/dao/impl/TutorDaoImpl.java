package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.TutorMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfTutorMapper;
import cn.edu.gdut.llc.mybatis.model.Tutor;
import cn.edu.gdut.llc.mybatis.model.TutorExample;
import cn.edu.gdut.llc.share.dao.TutorDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:24
 **/
@Repository
public class TutorDaoImpl implements TutorDao{

    @Autowired
    private TutorMapper tutorMapper;

    @Autowired
    private SelfTutorMapper selfTutorMapper;

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
        return tutorMapper.selectByPrimaryKey(id);
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
        List<Tutor> list = selfTutorMapper.findTutorByNum(num);
        System.out.println(list);
        return list;
    }

    @Override
    public List<Tutor> getLimitTutor(SMParam<Tutor> param) {
        /**
         * describe: 获取Tutor并且分页
         * class_name: getLimitTutor
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Tutor>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:27
         **/
        List<Tutor> list = selfTutorMapper.findLimitTutor(param);
        System.out.println(list);
        return list;
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
        TutorExample tutorExample = new TutorExample();
        return tutorMapper.countByExample(tutorExample);
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
