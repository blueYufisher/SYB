package cn.edu.gdut.llc.mybatis.mapper.self;


import cn.edu.gdut.llc.mybatis.model.Pictures;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

public interface SelfPicturesMapper {
    /**
     * 分页查找图片
     * @return
     */
    List<Pictures> findLimtPics(SMParam<Pictures> param);
    /**
     * 插入图片并且返回id
     */
    Integer insertPicReturnID(Pictures pic);
}