package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Alumnus;
import cn.edu.gdut.llc.mybatis.model.self.SelfAlumnus;
import cn.edu.gdut.llc.share.dao.AlumnusDao;
import cn.edu.gdut.llc.share.dao.PicturesDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.AlumnusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnusServiceImpl implements AlumnusService {
    @Autowired
    @Qualifier("alumnusDaoImpl")
    private AlumnusDao alumnusDao;

    @Autowired
    @Qualifier("picturesDaoImpl")
    private PicturesDao picturesDao;

    /**
     * 根据id获取Alumnus
     *
     * @param id
     * @return Alumnus
     */
    @Override
    public Alumnus getAlumnusById(Integer id) {
        return alumnusDao.getAlumnusById(id);

    }

    /**
     * 获取按时间排序的前num个Alumnus
     *
     * @param num
     * @return
     */
    @Override
    public List<Alumnus> getAlumnusByNum(int num) {
        return alumnusDao.getAlumnusByNum(num);
    }

    /**
     * 获取Alumnus并且分页
     *
     * @param CSparam<Alumnus> param
     * @return List<Alumnus>
     */
    @Override
    public SCresponse<SelfAlumnus> getLimitAlumnus(CSparam<Alumnus> pm) {
        //查询结果数据集
        SMParam<Alumnus> param = new SMParam<Alumnus>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<Alumnus> resultList = alumnusDao.getLimitAlumnus(param);

        List<SelfAlumnus> selfAlumnusList = new ArrayList<SelfAlumnus>();
        for (Alumnus al : resultList) {
            SelfAlumnus selfAlumnus = new SelfAlumnus();
            int pic_id = al.getCoverPic();
            String pic_url = picturesDao.getPicturesById(pic_id).getPicUrl();
            selfAlumnus.setId(al.getId());
            selfAlumnus.setTitle(al.getTitle());
            selfAlumnus.setPicUrl(pic_url);
            selfAlumnus.setContent(al.getContent());
            selfAlumnus.setUrl(al.getUrl());
            selfAlumnus.setKeyword(al.getKeyword());
            selfAlumnus.setOrigin(al.getOrigin());
            selfAlumnus.setNote(al.getNote());
            selfAlumnus.setReleaseTime(al.getReleaseTime());
            selfAlumnus.setUpdateTime(al.getUpdateTime());
            selfAlumnus.setVisit(al.getVisit());
            selfAlumnus.setFile(al.getFile());
            selfAlumnusList.add(selfAlumnus);
        }

        //查询总记录数
        Alumnus a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = alumnusDao.getTotalRecord(pm.getParamObj());


//        SCresponse<Alumnus> response = new SCresponse<Alumnus>();
        SCresponse<SelfAlumnus> response = new SCresponse<SelfAlumnus>();
        response.setResultList(selfAlumnusList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }

    /**
     * 获取数据库当汇总的Alumnus的总的条数
     *
     * @param Alumnus对象paramObj
     * @return int总数量
     */
    @Override
    public int getTotalRecord(Alumnus paramObj) {
        return 0;
    }

    /**
     * 根据id删除Alumnus
     *
     * @param id
     */
    @Override
    public void deleteAlumnus(int id) {
    }

    /**
     * 添加Alumnus
     *
     * @param act
     */
    @Override
    public void addAlumnus(Alumnus act) {
    }

    /**
     * 修改Alumnus
     *
     * @param act
     */
    @Override
    public void modifyAlumnus(Alumnus act) {
    }
}
