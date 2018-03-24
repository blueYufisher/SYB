package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.PicturesMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfPicturesMapper;
import cn.edu.gdut.llc.mybatis.model.Pictures;
import cn.edu.gdut.llc.mybatis.model.PicturesExample;
import cn.edu.gdut.llc.share.dao.PicturesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 14:25
 **/
@Repository
public class PicturesDaoImpl implements PicturesDao {

    @Autowired
    private PicturesMapper picturesMapper;
    @Autowired
    private SelfPicturesMapper selfPicturesMapper;

    @Override
    public Pictures getPicturesById(Integer id) {
        /**
         * describe: 根据id获取Pictures
         * class_name: getPicturesById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Pictures
         * creat_user: ZHAN
         * creat_date: 2017/12/11/0011
         * creat_time: 14:27
         **/
        return picturesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Pictures getPicturesByTitle(String title) {
        /**
         * describe: 根据title获取Picture
         * class_name: getPicturesByTitle
         * param: [title]
         * return: cn.edu.gdut.llc.mybatis.model.Pictures
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:16
         **/
        PicturesExample example = new PicturesExample();
        example.createCriteria().andPicTitleEqualTo(title);

        return picturesMapper.selectByExample(example).get(0);
    }

    @Override
    public List<Pictures> getPictureByMd5(String md5) {
        /**
         * describe: 根据md5获取Picture
         * class_name: getPictureByMd5
         * param: [md5]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:16
         **/
        PicturesExample picturesExample = new PicturesExample();
        picturesExample.createCriteria().andPicMd5EqualTo(md5);
        return picturesMapper.selectByExample(picturesExample);
    }

    @Override
    public List<Pictures> selectByCategoryId(int id) {
        /**
         * describe: 根据category_id获取Pictures
         * class_name: selectByCategoryId
         * param: [id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:17
         **/
        PicturesExample picturesExample = new PicturesExample();
        picturesExample.createCriteria().andPicCategoryIdEqualTo(id);
        return picturesMapper.selectByExample(picturesExample);
    }

    @Override
    public int insertPicture(Pictures record) {
        /**
         * describe: 插入Picture数据
         * class_name: insertPicture
         * param: [record]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:17
         **/
        selfPicturesMapper.insertPicReturnID(record);
        return record.getPicId();
    }

    @Override
    public int getPictureNum() {
        /**
         * describe: 获得Pictures的总数
         * class_name: getPictureNum
         * param: []
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:18
         **/
        PicturesExample picturesExample = new PicturesExample();
        return picturesMapper.countByExample(picturesExample);
    }

    @Override
    public void deletePicture(int id) {
        /**
         * describe: 删除Picture信息
         * class_name: deletePicture
         * param: [id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:19
         **/
        picturesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void modifyPicture(Pictures pictures) {
        /**
         * describe: 修改Picture信息
         * class_name: modifyPicture
         * param: [pictures]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:19
         **/
        picturesMapper.updateByPrimaryKey(pictures);
    }

    @Override
    public List<Pictures> getLimitPics(SMParam<Pictures> param) {
        /**
         * describe: 分页查找Pictures
         * class_name: getLimitPics
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:19
         **/
        return selfPicturesMapper.findLimtPics(param);
    }

    @Override
    public void modifyPictureInfo(String category, int categoryId, int id) {
        Pictures pictures = picturesMapper.selectByPrimaryKey(id);
        pictures.setPicCategory(category);
        pictures.setPicCategoryId(categoryId);
        picturesMapper.updateByPrimaryKey(pictures);
    }

    @Override
    public void updatePicture(Pictures pictures) {
        picturesMapper.updateByPrimaryKey(pictures);
    }
}
