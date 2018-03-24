package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.LoggerInfos;
import cn.edu.gdut.llc.share.dao.LoggerInfosDao;
import cn.edu.gdut.llc.share.service.LoggerInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-14 21:31
 **/
@Service
public class LoggerInfosServiceImpl implements LoggerInfosService {

    @Autowired
    @Qualifier("loggerInfosDaoImpl")
    private LoggerInfosDao loggerInfosDao;

    @Override
    public void saveLoggerInfos(LoggerInfos loggerInfos) {
        loggerInfosDao.saveLoggerInfos(loggerInfos);
    }
}
