package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSearchparam;
import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.self.SelfInfos;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.mesaage.SearchParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:16
 **/
public interface InfosService {
    /**
     * describe: 根据id查Guide
     * class_name: getInfosById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.Infos
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:44
     **/
    SelfInfos getInfosById(Integer id);

    /**
     * describe: 根据id和type查询Infos
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    SCresponse<SelfInfos> findInfoByIdAndType(CSparam<SelfInfos> param);

    /**
     * describe: 根据num和type查询Infos
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    SCresponse<SelfInfos> findInfoByNumAndType(CSparam<SelfInfos> param);

    /**
     * describe: 根据num和visit排序找Info
     * class_name: findInfoNumByVisit
     * param: [msg]
     * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 9:48
     **/
    SCresponse<Infos> findInfoNumByVisit(CSearchparam<Infos> msg);

    /**
     * describe: 根据type查出该组的Infos并进行分页
     * class_name: findInfosByTypeList
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:12
     **/
    SCresponse<SelfInfos> findInfosByTypeList(CSparam<SelfInfos> param);


    /**
     * describe: 根据title或者note模糊搜索
     * class_name: searchInfosByTitleOrNote
     * param: [pm]
     * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/15/0015
     * creat_time: 10:49
     **/
    SCresponse<SelfInfos> searchInfosTypeByTitleOrNote(CSparam<Infos> param);
    SCresponse<SelfInfos> searchInfosByTitleOrNote(CSparam<Infos> param);


    /**
     * describe: 根据id删除Info
     * class_name: deleteInfo
     * param: [id]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/1/0001
     * creat_time: 0:17
     **/
    void deleteInfo(int id);

    /**
     * describe: 添加Info
     * class_name: addInfo
     * param: [infos]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/1/0001
     * creat_time: 0:17
     **/
    int addInfo(Infos infos);

    /**
     * describe: 修改Info
     * class_name: modifyInfo
     * param: [infos]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/1/0001
     * creat_time: 0:19
     **/
    void modifyInfo(Infos infos);

    /**
     * describe: 根据info_id修改访问量
     * class_name: modifyVisit
     * param: [id]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/14/0014
     * creat_time: 22:30
     **/
    int modifyVisit(Integer id);

    /**
     * describe: 根据输入的type数据搜索info
     * class_name: getInfoByTypeId_foreach_array
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2018/2/3/0003
     * creat_time: 1:23
     **/
    SCresponse<Infos> getInfoByTypeId_foreach_array(CSearchparam<Infos> msg);
}
