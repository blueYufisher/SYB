package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.InfoFileMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfInfoFileMapper;
import cn.edu.gdut.llc.mybatis.model.InfoFile;
import cn.edu.gdut.llc.mybatis.model.InfoFileExample;
import cn.edu.gdut.llc.share.dao.InfoFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 19:49
 **/
@Repository
public class InfoFileDaoImpl implements InfoFileDao{

    @Autowired
    private InfoFileMapper infoFileMapper;
    @Autowired
    private SelfInfoFileMapper selfInfoFileMapper;

    @Override
    public List<InfoFile> selectInfoIdByFileId(Integer file_id) {
        /**
         * describe: 根据file_id查找info_id
         * class_name: selectInfoIdByFileId
         * param: [file_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.InfoFile>
         * creat_user: ZHAN
         * creat_date: 2018/3/21/0021
         * creat_time: 19:51
         **/
        InfoFileExample infoFileExample = new InfoFileExample();
        infoFileExample.createCriteria().andFileidEqualTo(file_id);
        return infoFileMapper.selectByExample(infoFileExample);
    }

    @Override
    public int insertFileIdRetuenID(InfoFile infoFile) {
        /**
         * describe: 插入file_id数据返回info_file_id
         * class_name: insertFileIdRetuenID
         * param: [infoFile]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/3/21/0021
         * creat_time: 19:52
         **/
        selfInfoFileMapper.insertFileIdReturnID(infoFile);
        return infoFile.getInfoFileId();
    }

    @Override
    public void updateInfoId(InfoFile infoFile) {
        /**
         * describe: 更新info_id
         * class_name: updateInfoId
         * param: [infoFile]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/3/21/0021
         * creat_time: 19:53
         **/
        infoFileMapper.updateByPrimaryKey(infoFile);
    }
}
