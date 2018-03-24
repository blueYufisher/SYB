package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.ProjFileMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfProjFileMapper;
import cn.edu.gdut.llc.mybatis.model.ProjFile;
import cn.edu.gdut.llc.mybatis.model.ProjFileExample;
import cn.edu.gdut.llc.share.dao.ProjectFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 19:55
 **/
@Repository
public class ProjectFileDaoImpl implements ProjectFileDao{

    @Autowired
    private ProjFileMapper projFileMapper;
    @Autowired
    private SelfProjFileMapper selfProjFileMapper;

    @Override
    public List<ProjFile> selectProjectIdByFileId(Integer file_id) {
        /**
         * describe: 根据file_id查找project_id
         * class_name: selectProjectIdByFileId
         * param: [file_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.ProjFile>
         * creat_user: ZHAN
         * creat_date: 2018/3/21/0021
         * creat_time: 19:57
         **/
        ProjFileExample projFileExample = new ProjFileExample();
        projFileExample.createCriteria().andFileidEqualTo(file_id);
        return projFileMapper.selectByExample(projFileExample);
    }

    @Override
    public int insertFileIdReturnID(ProjFile projFile) {
        /**
         * describe: 插入pic_id数据返回project_pic_id
         * class_name: insertFileIdReturnID
         * param: [projFile]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/3/21/0021
         * creat_time: 19:57
         **/
        selfProjFileMapper.insertFileIdReturnID(projFile);
        return projFile.getProjFileId();
    }

    @Override
    public void updateProjectId(ProjFile projFile) {
        /**
         * describe: 更新project_id
         * class_name: updateProjectId
         * param: [projPic]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:11
         **/
        projFileMapper.updateByPrimaryKey(projFile);

    }
}
