package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.self.SelfInfos;
import cn.edu.gdut.llc.share.mesaage.InfosVisitParam;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.mesaage.SearchParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:10
 **/
public interface SelfInfosMapper {

    /**
     * describe: 根据type查出该组的Infos并进行分页
     * class_name: findInfosByTypeList
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:12
     **/
    List<SelfInfos> findInfosByTypeList(SMParam<SelfInfos> msg);

    List<SelfInfos> findInfoByIdAndType(SMParam<SelfInfos> msg);
    
    SelfInfos findInfoById(Integer id);

    /**
     * describe: 根据type找出所有的Infos
     * class_name: countInfosByType
     * param: [type]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:13
     **/
    int countInfosByType(int type);


    /**
     * describe: 根据num和type查询Infos
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    List<SelfInfos> findInfoByNumAndType(SMParam<SelfInfos> msg);

    /**
     * describe: 根据num和visit排序找Info
     * class_name: findInfoNumByVisit
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 9:46
     **/
    List<Infos> findInfoNumByVisit(InfosVisitParam<Infos> msg);

    /**
     * describe: 根据id和type找到上一条记录
     * class_name: findPreInfoById
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/14/0014
     * creat_time: 11:07
     **/
    List<SelfInfos> findPreInfoById(SMParam<SelfInfos> msg);

    /**
     * describe: 根据id和type找到下一条记录
     * class_name: findPreInfoById
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/14/0014
     * creat_time: 11:07
     **/
    List<SelfInfos> findNextInfoById(SMParam<SelfInfos> msg);

    /**
     * describe: 根据title或者note模糊搜索
     * class_name: searchInfosByTitleOrNote
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/15/0015
     * creat_time: 10:43
     **/
    List<Infos> searchInfosTypeByTitleOrNote(SMParam<Infos> msg);
    List<Infos> searchInfosByTitleOrNote(SMParam<Infos> msg);

    /**
     * describe: 根据title或者note找出所有的Infos
     * class_name: countInfosByTitleOrNote
     * param: [msg]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/15/0015
     * creat_time: 14:35
     **/
    int countInfosByTitleOrNote(SMParam<Infos> msg);

    /**
     * describe: 添加Info返回id
     * class_name: addInfo
     * param: [infos]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/1/0001
     * creat_time: 0:17
     **/
    Integer insertInfoReturnID(Infos infos);


    /**
     * describe: 根据输入的type数据搜索info
     * class_name: getInfoByTypeId_foreach_array
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2018/2/3/0003
     * creat_time: 1:22
     **/
    List<Infos> getInfoByTypeId_foreach_array(SearchParam<Infos> msg);

    int countInfoByTypeId_foreach_array(SearchParam<Infos> msg);
    
}
