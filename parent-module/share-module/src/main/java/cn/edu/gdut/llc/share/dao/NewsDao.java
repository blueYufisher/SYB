package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.News;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:45
 **/
public interface NewsDao {
    /** 根据id获取News
     * @param id
     * @return News
     */
    News getNewsById(Integer id);

    /**
     * 获取按时间排序的前num个News
     * @param num
     * @return
     */
    List<News> getNewsByNum(int num);

    /**
     * 获取News并且分页
     * @param SMParam<News> param
     * @return List<News>
     */
    List<News> getLimitNews(SMParam<News> param);

    /**
     * 获取数据库当汇总的News的总的条数
     * @param News对象paramObj
     * @return int总数量
     */
    int getTotalRecord(News paramObj);

    /**根据id删除News
     * @param id
     */
    void deleteNews(int id);

    /**添加News
     * @param act
     */
    void addNews(News act);

    /**修改News
     * @param act
     */
    void modifyNews(News act);
}
