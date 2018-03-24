package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.InfoFile;

public interface SelfInfoFileMapper {
    /**
     * 插入文件并且返回id
     */
    Integer insertFileIdReturnID(InfoFile infoFile);

}