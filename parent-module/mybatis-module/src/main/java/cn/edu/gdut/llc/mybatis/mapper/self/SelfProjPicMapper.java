package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.ProjPic;

public interface SelfProjPicMapper {
    /**
     * 插入图片并且返回id
     */
    Integer insertPictureIdReturnID(ProjPic projPic);
}