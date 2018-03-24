package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.InfoFile;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-09 19:41
 **/
public interface InfoFileService {

    List<InfoFile> selectInfoIdByFileId(Integer file_id);

    int insertFileIdReturnID(InfoFile infoFile);

    void updateInfoId(InfoFile infoFile);

}
