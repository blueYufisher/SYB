package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.InfopicMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfInfopicMapper;
import cn.edu.gdut.llc.mybatis.model.Infopic;
import cn.edu.gdut.llc.mybatis.model.InfopicExample;
import cn.edu.gdut.llc.share.dao.InfoPictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-09 17:09
 **/
@Repository
public class InfoPictureDaoImpl implements InfoPictureDao {
    @Autowired
    private InfopicMapper infopicMapper;
    @Autowired
    private SelfInfopicMapper selfInfopicMapper;

    @Override
    public List<Infopic> selectInfoIdByPictureId(Integer pic_id) {
        /**
         * describe: 根据pic_id查找info_id
         * class_name: selectInfoIdByPictureId
         * param: [pic_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infopic>
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:25
         **/
        InfopicExample infopicExample = new InfopicExample();
        infopicExample.createCriteria().andPicidEqualTo(pic_id);
        return infopicMapper.selectByExample(infopicExample);
    }

    @Override
    public int insertPictureIdRetuenID(Infopic infopic) {
        /**
         * describe: 插入pic_id数据返回info_pic_id
         * class_name: insertPictureIdRetuenID
         * param: [infopic]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        selfInfopicMapper.insertPictureIdRetuenID(infopic);
        return infopic.getId();
    }

    @Override
    public void updateInfoId(Infopic infopic) {
        /**
         * describe: 更新info_id
         * class_name: updateInfoId
         * param: [infopic]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:12
         **/
        infopicMapper.updateByPrimaryKey(infopic);
    }


}
