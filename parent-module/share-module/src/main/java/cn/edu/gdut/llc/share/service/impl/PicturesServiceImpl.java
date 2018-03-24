package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.*;
import cn.edu.gdut.llc.mybatis.model.self.SelfInfos;
import cn.edu.gdut.llc.mybatis.model.self.SelfPictures;
import cn.edu.gdut.llc.share.dao.*;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.PicturesService;
import cn.edu.gdut.llc.share.util.UpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.Line;
import java.awt.geom.PathIterator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 14:28
 **/
@Service
public class PicturesServiceImpl implements PicturesService {

    @Autowired
    @Qualifier("picturesDaoImpl")
    private PicturesDao picturesDao;

    @Autowired
    @Qualifier("infosDaoImpl")
    private InfosDao infosDao;

    @Autowired
    @Qualifier("typeDaoImpl")
    private TypeDao typeDao;

    @Autowired
    @Qualifier("infoPictureDaoImpl")
    private InfoPictureDao infoPictureDao;

    @Autowired
    @Qualifier("projectPictureDaoImpl")
    private ProjectPictureDao projectPictureDao;

    @Autowired
    @Qualifier("projectDaoImpl")
    private ProjectDao projectDao;

    @Autowired
    private Environment env;

    @Override
    public SelfPictures getPicturesById(Integer id) {
        /**
         * describe: 根据id获取Pictures
         * class_name: getPicturesById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Pictures
         * creat_user: ZHAN
         * creat_date: 2017/12/11/0011
         * creat_time: 14:27
         **/
        Pictures pictures = picturesDao.getPicturesById(id);
        SelfPictures selfPictures = new SelfPictures();
        int pic_id = pictures.getPicId();

        //根据pic_id查info_id
        List<Infopic> infopicList = infoPictureDao.selectInfoIdByPictureId(pic_id);
        if(infopicList.size() != 0){
            int info_id = infoPictureDao.selectInfoIdByPictureId(pic_id).get(0).getInfoid();

            //根据info_id查info[type,title]
            SelfInfos infos = infosDao.getInfosById(info_id);
            String infoTitle = infos.getTitle();
            int typeId = infos.getType();
            String typeTitle = typeDao.getTypeById(typeId).getTypeTitle();
            selfPictures.setInfoTitle(infoTitle);
            selfPictures.setTypeTitle(typeTitle);
        }

        //根据pic_id查project_id
        List<ProjPic> projPicList = projectPictureDao.selectProjectIdByPictureId(pic_id);
        if(projPicList.size() != 0) {
            int project_id = projectPictureDao.selectProjectIdByPictureId(pic_id).get(0).getProjid();

            //根据project_id查projName
            Project project = projectDao.getProjectById(project_id);
            String projName = project.getProjName();
            int typeId = 4;
            String typeTitle = typeDao.getTypeById(typeId).getTypeTitle();
            selfPictures.setInfoTitle(projName);
            selfPictures.setTypeTitle(typeTitle);
        }
        selfPictures.setId(pictures.getPicId());
        selfPictures.setCategory(pictures.getPicCategory());
        selfPictures.setTitle(pictures.getPicTitle());
        selfPictures.setUrl(pictures.getPicUrl());
        selfPictures.setNote(pictures.getPicNote());
        selfPictures.setUpdateTime(pictures.getPicUpdateTime());
        selfPictures.setLocation(pictures.getPicLocation());
        return selfPictures;
    }

    @Override
    public Pictures getPicturesByTitle(String title) {
        /**
         * describe: 根据md5获取Picture
         * class_name: getPicturesByTitle
         * param: [title]
         * return: cn.edu.gdut.llc.mybatis.model.Pictures
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:24
         **/
        return picturesDao.getPicturesByTitle(title);
    }

    @Override
    public List<Pictures> getPictureByMd5(String md5) {
        /**
         * describe: 根据category_id获取Pictures
         * class_name: getPictureByMd5
         * param: [md5]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:24
         **/
        // TODO Auto-generated method stub
        if (md5 == null) {
            System.out.println("md5为空");
        }

        return picturesDao.getPictureByMd5(md5);
    }

    @Override
    public List<Pictures> selectByCategoryId(int id) {
        /**
         * describe: 插入Picture数据
         * class_name: selectByCategoryId
         * param: [id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Pictures>
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:24
         **/
        return picturesDao.selectByCategoryId(id);
    }

    @Override
    public int insertPicture(Pictures record) {
        /**
         * describe: 获得Pictures的总数
         * class_name: insertPicture
         * param: [record]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:24
         **/
        return picturesDao.insertPicture(record);
    }

    @Override
    public int getPictureNum() {
        /**
         * describe: 获得Pictures的总数
         * class_name: getPictureNum
         * param: []
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:25
         **/
        return picturesDao.getPictureNum();
    }

    @Transactional
    public void deletePicture(int id) {
        /**
         * describe: 删除Picture信息
         * class_name: deletePicture
         * param: [id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:26
         **/
        String picurl = picturesDao.getPicturesById(id).getPicUrl();
        String root = env.getProperty("pic.root.path");
        picurl = root + picurl;
        UpLoadUtils.deleteFile(picurl);
        picturesDao.deletePicture(id);
    }

    @Transactional
    public void modifyPicture(MultipartFile file, String title, int id) {
        /**
         * describe: 修改Picture信息
         * class_name: modifyPicture
         * param: [file, title, id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:26
         **/
        try {
            // 删除原来的图片
            String picurl = picturesDao.getPicturesById(id).getPicUrl();
            String root = env.getProperty("pic.root.path");
            picurl = root + picurl;
            UpLoadUtils.deleteFile(picurl);

            //判断图片是否在数据库当中存在，不存在则获取图片信息
            Pictures pic = getSavePicInf(file, title);

            //修改数据库当中的图片信息
            pic.setPicId(id);
            picturesDao.modifyPicture(pic);

            //将新的图片文件保存到指定位置
            storePicFile(pic, file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public SCresponse<SelfPictures> getLimitPics(CSparam<Pictures> param) {
        /**
         * describe: 分页查找Pictures
         * class_name: getLimitPics
         * param: [param]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Pictures>
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:27
         **/
        int currentPage = param.getCurrentPage();
        int pageSize = param.getPageSize();

        // 设置传给Dao层的参数对象
        SMParam<Pictures> smparam = new SMParam<Pictures>();
        int startNum = (currentPage - 1) * pageSize;
        smparam.setStartNum(startNum);
        smparam.setPageSize(pageSize);

        // 查询分页结果
        List<Pictures> resultList = picturesDao.getLimitPics(smparam);

        List<SelfPictures> selfPicturesList = new ArrayList<SelfPictures>();
        for(Pictures pictures:resultList){
            SelfPictures selfPictures = new SelfPictures();
            int pic_id = pictures.getPicId();

            //根据pic_id查info_id
            List<Infopic> infopicList = infoPictureDao.selectInfoIdByPictureId(pic_id);
            if(infopicList.size() != 0){
                int info_id = infoPictureDao.selectInfoIdByPictureId(pic_id).get(0).getInfoid();

                //根据info_id查info[type,title]
                SelfInfos infos = infosDao.getInfosById(info_id);
                String infoTitle = infos.getTitle();
                int typeId = infos.getType();
                String typeTitle = typeDao.getTypeById(typeId).getTypeTitle();
                selfPictures.setInfoTitle(infoTitle);
                selfPictures.setTypeTitle(typeTitle);
            }

            //根据pic_id查project_id
            List<ProjPic> projPicList = projectPictureDao.selectProjectIdByPictureId(pic_id);
            if(projPicList.size() != 0) {
                int project_id = projectPictureDao.selectProjectIdByPictureId(pic_id).get(0).getProjid();

                //根据project_id查projName
                Project project = projectDao.getProjectById(project_id);
                String projName = project.getProjName();
                int typeId = 4;
                String typeTitle = typeDao.getTypeById(typeId).getTypeTitle();
                selfPictures.setInfoTitle(projName);
                selfPictures.setTypeTitle(typeTitle);
            }

//            String category_id = String.valueOf(pictures.getCategoryId());
//            int categoryId = 0;
//            if (!category_id.equals("null")){
//                categoryId = Integer.parseInt(category_id);
//                String infoTitle = infosDao.getInfosById(categoryId).getTitle();
//                selfPictures.setInfoTitle(infoTitle);
//            }
//            String category = pictures.getCategory();
//            if( category != null ) {
//                int typeId = Integer.parseInt(category);
//                String typeTitle = typeDao.getTypeById(typeId).getTitle();
//                selfPictures.setTypeTitle(typeTitle);
//            }
            selfPictures.setId(pictures.getPicId());
            selfPictures.setCategory(pictures.getPicCategory());
            selfPictures.setTitle(pictures.getPicTitle());
            selfPictures.setUrl(pictures.getPicUrl());
            selfPictures.setNote(pictures.getPicNote());
            selfPictures.setUpdateTime(pictures.getPicUpdateTime());
            selfPictures.setLocation(pictures.getPicLocation());
            selfPicturesList.add(selfPictures);
        }

        // 查询计算总页数
        int picNum = picturesDao.getPictureNum();
        int totalPage = (int) Math.ceil((double) picNum / pageSize);

        // 生成返回对象
        SCresponse<SelfPictures> response = new SCresponse<SelfPictures>();
        response.setResultList(selfPicturesList);
        response.setTotalPage(totalPage);

        // 返回
        return response;
    }

    @Transactional
    public void updatePicture(Pictures pictures) {
    	
        picturesDao.updatePicture(pictures);
    }

    @Transactional
    public int uploadPicture(MultipartFile file, String title) {
        /**
         * describe: 上传picture图片
         * class_name: uploadPicture
         * param: [file, title]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:25
         **/
        int key;
        try {
            // 判断数据库当中是否已经存在该图片，如果不存在获取图片信息，存在则抛出异常
            Pictures pic = getSavePicInf(file, title);
            // 向数据库当中插入图片信息
            key = picturesDao.insertPicture(pic);
            // 将图片文件上传到指定的路径
            storePicFile(pic, file);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return key;
    }

    @Transactional
    public int uploadAvatar(MultipartFile file, String title) {
        /**
         * describe: 上传avatar图片
         * class_name: uploadAvatar
         * param: [file, title]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/2/17/0017
         * creat_time: 21:32
         **/
        int key;
        try {
            // 判断数据库当中是否已经存在该图片，如果不存在获取图片信息，存在则抛出异常
            Pictures pic = getSavePicInf(file, title);
            // 向数据库当中插入图片信息
            key = picturesDao.insertPicture(pic);
            // 将图片文件上传到指定的路径
            storeAvatarFile(pic, file);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return key;
    }

    /*****************************************************************************************/
    private Pictures getSavePicInf(MultipartFile file, String title) throws IOException, NoSuchAlgorithmException {
        /**
         * describe: 判断图片是否已经存在，获取保存图片所需的各种信息
         * class_name: getSavePicInf
         * param: [file, title]
         * return: cn.edu.gdut.llc.mybatis.model.Pictures
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:27
         **/
        //获取图片的MD5
        byte[] bytes = file.getBytes();
        String md5Result = UpLoadUtils.getMd5(bytes);
        int code;
        // 判断该图片是否早已存在
        if ((code = isAleardyExist(md5Result)) != -1) {
            // 存在
            throw new RuntimeException("图片已经存在,id为：" + code);
        } else {
            // 获取原始的文件名
            String fileName = file.getOriginalFilename();
            // 去除文件名当中存在的路径信息
            int index = fileName.lastIndexOf("\\");
            if (index != -1)
                fileName = fileName.substring(index + 1);
            //根据图片的名称的哈希值将图片分布到不同的子文件夹当中
            String hashCode = Integer.toHexString(fileName.hashCode());
//            String savePath = hashCode.charAt(0) + "\\" + hashCode.charAt(1) + "\\";
            // 创建文件的保存名
//            String saveName = fileName;
////            String saveName = md5Result + fileName;
            
          //记录当前时间
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//            System.out.println("当前时间：" + sdf.format(d));

            String savePath = sdf.format(d) + "\\";
            // 创建文件的保存名
            String saveName = sdf.format(d) + hashCode.charAt(0) + hashCode.charAt(1) + "." +fileName.split("\\.")[fileName.split("\\.").length-1];
//            String saveName = md5Result + fileName;


            // 创建图片对象
            Pictures pic = new Pictures();
            pic.setPicMd5(md5Result);
            pic.setPicTitle(title);
            pic.setPicUrl(savePath + saveName);
            Date date = new Date();
            pic.setPicUpdateTime(date);
            return pic;
        }

    }

    private int isAleardyExist(String md5) {
        /**
         * describe: 判断数据库当中是否已经存在此图片
         * class_name: isAleardyExist
         * param: [md5]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:27
         **/
        List<Pictures> pic = null;
        pic = getPictureByMd5(md5);
        if (pic.isEmpty())
            return -1;
        else
            return pic.get(0).getPicId();
    }

    private void storePicFile(Pictures pic, MultipartFile file) throws IOException {
        /**
         * describe: 将图片文件写到指定位置
         * class_name: storePicFile
         * param: [pic, file]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:28
         **/
        //获取图片的名称和存储路径
        String url = pic.getPicUrl();
        int start = url.lastIndexOf('\\');
        String saveName = url.substring(start + 1);
        String directory = env.getProperty("pic.root.path") + url.substring(0, start + 1);

        //判断路径是否存在，不存在则创建路径
        File f = new File(directory);
        if (!f.exists())
            f.mkdirs();

        // 将图片写入保存的位置
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(directory + saveName));
        stream.write(file.getBytes());
        stream.close();
    }

    private void storeAvatarFile(Pictures pic, MultipartFile file) throws IOException {
        /**
         * describe: 将头像图片写到指定位置
         * class_name: storeAvatarFile
         * param: [pic, file]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/2/17/0017
         * creat_time: 21:31
         **/
        //获取图片的名称和存储路径
        String url = pic.getPicUrl();
        int start = url.lastIndexOf('\\');
        String saveName = url.substring(start + 1);
        String directory = env.getProperty("avatar.root.path") + url.substring(0, start + 1);

        //判断路径是否存在，不存在则创建路径
        File f = new File(directory);
        if (!f.exists())
            f.mkdirs();

        // 将图片写入保存的位置
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(directory + saveName));
        stream.write(file.getBytes());
        stream.close();
    }





}
