package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.InfoFile;
import cn.edu.gdut.llc.mybatis.model.Infopic;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:13
 **/
public interface InfoFileDao {


    /**
     * describe: 根据file_id查找info_id
     * class_name: selectInfoIdByFileId
     * param: [file_id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.InfoFile>
     * creat_user: ZHAN
     * creat_date: 2018/3/21/0021
     * creat_time: 19:51
     **/
    List<InfoFile> selectInfoIdByFileId(Integer file_id);

    /**
     * describe: 插入file_id数据返回info_file_id
     * class_name: insertFileIdRetuenID
     * param: [infoFile]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/3/21/0021
     * creat_time: 19:52
     **/
    int insertFileIdRetuenID(InfoFile infoFile);

    /**
     * describe: 更新info_id
     * class_name: updateInfoId
     * param: [infopic]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/11/0011
     * creat_time: 19:12
     **/
    void updateInfoId(InfoFile infoFile);
}
