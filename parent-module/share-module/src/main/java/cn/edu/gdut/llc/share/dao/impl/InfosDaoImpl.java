package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.message.CSearchparam;
import cn.edu.gdut.llc.mybatis.mapper.InfosMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfInfosMapper;
import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.InfosExample;
import cn.edu.gdut.llc.mybatis.model.self.SelfInfos;
import cn.edu.gdut.llc.share.dao.InfosDao;
import cn.edu.gdut.llc.share.mesaage.InfosVisitParam;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.mesaage.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:14
 **/
@Repository
public class InfosDaoImpl implements InfosDao {

    @Autowired
    private InfosMapper infosMapper;
    @Autowired
    private SelfInfosMapper selfInfosMapper;

    @Override
    public SelfInfos getInfosById(Integer id) {
        /**
         * describe: 根据id查Info
         * class_name: getInfosById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Infos
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:44
         **/
        return selfInfosMapper.findInfoById(id);
    }

    @Override
    public List<SelfInfos> findInfoByIdAndType(SMParam<SelfInfos> param) {
        /**
         * describe: 根据id和type查询Infos
         * class_name: findGuideByIdAndType
         * param: [id, type]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:48
         **/
//        InfosExample infosExample = new InfosExample();
//        infosExample.createCriteria().andIdEqualTo(id).andTypeEqualTo(type);
        return selfInfosMapper.findInfoByIdAndType(param);
    }


    @Override
    /**
     * describe: 根据num和type查询Infos
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    public List<SelfInfos> findInfoByNumAndType(SMParam<SelfInfos> param) {
        return selfInfosMapper.findInfoByNumAndType(param);
    }

    @Override
    public List<Infos> findInfoNumByVisit(InfosVisitParam<Infos> msg) {
        /**
         * describe: 根据num和visit排序找Info
         * class_name: findInfoNumByVisit
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 9:46
         **/
        return selfInfosMapper.findInfoNumByVisit(msg);
    }

    @Override
    public List<SelfInfos> findInfosByTypeList(SMParam<SelfInfos> param) {
        /**
         * describe: 根据type查出该组的Infos并进行分页
         * class_name: findInfosByTypeList
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:12
         **/
        List<SelfInfos> list = selfInfosMapper.findInfosByTypeList(param);
        System.out.println(list);
        return list;
    }

    @Override
    public int countInfosByType(int type) {
        /**
         * describe: 根据type找出所有的Infos
         * class_name: countInfosByType
         * param: [type]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:13
         **/
        return selfInfosMapper.countInfosByType(type);
    }

    @Override
    public List<SelfInfos> findPreInfoById(SMParam<SelfInfos> msg) {
        /**
         * describe: 根据id和type找到上一条记录
         * class_name: findPreInfoById
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/14/0014
         * creat_time: 11:07
         **/
        return selfInfosMapper.findPreInfoById(msg);
    }

    @Override
    public List<SelfInfos> findNextInfoById(SMParam<SelfInfos> msg) {
        /**
         * describe: 根据id和type找到下一条记录
         * class_name: findPreInfoById
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/14/0014
         * creat_time: 11:07
         **/
        return selfInfosMapper.findNextInfoById(msg);
    }

    @Override
    public List<Infos> searchInfosTypeByTitleOrNote(SMParam<Infos> msg) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: searchInfosTypeByTitleOrNote
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/15/0015
         * creat_time: 10:43
         **/
        return selfInfosMapper.searchInfosTypeByTitleOrNote(msg);
    }
    @Override
    public List<Infos> searchInfosByTitleOrNote(SMParam<Infos> msg) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: searchInfosByTitleOrNote
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/15/0015
         * creat_time: 10:43
         **/
        return selfInfosMapper.searchInfosByTitleOrNote(msg);
    }

    @Override
    public int countInfosByTitleOrNote(SMParam<Infos> msg) {
        /**
         * describe: 根据title或者note找出所有的Infos
         * class_name: countInfosByTitleOrNote
         * param: [msg]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/15/0015
         * creat_time: 14:35
         **/
        return selfInfosMapper.countInfosByTitleOrNote(msg);
    }

    @Override
    public void deleteInfo(int id) {
        /**
         * describe: 根据id删除Info
         * class_name: deleteInfo
         * param: [id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:17
         **/
        Infos infos = infosMapper.selectByPrimaryKey(id);
        if (infos == null) {
            throw new RuntimeException("要删除的记录不存在");
        } else {
            infosMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int addInfo(Infos infos) {
        /**
         * describe: 添加Info
         * class_name: addInfo
         * param: [infos]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:17
         **/
        selfInfosMapper.insertInfoReturnID(infos);
        String url = "detail.html?type=" + infos.getType() + "&id=" + infos.getId();
        infos.setInfosUrl(url);
        infos.setVisit(0);
        infosMapper.updateByPrimaryKeyWithBLOBs(infos);

        return infos.getId();
    }

    @Override
    public void modifyInfo(Infos infos) {
        /**
         * describe: 修改Info
         * class_name: modifyInfo
         * param: [infos]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:19
         **/
        if (infosMapper.selectByPrimaryKey(infos.getId()) == null) {
            throw new RuntimeException("该id不存在！");
        }
        infosMapper.updateByPrimaryKeyWithBLOBs(infos);

    }

    @Override
    public int modifyVisit(Integer id) {
        /**
         * describe: 根据info_id修改访问量
         * class_name: modifyVisit
         * param: [id]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/14/0014
         * creat_time: 22:30
         **/
        Infos infos = infosMapper.selectByPrimaryKey(id);
        int visit = infos.getVisit();
        visit++;
        infos.setVisit(visit);
        infosMapper.updateByPrimaryKey(infos);
        return visit;
    }

    @Override
    public List<Infos> getInfoByTypeId_foreach_array(SearchParam<Infos> msg) {
        /**
         * describe: 根据输入的type数据搜索info
         * class_name: getInfoByTypeId_foreach_array
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2018/2/3/0003
         * creat_time: 1:22
         **/
        return selfInfosMapper.getInfoByTypeId_foreach_array(msg);
    }

    @Override
    public int countInfoByTypeId_foreach_array(SearchParam<Infos> msg) {
        return selfInfosMapper.countInfoByTypeId_foreach_array(msg);
    }

    @Override
    public List<SelfInfos> selectInfoNumByReleaseTime(int num) {
        /**
         * describe: 根据数量找到最新的infos
         * class_name: selectInfoNumByReleaseTime
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.self.SelfInfos>
         * creat_user: ZHAN
         * creat_date: 2018/4/25/0025
         * creat_time: 15:37
         **/
        return selfInfosMapper.findInfosByReleaseTime(num);
    }
}
