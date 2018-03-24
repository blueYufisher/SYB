package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.LoggerInfosMapper;
import cn.edu.gdut.llc.mybatis.model.LoggerInfos;
import cn.edu.gdut.llc.share.dao.LoggerInfosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-14 20:41
 **/
@Repository
public class LoggerInfosDaoImpl implements LoggerInfosDao {

    @Autowired
    private LoggerInfosMapper loggerInfosMapper;

    @Override
    public void saveLoggerInfos(LoggerInfos loggerInfos) {
        loggerInfosMapper.insert(loggerInfos);
    }
}
