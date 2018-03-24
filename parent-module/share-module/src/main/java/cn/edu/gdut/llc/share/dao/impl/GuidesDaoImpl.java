package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.GuidesMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfGuidesMapper;
import cn.edu.gdut.llc.mybatis.model.Guides;
import cn.edu.gdut.llc.mybatis.model.GuidesExample;
import cn.edu.gdut.llc.share.dao.GuidesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 15:43
 **/
@Repository
public class GuidesDaoImpl implements GuidesDao {

    @Autowired
    private GuidesMapper guidesMapper;
    @Autowired
    private SelfGuidesMapper selfGuidesMapper;

    @Override
    public Guides getGuidesById(Integer id) {
        /**
         * describe: 根据id查Guide
         * class_name: getGuidesById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Guides
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:44
         **/
        return guidesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Guides> findGuideByIdAndType(int id, String type) {
        /**
         * describe: 根据id和type查询Guides
         * class_name: findGuideByIdAndType
         * param: [id, type]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:48
         **/
        GuidesExample guidesExample = new GuidesExample();
        guidesExample.createCriteria().andIdEqualTo(id).andTypeEqualTo(type);
        return guidesMapper.selectByExampleWithBLOBs(guidesExample);
    }

    @Override
    public List<Guides> findGuidesByTypeList(SMParam<Guides> param) {
        /**
         * describe: 根据type查出该组的Guides并进行分页
         * class_name: findGuidesByTypeList
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Guides>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:12
         **/
        List<Guides> list = selfGuidesMapper.findGuidesByTypeList(param);
        System.out.println(list);
        return list;
    }

    @Override
    public int countGuidesByType(String type) {
        /**
         * describe: 根据type找出所有的Guides
         * class_name: countGuidesByType
         * param: [type]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:13
         **/
        return selfGuidesMapper.countGuidesByType(type);
    }
}
