package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.News;
import cn.edu.gdut.llc.share.dao.NewsDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:49
 **/
@Service
public class NewsServiceImpl implements NewsService{


    @Autowired
    @Qualifier("newsDaoImpl")
    private NewsDao newsDao;

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
        return newsDao.getNewsById(id);
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
        return newsDao.getNewsByNum(num);
    }

    @Override
    public SCresponse<News> getLimitNews(CSparam<News> pm) {
        /**
         * describe: TODO
         * class_name: getLimitNews
         * param: [param]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.News>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:32
         **/
        //查询结果数据集
        SMParam<News> param = new SMParam<News>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<News> resultList = newsDao.getLimitNews(param);

        //查询总记录数
        News a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = newsDao.getTotalRecord(pm.getParamObj());


        SCresponse<News> response = new SCresponse<News>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);

        return response;

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
        return 0;
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
