package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.Type;
import cn.edu.gdut.llc.share.dao.TypeDao;
import cn.edu.gdut.llc.share.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-12 14:51
 **/
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    @Qualifier("typeDaoImpl")
    private TypeDao typeDao;

    @Override
    public Type getTypeById(Integer id) {
        /**
         * describe: 根据type_id找type
         * class_name: getTypeById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Type
         * creat_user: ZHAN
         * creat_date: 2018/1/12/0012
         * creat_time: 14:52
         **/
        return typeDao.getTypeById(id);
    }
}
