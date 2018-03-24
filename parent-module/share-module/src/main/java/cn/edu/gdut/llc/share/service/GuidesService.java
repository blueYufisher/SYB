package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Guides;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 15:49
 **/
public interface GuidesService {

    /**
     * describe: 根据id查Guide
     * class_name: getGuidesById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.Guides
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:44
     **/
    Guides getGuidesById(Integer id);

    /**
     * describe: 根据id和type查询Guides
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    List<Guides> findGuideByIdAndType(int id, String type);

    /**
     * describe: 根据type查出该组的Guides并进行分页
     * class_name: findGuidesByTypeList
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:12
     **/
    SCresponse<Guides> findGuidesByTypeList(CSparam<Guides> param);
}
