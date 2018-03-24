package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.Infopic;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-09 19:41
 **/
public interface InfoPictureService {

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

    void updateInfoId(Infopic infopic);

}
