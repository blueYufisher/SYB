package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Pictures;
import cn.edu.gdut.llc.mybatis.model.self.SelfPictures;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 14:27
 **/
public interface PicturesService {
    /**
     * describe: 根据id获取Pictures
     * class_name: getPicturesById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.Pictures
     * creat_user: ZHAN
     * creat_date: 2017/12/11/0011
     * creat_time: 14:27
     **/
    SelfPictures getPicturesById(Integer id);

    /**
     * describe: 根据md5获取Picture
     * class_name: getPicturesByTitle
     * param: [title]
     * return: cn.edu.gdut.llc.mybatis.model.Pictures
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:24
     **/
    Pictures getPicturesByTitle(String title);

    /**
     * describe: 根据category_id获取Pictures
     * class_name: getPictureByMd5
     * param: [md5]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:24
     **/
    List<Pictures> getPictureByMd5(String md5);

    /**
     * describe: 插入Picture数据
     * class_name: selectByCategoryId
     * param: [id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:24
     **/
    List<Pictures> selectByCategoryId(int id);

    /**
     * describe: 获得Pictures的总数
     * class_name: insertPicture
     * param: [record]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:24
     **/
    int insertPicture(Pictures record);

    /**
     * describe: 上传picture图片
     * class_name: uploadPicture
     * param: [file, title]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:25
     **/
    int uploadPicture(MultipartFile file, String title, String picLocation) throws IOException, NoSuchAlgorithmException;

    /**
     * describe: 上传avatar图片
     * class_name: uploadAvatar
     * param: [file, title]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/2/17/0017
     * creat_time: 21:32
     **/
    int uploadAvatar(MultipartFile file, String title, String picLocation) throws IOException, NoSuchAlgorithmException;

    /**
     * describe: 获得Pictures的总数
     * class_name: getPictureNum
     * param: []
     * return: int
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:25
     **/
    int getPictureNum();

    /**
     * describe: 删除Picture信息
     * class_name: deletePicture
     * param: [id]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:26
     **/
    void deletePicture(int id) throws Exception;

    /**
     * describe: 修改Picture信息
     * class_name: modifyPicture
     * param: [file, title, id]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:26
     **/
    void modifyPicture(MultipartFile file,  String title, int id) throws IOException, NoSuchAlgorithmException;

    /**
     * describe: 分页查找Pictures
     * class_name: getLimitPics
     * param: [param]
     * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Pictures>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:27
     **/
    SCresponse<SelfPictures> getLimitPics(CSparam<Pictures> param);

    void updatePicture(Pictures pictures);

    
    void modifyPictureInfo(String category, int categoryId, int[] id); 
}
