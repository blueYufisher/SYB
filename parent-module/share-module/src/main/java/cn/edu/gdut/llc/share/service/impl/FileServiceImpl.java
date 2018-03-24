package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.File;
import cn.edu.gdut.llc.share.dao.*;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.FileService;
import cn.edu.gdut.llc.share.util.UpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-15 11:07
 **/
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    @Qualifier("fileDaoImpl")
    private FileDao fileDao;

    @Autowired
    @Qualifier("infosDaoImpl")
    private InfosDao infosDao;

    @Autowired
    @Qualifier("typeDaoImpl")
    private TypeDao typeDao;

    @Autowired
    @Qualifier("infoFileDaoImpl")
    private InfoFileDao infoFileDao;

    @Autowired
    @Qualifier("projectFileDaoImpl")
    private ProjectFileDao projectFileDao;

    @Autowired
    @Qualifier("projectDaoImpl")
    private ProjectDao projectDao;


    @Autowired
    private Environment env;

    @Override
    public File getFileById(Integer id) {
        /**
         * describe: 根据id获取File
         * class_name: getFileById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.File
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 10:57
         **/
        return fileDao.getFileById(id);
    }

    @Override
    public File getFileByTitle(String title) {
        /**
         * describe: 根据title获取File
         * class_name: getFileByTitle
         * param: [title]
         * return: cn.edu.gdut.llc.mybatis.model.File
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 10:58
         **/
        return fileDao.getFileByTitle(title);
    }

    @Override
    public List<File> getFileByMd5(String md5) {
        /**
         * describe: 根据md5获取File
         * class_name: getFileByMd5
         * param: [md5]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.File>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 10:59
         **/
        if (md5 == null) {
            System.out.println("md5为空");
        }

        return fileDao.getFileByMd5(md5);
    }

    @Override
    public int insertFile(File record) {
        /**
         * describe: 插入File数据
         * class_name: insertFile
         * param: [record]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:00
         **/
        return fileDao.insertFile(record);
    }

    @Override
    public int getFileNum() {
        /**
         * describe: 获得File的总数
         * class_name: getFileNum
         * param: []
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:00
         **/
        return fileDao.getFileNum();
    }

    @Transactional
    public void deleteFile(int id) {
        /**
         * describe: 删除File信息
         * class_name: deleteFile
         * param: [id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:01
         **/
        String url = fileDao.getFileById(id).getFileUrl();
        String root = env.getProperty("file.root.path");
        url = root + url;
        UpLoadUtils.deleteFile(url);
        fileDao.deleteFile(id);
    }

    @Transactional
    public void modifyFile(MultipartFile file, String title, int id) {
        /**
         * describe: 修改File信息
         * class_name: modifyFile
         * param: [pictures]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:01
         **/
        try {
            // 删除原来的file
            String url = fileDao.getFileById(id).getFileUrl();
            String root = env.getProperty("file.root.path");
            url = root + url;
            UpLoadUtils.deleteFile(url);

            //判断file是否在数据库当中存在，不存在则获取file信息
            File file1 = getSaveFileInf(file, title);

            //修改数据库当中的File信息
            file1.setFileId(id);
            fileDao.modifyFile(file1);

            //将新的File文件保存到指定位置
            storePicFile(file1, file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public SCresponse<File> getLimitFiles(CSparam<File> param) {
        /**
         * describe: 分页查找File
         * class_name: getLimitFiles
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.File>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:02
         **/
        int currentPage = param.getCurrentPage();
        int pageSize = param.getPageSize();

        // 设置传给Dao层的参数对象
        SMParam<File> smparam = new SMParam<File>();
        int startNum = (currentPage - 1) * pageSize;
        smparam.setStartNum(startNum);
        smparam.setPageSize(pageSize);
        // 查询分页结果
        List<File> resultList = fileDao.getLimitFiles(smparam);
        // 查询计算总页数
        int fileNum = fileDao.getFileNum();
        int totalPage = (int) Math.ceil((double) fileNum / pageSize);

        // 生成返回对象
        SCresponse<File> response = new SCresponse<File>();
        response.setResultList(resultList);
        response.setTotalPage(totalPage);

        // 返回
        return response;
    }

    @Transactional
    public void updateFile(File file) {
        fileDao.updateFile(file);
    }

    @Transactional
    public int uploadFile(MultipartFile file, String title) {
        /**
         * describe: 上传file
         * class_name: uploadFile
         * param: [file, title]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:21
         **/
        int key;
        try {
            // 判断数据库当中是否已经存在该File，如果不存在获取File信息，存在则抛出异常
            File file1 = getSaveFileInf(file, title);
            // 向数据库当中插入File信息
            key = fileDao.insertFile(file1);
            // 将File文件上传到指定的路径
            storePicFile(file1, file);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return key;
    }

    /*****************************************************************************************/
    private File getSaveFileInf(MultipartFile file, String title) throws IOException, NoSuchAlgorithmException {
        /**
         * describe: 判断File是否已经存在，获取保存File所需的各种信息
         * class_name: getSaveFileInf
         * param: [file, title]
         * return: cn.edu.gdut.llc.mybatis.model.File
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:18
         **/
        //获取File的MD5
        byte[] bytes = file.getBytes();
        String md5Result = UpLoadUtils.getMd5(bytes);
        int code;
        // 判断该File是否早已存在
        if ((code = isAleardyExist(md5Result)) != -1) {
            // 存在
            throw new RuntimeException("File已经存在,id为：" + code);
        } else {
            // 获取原始的文件名
            String fileName = file.getOriginalFilename();
            // 去除文件名当中存在的路径信息
            int index = fileName.lastIndexOf("\\");
            if (index != -1)
                fileName = fileName.substring(index + 1);
            //根据File的名称的哈希值将File分布到不同的子文件夹当中
            String hashCode = Integer.toHexString(fileName.hashCode());
//            String savePath = hashCode.charAt(0) + "\\" + hashCode.charAt(1) + "\\";

            //记录当前时间
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//            System.out.println("当前时间：" + sdf.format(d));

            String savePath = sdf.format(d) + "\\";
            // 创建文件的保存名
            String saveName = sdf.format(d) + hashCode.charAt(0) + hashCode.charAt(1) + "." +fileName.split("\\.")[fileName.split("\\.").length-1];
//            String saveName = md5Result + fileName;


            // 创建File对象
            File file1 = new File();
            file1.setFileMd5(md5Result);
            file1.setFileTitle(title);
            file1.setFileUrl(savePath + saveName);
            Date date = new Date();
            file1.setFileUpdateTime(date);
            return file1;
        }

    }

    private int isAleardyExist(String md5) {
        /**
         * describe: 判断数据库当中是否已经存在此File
         * class_name: isAleardyExist
         * param: [md5]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:20
         **/
        List<File> pic = null;
        pic = getFileByMd5(md5);
        if (pic.isEmpty())
            return -1;
        else
            return pic.get(0).getFileId();
    }

    private void storePicFile(File file1, MultipartFile file) throws IOException {
        /**
         * describe: 将File文件写到指定位置
         * class_name: storePicFile
         * param: [file1, file]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:20
         **/
        //获取File的名称和存储路径
        String url = file1.getFileUrl();
        int start = url.lastIndexOf('\\');
        String saveName = url.substring(start + 1);
        String directory = env.getProperty("file.root.path") + url.substring(0, start + 1);

        //判断路径是否存在，不存在则创建路径
        java.io.File f = new java.io.File(directory);
        if (!f.exists())
            f.mkdirs();

        // 将File写入保存的位置
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(directory + saveName));
        stream.write(file.getBytes());
        stream.close();
    }

}
