package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.ProjectMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfProjectMapper;
import cn.edu.gdut.llc.mybatis.model.Project;
import cn.edu.gdut.llc.mybatis.model.ProjectExample;
import cn.edu.gdut.llc.mybatis.model.self.SelfProject;
import cn.edu.gdut.llc.share.dao.ProjectDao;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:25
 **/
@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private SelfProjectMapper selfProjectMapper;

    @Override
    public Project getProjectById(Integer id) {
        /**
         * describe: 根据id获取Project
         * class_name: getProjectById
         * param: [id]
         * return: cn.edu.gdut.llc.mybatis.model.Project
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:24
         **/
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public  List<SelfProject> getProjectByNum(int num) {
        /**
         * describe: 获取按时间排序的前num个Project
         * class_name: getProjectByNum
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:26
         **/
        List<SelfProject> list = selfProjectMapper.findProjectByNum(num);
        System.out.println(list);
        return list;
    }

    @Override
    public List<Project> findProjectNumByVisit(int num) {
        /**
         * describe: 获取按visit排序的前num个Project
         * class_name: findProjectNumByVisit
         * param: [num]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 9:55
         **/
        List<Project> list = selfProjectMapper.findProjectNumByVisit(num);
        System.out.println(list);
        return list;
    }

    @Override
    public List<SelfProject> getLimitProject(SMParam<SelfProject> param) {
        /**
         * describe: 获取Project并且分页
         * class_name: getLimitProject
         * param: [param]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:27
         **/
        List<SelfProject> list = selfProjectMapper.findLimitProject(param);
        System.out.println(list);
        return list;
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
        ProjectExample tutorExample = new ProjectExample();
        return projectMapper.countByExample(tutorExample);
    }
    @Override
    public int getTotalRecord2(SelfProject paramObj) {
        /**
         * describe: 获取数据库当汇总的Project的总的条数
         * class_name: getTotalRecord
         * param: [paramObj]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 10:28
         **/
        ProjectExample tutorExample = new ProjectExample();
        return projectMapper.countByExample(tutorExample);
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
        Project project = projectMapper.selectByPrimaryKey(id);
        if (project == null) {
            throw new RuntimeException("要删除的记录不存在");
        } else {
            projectMapper.deleteByPrimaryKey(id);
        }
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
        selfProjectMapper.insertProjectReturnID(project);
        String url = "detailTeam.html?id=" + project.getId();
        project.setProjUrl(url);
        if (project.getLogo() == null){
        	project.setLogo(119);
        }
        projectMapper.updateByPrimaryKeyWithBLOBs(project);

        return project.getId();
    }

    @Override
    public void modifyProject(Project project) {
        /**
         * describe: 修改Project
         * class_name: modifyProject
         * param: [act]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/6/0006
         * creat_time: 21:38
         **/
        if (projectMapper.selectByPrimaryKey(project.getId()) == null) {
            throw new RuntimeException("该id不存在！");
        }
        projectMapper.updateByPrimaryKeyWithBLOBs(project);
    }

    @Override
    public List<Project> findPreProjectById(SMParam<Project> msg) {
        /**
         * describe: 根据id和type找到上一条记录
         * class_name: findPreProjectById
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2018/1/10/0010
         * creat_time: 17:05
         **/
        return selfProjectMapper.findPreProjectById(msg);
    }

    @Override
    public List<Project> findNextProjectById(SMParam<Project> msg) {
        /**
         * describe: 根据id和type找到下一条记录
         * class_name: findNextProjectById
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2018/1/10/0010
         * creat_time: 17:07
         **/
        return selfProjectMapper.findNextProjectById(msg);
    }

    @Override
    public List<Project> searchProjectByProjNameOrCompanyName(SMParam<Project> msg) {
        /**
         * describe: 根据ProjName或者CompanyName模糊搜索
         * class_name: searchProjectByProjNameOrCompanyName
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
         * creat_user: ZHAN
         * creat_date: 2018/1/10/0010
         * creat_time: 17:07
         **/
        return selfProjectMapper.searchProjectByProjNameOrCompanyName(msg);
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
        Project project = projectMapper.selectByPrimaryKey(id);
        int visit = project.getVisit();
        visit++;
        project.setVisit(visit);
        projectMapper.updateByPrimaryKey(project);
        return visit;
    }

    @Override
    public int conutProjectByProjNameOrCompanyName(SMParam<Project> msg) {
        return selfProjectMapper.conutProjectByProjNameOrCompanyName(msg);
    }
}
