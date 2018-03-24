package cn.edu.gdut.llc.mybatis.mapper.self;


import cn.edu.gdut.llc.mybatis.model.Infopic;

public interface SelfInfopicMapper {
    /**
     * 插入图片并且返回id
     */
    Integer insertPictureIdRetuenID(Infopic infopic);
}