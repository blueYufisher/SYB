package cn.edu.gdut.llc.mybatis.mapper.self;


import cn.edu.gdut.llc.mybatis.model.File;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

public interface SelfFileMapper {
    /**
     * 分页查找file
     * @return
     */
    List<File> findLimtFiles(SMParam<File> param);
    /**
     * 插入file并且返回id
     */
    Integer insertFilesReturnID(File file);
}