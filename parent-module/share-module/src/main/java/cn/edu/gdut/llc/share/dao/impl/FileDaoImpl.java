package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.FileMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfFileMapper;
import cn.edu.gdut.llc.mybatis.model.File;
import cn.edu.gdut.llc.mybatis.model.FileExample;
import cn.edu.gdut.llc.share.dao.FileDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-15 10:56
 **/
@Repository
public class FileDaoImpl implements FileDao{

    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private SelfFileMapper selfFileMapper;

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
        return fileMapper.selectByPrimaryKey(id);
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
        FileExample example = new FileExample();
        example.createCriteria().andFileTitleEqualTo(title);

        return fileMapper.selectByExample(example).get(0);
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
        FileExample example = new FileExample();
        example.createCriteria().andFileMd5EqualTo(md5);
        return fileMapper.selectByExample(example);
    }

//    @Override
//    public List<File> selectByCategoryId(int id) {
//        FileExample example = new FileExample();
//        example.createCriteria().andCategoryIdEqualTo(id);
//        return picturesMapper.selectByExample(example);
//    }

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
        selfFileMapper.insertFilesReturnID(record);
        return record.getFileId();
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
        FileExample example = new FileExample();
        return fileMapper.countByExample(example);
    }

    @Override
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
        fileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void modifyFile(File pictures) {
        /**
         * describe: 修改File信息
         * class_name: modifyFile
         * param: [pictures]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:01
         **/
        fileMapper.updateByPrimaryKey(pictures);
    }

    @Override
    public List<File> getLimitFiles(SMParam<File> param) {
        /**
         * describe: 分页查找File
         * class_name: getLimitFiles
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.File>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:02
         **/
        return selfFileMapper.findLimtFiles(param);
    }

//    @Override
//    public void modifyFileInfo(String category, int categoryId, int id) {
//
//    }

    @Override
    public void updateFile(File pictures) {
        fileMapper.updateByPrimaryKey(pictures);
    }
}
