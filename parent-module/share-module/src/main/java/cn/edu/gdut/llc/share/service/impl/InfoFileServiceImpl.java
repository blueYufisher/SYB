package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.InfoFile;
import cn.edu.gdut.llc.share.dao.InfoFileDao;
import cn.edu.gdut.llc.share.service.InfoFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 20:14
 **/
@Service
public class InfoFileServiceImpl implements InfoFileService{

    @Autowired
    @Qualifier("infoFileDaoImpl")
    private InfoFileDao infoFileDao;

    @Override
    public List<InfoFile> selectInfoIdByFileId(Integer file_id) {
        /**
         * describe: 根据file_id查找info_id
         * class_name: selectInfoIdByFileId
         * param: [file_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.InfoFile>
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:25
         **/
        return infoFileDao.selectInfoIdByFileId(file_id);
    }

    @Override
    public int insertFileIdReturnID(InfoFile infofile) {
        /**
         * describe: 插入file_id数据返回info_file_id
         * class_name: insertFileIdRetuenID
         * param: [infofile]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        return infoFileDao.insertFileIdRetuenID(infofile);
    }

    @Override
    public void updateInfoId(InfoFile infofile) {
        infoFileDao.updateInfoId(infofile);
    }
}
