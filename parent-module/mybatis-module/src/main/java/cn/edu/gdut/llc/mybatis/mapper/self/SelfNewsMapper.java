package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.News;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:42
 **/
public interface SelfNewsMapper {
    /**
     *获取按时间排序的前num个News
     * @param num
     * @return
     */
    List<News> findNewsByNum(int num);

    /**
     *获取News并且分页
     * @param param
     * @return
     */
    List<News> findLimitNews(SMParam<News> param);
}
