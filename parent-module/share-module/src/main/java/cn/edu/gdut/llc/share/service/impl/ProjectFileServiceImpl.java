package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.ProjFile;
import cn.edu.gdut.llc.share.dao.ProjectFileDao;
import cn.edu.gdut.llc.share.service.ProjectFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 20:26
 **/
@Service
public class ProjectFileServiceImpl implements ProjectFileService{
    @Autowired
    @Qualifier("projectFileDaoImpl")
    private ProjectFileDao projectFileDao;

    @Override
    public List<ProjFile> selectProjectIdByFileId(Integer file_id) {
        return projectFileDao.selectProjectIdByFileId(file_id);
    }

    @Override
    public int insertFileIdReturnID(ProjFile projFile) {
        return projectFileDao.insertFileIdReturnID(projFile);
    }

    @Override
    public void updateProjectId(ProjFile projFile) {
        projectFileDao.updateProjectId(projFile);
    }
}
