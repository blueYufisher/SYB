package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Guides;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 16:05
 **/
public interface SelfGuidesMapper {

    /**
     * describe: 根据type查出该组的Guides并进行分页
     * class_name: findGuidesByTypeList
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:12
     **/
    List<Guides> findGuidesByTypeList(SMParam<Guides> msg);

    /**
     * describe: 根据type找出所有的Guides
     * class_name: countGuidesByType
     * param: [type]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:13
     **/
    int countGuidesByType(String type);
}
