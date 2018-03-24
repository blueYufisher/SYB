package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.ProjPic;
import cn.edu.gdut.llc.share.dao.ProjectPictureDao;
import cn.edu.gdut.llc.share.service.ProjectPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-11 19:17
 **/
@Service
public class ProjectPictureServiceImpl implements ProjectPictureService{

    @Autowired
    @Qualifier("projectPictureDaoImpl")
    private ProjectPictureDao projectPictureDao;

    @Override
    public List<ProjPic> selectProjectIdByPictureId(Integer pic_id) {
        /**
         * describe: 根据pic_id查找proj_id
         * class_name: selectProjectIdByPictureId
         * param: [pic_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.ProjPic>
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:25
         **/
        return projectPictureDao.selectProjectIdByPictureId(pic_id);
    }

    @Override
    public int insertPictureIdReturnID(ProjPic projPic) {
        /**
         * describe: 插入pic_id数据返回info_pic_id
         * class_name: insertPictureIdRetuenID
         * param: [infopic]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        return projectPictureDao.insertPictureIdReturnID(projPic);
    }

    @Override
    public void updateProjectId(ProjPic projPic) {
        /**
         * describe: 更新project_id
         * class_name: updateProjectId
         * param: [projPic]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:11
         **/
        projectPictureDao.updateProjectId(projPic);
    }
}
