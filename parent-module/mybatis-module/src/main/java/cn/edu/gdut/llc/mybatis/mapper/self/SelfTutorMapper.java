package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Tutor;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:19
 **/
public interface SelfTutorMapper {
    /**
     *获取按时间排序的前num个Tutor
     * @param num
     * @return
     */
    List<Tutor> findTutorByNum(int num);

    /**
     *获取Tutor并且分页
     * @param param
     * @return
     */
    List<Tutor> findLimitTutor(SMParam<Tutor> param);
}
