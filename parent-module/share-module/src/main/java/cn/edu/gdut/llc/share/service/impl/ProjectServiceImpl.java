package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Project;
import cn.edu.gdut.llc.mybatis.model.self.SelfProject;
import cn.edu.gdut.llc.share.dao.PicturesDao;
import cn.edu.gdut.llc.share.dao.ProjectDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:28
 **/
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    @Qualifier("projectDaoImpl")
    private ProjectDao projectDao;

    @Autowired
    @Qualifier("picturesDaoImpl")
    private PicturesDao picturesDao;

    @Override
    public SelfProject getProjectById(Integer id) {
        /**
         * describe: 根据id获取Project
         * class_name: getProjectById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Project
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:24
         **/
        Project project = projectDao.getProjectById(id);
        SelfProject selfProject = new SelfProject();
        String pic_id = String.valueOf(project.getLogo());
        int picId = 0;
        if (!pic_id.equals("null")) {
            picId = Integer.parseInt(pic_id);
            String pic_url = picturesDao.getPicturesById(picId).getPicUrl();
            selfProject.setPicUrl(pic_url);
        }
        selfProject.setId(project.getId());
        selfProject.setField(project.getField());
        selfProject.setProjName(project.getProjName());
        selfProject.setProjHead(project.getProjHead());
        selfProject.setProjType(project.getProjType());
        selfProject.setPhone(project.getPhone());
        selfProject.setEnterTime(project.getEnterTime());
        selfProject.setProtocol(project.getProtocol());
        selfProject.setCompanyName(project.getCompanyName());
        selfProject.setRegisterTime(project.getRegisterTime());
        selfProject.setRegisterMoney(project.getRegisterMoney());
        selfProject.setRegisterField(project.getRegisterField());
        selfProject.setOperTime(project.getOperTime());
        selfProject.setUpdateTime(project.getUpdateTime());
        selfProject.setStatus(project.getStatus());
        selfProject.setNote(project.getNote());
        selfProject.setContent(project.getContent());
        selfProject.setVisit(project.getVisit());
        selfProject.setProjUrl(project.getProjUrl());
        selfProject.setLogo(project.getLogo());
        return selfProject;
    }

    @Override
    public SCresponse<Project> getProjectByIdReturnPreNextProj(Integer id) {
        /**
         * describe: 根据id获取Project获取上下Project
         * class_name: getProjectByIdReturnPreNextProj
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Project
         * creat_user: ZHAN
         * creat_date: 2018/1/10/0010
         * creat_time: 19:54
         **/
        Project _project = new Project();
        CSparam<Project> pm = new CSparam<Project>();
        SMParam<Project> param = new SMParam<Project>();
        _project.setId(id);
        pm.setParamObj(_project);
        param.setParamObj(pm.getParamObj());

        SCresponse<Project> response = new SCresponse<Project>();
        response.setPreText(projectDao.findPreProjectById(param));
        response.setNextText(projectDao.findNextProjectById(param));
        Project project = projectDao.getProjectById(id);
        List<Project> projectList = new ArrayList<Project>();
        projectList.add(project);
        response.setResultList(projectList);

        return response;
    }

    @Override
    public List<SelfProject> getProjectByNum(int num) {
        /**
         * describe: 获取按时间排序的前num个Project
         * class_name: getProjectByNum
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:26
         **/
        List<SelfProject> resultList = projectDao.getProjectByNum(num);

        for (SelfProject project : resultList) {
            String picUrl = project.getPicList().get(0).getPicUrl();
            project.setPicUrl(picUrl);
        }
        return resultList;
    }

    @Override
    public List<SelfProject> findProjectNumByVisit(int num) {
        /**
         * describe: 获取按visit排序的前num个Project
         * class_name: findProjectNumByVisit
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 9:56
         **/
        return projectDao.findProjectNumByVisit(num);
    }

    @Override
    public SCresponse<SelfProject> getLimitProject(CSparam<SelfProject> pm) {
        /**
         * describe: TODO
         * class_name: getLimitProject
         * param: [param]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:32
         **/
        //查询结果数据集
        SMParam<SelfProject> param = new SMParam<SelfProject>();
        int startNum = (pm.getCurrentPage() - 1) * pm.getPageSize();
        param.setPageSize(pm.getPageSize());
        param.setStartNum(startNum);
        param.setParamObj(pm.getParamObj());
        List<SelfProject> resultList = projectDao.getLimitProject(param);

        for (SelfProject project : resultList) {
           String picUrl = project.getPicList().get(0).getPicUrl();
           project.setPicUrl(picUrl);
        }

        //查询总记录数
        SelfProject a = pm.getParamObj();
        int totalRecord = 0;

        totalRecord = projectDao.getTotalRecord2(pm.getParamObj());


//        SCresponse<Project> response = new SCresponse<Project>();
        SCresponse<SelfProject> response = new SCresponse<SelfProject>();
        response.setResultList(resultList);

        //计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        response.setTotalRecord(totalRecord);

        return response;

    }

    @Override
    public int getTotalRecord(Project paramObj) {
        /**
         * describe: 获取数据库当汇总的Project的总的条数
         * class_name: getTotalRecord
         * param: [paramObj]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:28
         **/
        return 0;
    }

    @Override
    public void deleteProject(int id) {
        /**
         * describe: 根据id删除Project
         * class_name: deleteProject
         * param: [id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/6/0006
         * creat_time: 21:36
         **/
        projectDao.deleteProject(id);

    }

    @Override
    public int addProject(Project project) {
        /**
         * describe: 添加Project
         * class_name: addProject
         * param: [act]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/6/0006
         * creat_time: 21:36
         **/
        int id = projectDao.addProject(project);
//        String category = "4";
//        int categoryId = id;
//        int picId = project.getLogo();
//        picturesDao.modifyPictureInfo(category, categoryId, picId);
        return id;
    }

    @Override
    public void modifyProject(Project act) {
        /**
         * describe: 修改Project
         * class_name: modifyProject
         * param: [act]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/6/0006
         * creat_time: 21:38
         **/
        projectDao.modifyProject(act);
//        int id = act.getId();
//        String category = "4";
//        int categoryId = id;
//        int picId = act.getLogo();
//        picturesDao.modifyPictureInfo(category, categoryId, picId);
    }

    @Override
    public SCresponse<SelfProject> searchProjectByProjNameOrCompanyName(CSparam<Project> pm) {
        SMParam<Project> projectSMParam = new SMParam<Project>();
        projectSMParam.setPageSize(pm.getPageSize());
        projectSMParam.setStartNum((pm.getCurrentPage() - 1) * pm.getPageSize());
        projectSMParam.setParamObj(pm.getParamObj());
        List<Project> resultList = projectDao.searchProjectByProjNameOrCompanyName(projectSMParam);

        List<SelfProject> selfProjectList = new ArrayList<SelfProject>();
        for (Project project : resultList) {
            SelfProject selfProject = new SelfProject();
            String pic_id = String.valueOf(project.getLogo());
            int picId = 0;
            if (!pic_id.equals("null")) {
                picId = Integer.parseInt(pic_id);
                String pic_url = picturesDao.getPicturesById(picId).getPicUrl();
                selfProject.setPicUrl(pic_url);
            }
            selfProject.setId(project.getId());
            selfProject.setField(project.getField());
            selfProject.setProjName(project.getProjName());
            selfProject.setProjType(project.getProjType());
            selfProject.setProjHead(project.getProjHead());
            selfProject.setPhone(project.getPhone());
            selfProject.setEnterTime(project.getEnterTime());
            selfProject.setProtocol(project.getProtocol());
            selfProject.setCompanyName(project.getCompanyName());
            selfProject.setRegisterTime(project.getRegisterTime());
            selfProject.setRegisterMoney(project.getRegisterMoney());
            selfProject.setRegisterField(project.getRegisterField());
            selfProject.setOperTime(project.getOperTime());
            selfProject.setUpdateTime(project.getUpdateTime());
            selfProject.setStatus(project.getStatus());
            selfProject.setNote(project.getNote());
            selfProject.setVisit(project.getVisit());
            selfProject.setProjUrl(project.getProjUrl());
            selfProject.setLogo(project.getLogo());
            selfProjectList.add(selfProject);
        }


        // 查询总记录数
        int totalRecord = projectDao.conutProjectByProjNameOrCompanyName(projectSMParam);

        // 查询满足条件的所有记录
        SCresponse<SelfProject> response = new SCresponse<SelfProject>();
        response.setTotalRecord(totalRecord);
        response.setResultList(selfProjectList);
        // 计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }


    @Override
    public int modifyVisit(Integer id) {
        /**
         * describe: 根据info_id修改访问量
         * class_name: modifyVisit
         * param: [id]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/14/0014
         * creat_time: 22:30
         **/
        return projectDao.modifyVisit(id);
    }
}
