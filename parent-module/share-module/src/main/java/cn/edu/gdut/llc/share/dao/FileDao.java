package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.File;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-15 10:54
 **/
public interface FileDao {

    /**
     * describe: 根据id获取File
     * class_name: getFileById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.File
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 10:57
     **/
    File getFileById(Integer id);

    /**
     * describe: 根据title获取File
     * class_name: getFileByTitle
     * param: [title]
     * return: cn.edu.gdut.llc.mybatis.model.File
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 10:58
     **/
    File getFileByTitle(String title);

    /**
     * describe: 根据md5获取File
     * class_name: getFileByMd5
     * param: [md5]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.File>
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 10:59
     **/
    List<File> getFileByMd5(String md5);

    /**
     * describe: 根据category_id获取File
     * class_name: selectByCategoryId
     * param: [id]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.File>
     * creat_user: ZHAN
     * creat_date: 2017/12/31/0031
     * creat_time: 14:17
     **/
//    List<File> selectByCategoryId(int id);

    /**
     * describe: 插入File数据
     * class_name: insertFile
     * param: [record]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 11:00
     **/
    int insertFile(File record);

    /**
     * describe: 获得File的总数
     * class_name: getFileNum
     * param: []
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 11:00
     **/
    int getFileNum();

    /**
     * describe: 删除File信息
     * class_name: deleteFile
     * param: [id]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 11:01
     **/
    void deleteFile(int id);

    /**
     * describe: 修改File信息
     * class_name: modifyFile
     * param: [pictures]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 11:01
     **/
    void modifyFile(File pictures);

    /**
     * describe: 分页查找File
     * class_name: getLimitFiles
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.File>
     * creat_user: ZHAN
     * creat_date: 2018/1/15/0015
     * creat_time: 11:02
     **/
    List<File> getLimitFiles(SMParam<File> param);

//    void modifyFileInfo(String category, int categoryId, int id);

    void updateFile(File pictures);
    
}
