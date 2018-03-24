package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.ProjFile;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 20:19
 **/
public interface ProjectFileService {

    /**
     * describe: 根据file_id查找proj_id
     * class_name: selectProjectIdByFiletureId
     * param: [file_id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.ProjFile>
     * creat_user: ZHAN
     * creat_date: 2018/1/9/0009
     * creat_time: 19:25
     **/
    List<ProjFile> selectProjectIdByFileId(Integer file_id);

    /**
     * describe: 插入file_id数据返回info_file_id
     * class_name: insertFiletureIdRetuenID
     * param: [infofile]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/9/0009
     * creat_time: 19:39
     **/
    int insertFileIdReturnID(ProjFile projFile);

    /**
     * describe: 更新project_id
     * class_name: updateProjectId
     * param: [projFile]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/11/0011
     * creat_time: 19:11
     **/
    void updateProjectId(ProjFile projFile);
    
}
