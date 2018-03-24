package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.TypeMapper;
import cn.edu.gdut.llc.mybatis.model.Type;
import cn.edu.gdut.llc.share.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-06 17:06
 **/
@Repository
public class TypeDaoImpl implements TypeDao {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }
}
