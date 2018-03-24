package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.ProjFile;

public interface SelfProjFileMapper {

    /**
     * 插入文件并且返回id
     */
    Integer insertFileIdReturnID(ProjFile projFile);

}