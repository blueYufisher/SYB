package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Tutor;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:22
 **/
public interface TutorDao {
    /** 根据id获取Tutor
     * @param id
     * @return Tutor
     */
    Tutor getTutorById(Integer id);

    /**
     * 获取按时间排序的前num个Tutor
     * @param num
     * @return
     */
    List<Tutor> getTutorByNum(int num);

    /**
     * 获取Tutor并且分页
     * @param SMParam<Tutor> param
     * @return List<Tutor>
     */
    List<Tutor> getLimitTutor(SMParam<Tutor> param);

    /**
     * 获取数据库当汇总的Tutor的总的条数
     * @param Tutor对象paramObj
     * @return int总数量
     */
    int getTotalRecord(Tutor paramObj);

    /**根据id删除Tutor
     * @param id
     */
    void deleteTutor(int id);

    /**添加Tutor
     * @param act
     */
    void addTutor(Tutor act);

    /**修改Tutor
     * @param act
     */
    void modifyTutor(Tutor act);
}
