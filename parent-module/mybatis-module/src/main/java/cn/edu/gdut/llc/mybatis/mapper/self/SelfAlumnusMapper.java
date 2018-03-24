package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Alumnus;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

public interface SelfAlumnusMapper {

    /**
     *获取按时间排序的前num个Alumnus
     * @param num
     * @return
     */
    List<Alumnus> findAlumnusByNum(int num);

    /**
     *获取Alumnus并且分页
     * @param param
     * @return
     */
    List<Alumnus> findLimitAlumnus(SMParam<Alumnus> param);
}
