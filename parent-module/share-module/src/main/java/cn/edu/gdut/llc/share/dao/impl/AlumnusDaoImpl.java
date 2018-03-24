package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.AlumnusMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfAlumnusMapper;
import cn.edu.gdut.llc.mybatis.model.Alumnus;
import cn.edu.gdut.llc.mybatis.model.AlumnusExample;
import cn.edu.gdut.llc.share.dao.AlumnusDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author ZHAN
 */
@Repository
public class AlumnusDaoImpl implements AlumnusDao {

    @Autowired
    private AlumnusMapper alumnusMapper;

    @Autowired
    private SelfAlumnusMapper selfAlumnusMapper;

    /**
     * 根据id获取Alumnus
     *
     * @param id
     * @return Alumnus
     */
    @Override
    public Alumnus getAlumnusById(Integer id) {
        return alumnusMapper.selectByPrimaryKey(id);
    }


    /**
     * 获取按时间排序的前num个Alumnus
     *
     * @param num
     * @return
     */
    @Override
    public List<Alumnus> getAlumnusByNum(int num) {
        List<Alumnus> list = selfAlumnusMapper.findAlumnusByNum(num);
        System.out.println(list);
        return list;
    }

    /**
     * 获取Alumnus并且分页
     *
     * @param SMParam<Alumnus> param
     * @return List<Alumnus>
     */
    @Override
    public List<Alumnus> getLimitAlumnus(SMParam<Alumnus> param) {
        System.out.println("Dao");
        System.out.println();
        List<Alumnus> test = selfAlumnusMapper.findLimitAlumnus(param);
        System.out.println(test);
        return test;
    }

    /**
     * 获取数据库当汇总的Alumnus的总的条数
     *
     * @param Alumnus对象paramObj
     * @return int总数量
     */
    @Override
    public int getTotalRecord(Alumnus paramObj) {
        // TODO Auto-generated method stub
        AlumnusExample alumnusExample = new AlumnusExample();
        return alumnusMapper.countByExample(alumnusExample);
    }

    @Override
    public void deleteAlumnus(int id) {

    }

    @Override
    public void addAlumnus(Alumnus act) {

    }

    @Override
    public void modifyAlumnus(Alumnus act) {

    }
}
