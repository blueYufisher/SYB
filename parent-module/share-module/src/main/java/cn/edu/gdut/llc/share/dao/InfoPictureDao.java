package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Infopic;
import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:13
 **/
public interface InfoPictureDao {


    /**
     * describe: 根据pic_id查找info_id
     * class_name: selectInfoIdByPictureId
     * param: [pic_id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infopic>
     * creat_user: ZHAN
     * creat_date: 2018/1/9/0009
     * creat_time: 19:25
     **/
    List<Infopic> selectInfoIdByPictureId(Integer pic_id);

    /**
     * describe: 插入pic_id数据返回info_pic_id
     * class_name: insertPictureIdRetuenID
     * param: [infopic]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/9/0009
     * creat_time: 19:39
     **/
    int insertPictureIdRetuenID(Infopic infopic);

    /**
     * describe: 更新info_id
     * class_name: updateInfoId
     * param: [infopic]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/11/0011
     * creat_time: 19:12
     **/
    void updateInfoId(Infopic infopic);
}
