/**
 *
 */
package cn.edu.gdut.llc.share.dao;

import java.util.List;

import cn.edu.gdut.llc.mybatis.model.Alumnus;
import cn.edu.gdut.llc.share.mesaage.SMParam;


/**
 * @author ZHAN
 *
 */
public interface AlumnusDao {
    /** 根据id获取Alumnus
     * @param id
     * @return Alumnus
     */
    Alumnus getAlumnusById(Integer id);

    /**
     * 获取按时间排序的前num个Alumnus
     * @param num
     * @return
     */
    List<Alumnus> getAlumnusByNum(int num);

    /**
     * 获取Alumnus并且分页
     * @param SMParam<Alumnus> param
     * @return List<Alumnus>
     */
    List<Alumnus> getLimitAlumnus(SMParam<Alumnus> param);

    /**
     * 获取数据库当汇总的Alumnus的总的条数
     * @param Alumnus对象paramObj
     * @return int总数量
     */
    int getTotalRecord(Alumnus paramObj);

    /**根据id删除Alumnus
     * @param id
     */
    void deleteAlumnus(int id);

    /**添加Alumnus
     * @param act
     */
    void addAlumnus(Alumnus act);

    /**修改Alumnus
     * @param act
     */
    void modifyAlumnus(Alumnus act);
}
