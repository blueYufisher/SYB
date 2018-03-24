package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Pictures;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 14:24
 **/
public interface PicturesDao {
    /**
     * describe: 根据id获取Pictures
     * class_name: getPicturesById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.Pictures
     * creat_user: ZHAN
     * creat_date: 2017/12/11/0011
     * creat_time: 14:27
     **/
    Pictures getPicturesById(Integer id);

    /**
     * describe: 根据title获取Picture
     * class_name: getPicturesByTitle
     * param: [title]
     * return: cn.edu.gdut.llc.mybatis.model.Pictures
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:16
     **/
    Pictures getPicturesByTitle(String title);

    /**
     * describe: 根据md5获取Picture
     * class_name: getPictureByMd5
     * param: [md5]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:16
     **/
    List<Pictures> getPictureByMd5(String md5);

    /**
     * describe: 根据category_id获取Pictures
     * class_name: selectByCategoryId
     * param: [id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:17
     **/
    List<Pictures> selectByCategoryId(int id);

    /**
     * describe: 插入Picture数据
     * class_name: insertPicture
     * param: [record]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:17
     **/
    int insertPicture(Pictures record);

    /**
     * describe: 获得Pictures的总数
     * class_name: getPictureNum
     * param: []
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:18
     **/
    int getPictureNum();

    /**
     * describe: 删除Picture信息
     * class_name: deletePicture
     * param: [id]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:19
     **/
    void deletePicture(int id);

    /**
     * describe: 修改Picture信息
     * class_name: modifyPicture
     * param: [pictures]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:19
     **/
    void modifyPicture(Pictures pictures);

    /**
     * describe: 分页查找Pictures
     * class_name: getLimitPics
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:19
     **/
    List<Pictures> getLimitPics(SMParam<Pictures> param);

    void modifyPictureInfo(String category, int categoryId, int id);

    void updatePicture(Pictures pictures);
}
