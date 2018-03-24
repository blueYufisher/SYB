package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.ProjPic;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-11 19:06
 **/
public interface ProjectPictureDao {

    /**
     * describe: 根据pic_id查找proj_id
     * class_name: selectProjectIdByPictureId
     * param: [pic_id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.ProjPic>
     * creat_user: ZHAN
     * creat_date: 2018/1/9/0009
     * creat_time: 19:25
     **/
    List<ProjPic> selectProjectIdByPictureId(Integer pic_id);

    /**
     * describe: 插入pic_id数据返回info_pic_id
     * class_name: insertPictureIdRetuenID
     * param: [infopic]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/9/0009
     * creat_time: 19:39
     **/
    int insertPictureIdReturnID(ProjPic projPic);

    /**
     * describe: 更新project_id
     * class_name: updateProjectId
     * param: [projPic]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/11/0011
     * creat_time: 19:11
     **/
    void updateProjectId(ProjPic projPic);
    
}
