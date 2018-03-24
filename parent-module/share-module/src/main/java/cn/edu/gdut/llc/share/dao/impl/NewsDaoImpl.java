package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.NewsMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfNewsMapper;
import cn.edu.gdut.llc.mybatis.model.News;
import cn.edu.gdut.llc.mybatis.model.NewsExample;
import cn.edu.gdut.llc.share.dao.NewsDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:46
 **/
@Repository
public class NewsDaoImpl implements NewsDao{


    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private SelfNewsMapper selfNewsMapper;

    @Override
    public News getNewsById(Integer id) {
        /**
         * describe: 根据id获取News
         * class_name: getNewsById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.News
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:24
         **/
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<News> getNewsByNum(int num) {
        /**
         * describe: 获取按时间排序的前num个News
         * class_name: getNewsByNum
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.News>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:26
         **/
        List<News> list = selfNewsMapper.findNewsByNum(num);
        System.out.println(list);
        return list;
    }

    @Override
    public List<News> getLimitNews(SMParam<News> param) {
        /**
         * describe: 获取News并且分页
         * class_name: getLimitNews
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.News>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:27
         **/
        List<News> list = selfNewsMapper.findLimitNews(param);
        System.out.println(list);
        return list;
    }

    @Override
    public int getTotalRecord(News paramObj) {
        /**
         * describe: 获取数据库当汇总的News的总的条数
         * class_name: getTotalRecord
         * param: [paramObj]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:28
         **/
        NewsExample tutorExample = new NewsExample();
        return newsMapper.countByExample(tutorExample);
    }

    @Override
    public void deleteNews(int id) {

    }

    @Override
    public void addNews(News act) {

    }

    @Override
    public void modifyNews(News act) {

    }
    
}
