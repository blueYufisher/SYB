package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.Type;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-06 17:05
 **/
public interface TypeDao {
    Type getTypeById(Integer id);
}
