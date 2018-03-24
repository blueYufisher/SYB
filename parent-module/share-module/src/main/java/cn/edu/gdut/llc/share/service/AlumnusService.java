package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Alumnus;
import cn.edu.gdut.llc.mybatis.model.self.SelfAlumnus;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * @author ZHAN
 *
 */
public interface AlumnusService {
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
    SCresponse<SelfAlumnus> getLimitAlumnus(CSparam<Alumnus> param);

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
