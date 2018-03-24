package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.ProjPicMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfProjPicMapper;
import cn.edu.gdut.llc.mybatis.model.ProjPic;
import cn.edu.gdut.llc.mybatis.model.ProjPicExample;
import cn.edu.gdut.llc.share.dao.ProjectPictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-11 19:08
 **/
@Repository
public class ProjectPictureDaoImpl implements ProjectPictureDao {

    @Autowired
    private ProjPicMapper projPicMapper;
    @Autowired
    private SelfProjPicMapper selfProjPicMapper;

    @Override
    public List<ProjPic> selectProjectIdByPictureId(Integer pic_id) {
        /**
         * describe: 根据pic_id查找project_id
         * class_name: selectProjectIdByPictureId
         * param: [pic_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.ProjPic>
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:09
         **/
        ProjPicExample projPicExample = new ProjPicExample();
        projPicExample.createCriteria().andPicidEqualTo(pic_id);
        return projPicMapper.selectByExample(projPicExample);
    }

    @Override
    public int insertPictureIdReturnID(ProjPic projPic) {
        /**
         * describe: 插入pic_id数据返回project_pic_id
         * class_name: insertPictureIdReturnID
         * param: [projPic]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:11
         **/
        selfProjPicMapper.insertPictureIdReturnID(projPic);
        return projPic.getId();
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
        projPicMapper.updateByPrimaryKey(projPic);
    }
}
