package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.Infopic;
import cn.edu.gdut.llc.share.dao.InfoPictureDao;
import cn.edu.gdut.llc.share.service.InfoPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-09 19:42
 **/
@Service
public class InfoPictureServiceImpl implements InfoPictureService{

    @Autowired
    @Qualifier("infoPictureDaoImpl")
    private InfoPictureDao infoPictureDao;

    @Override
    public List<Infopic> selectInfoIdByPictureId(Integer pic_id) {
        /**
         * describe: 根据pic_id查找info_id
         * class_name: selectInfoIdByPictureId
         * param: [pic_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infopic>
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:25
         **/
        return infoPictureDao.selectInfoIdByPictureId(pic_id);
    }

    @Override
    public int insertPictureIdRetuenID(Infopic infopic) {
        /**
         * describe: 插入pic_id数据返回info_pic_id
         * class_name: insertPictureIdRetuenID
         * param: [infopic]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        return infoPictureDao.insertPictureIdRetuenID(infopic);
    }

    @Override
    public void updateInfoId(Infopic infopic) {
        infoPictureDao.updateInfoId(infopic);
    }
}
