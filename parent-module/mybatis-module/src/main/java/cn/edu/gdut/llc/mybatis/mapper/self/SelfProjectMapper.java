package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.Project;
import cn.edu.gdut.llc.mybatis.model.self.SelfProject;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:23
 **/
public interface SelfProjectMapper {
    /**
     *获取按时间排序的前num个Project
     * @param num
     * @return
     */
    List<SelfProject> findProjectByNum(int num);

    List<SelfProject> findProjectNumByVisit(int num);

    /**
     *获取Project并且分页
     * @param param
     * @return
     */
    List<SelfProject> findLimitProject(SMParam<SelfProject> param);

    /**
     * 添加Project返回id
     * @param project
     * @return
     */
    Integer insertProjectReturnID(Project project);

    /**
     * describe: 根据id和type找到上一条记录
     * class_name: findPreInfoById
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
     * creat_user: ZHAN
     * creat_date: 2017/12/14/0014
     * creat_time: 11:07
     **/
    List<Project> findPreProjectById(SMParam<Project> msg);

    /**
     * describe: 根据id和type找到下一条记录
     * class_name: findPreInfoById
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
     * creat_user: ZHAN
     * creat_date: 2017/12/14/0014
     * creat_time: 11:07
     **/
    List<Project> findNextProjectById(SMParam<Project> msg);

    /**
     * describe: 根据ProjName或者CompanyName模糊搜索
     * class_name: searchProjectByTitleOrNote
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
     * creat_user: ZHAN
     * creat_date: 2017/12/15/0015
     * creat_time: 10:43
     **/
    List<Project> searchProjectByProjNameOrCompanyName(SMParam<Project> msg);

    int conutProjectByProjNameOrCompanyName(SMParam<Project> msg);
}
