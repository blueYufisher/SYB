package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Project;
import cn.edu.gdut.llc.mybatis.model.self.SelfProject;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:28
 **/
public interface ProjectService {
    /** 根据id获取Project
     * @param id
     * @return Project
     */
    SelfProject getProjectById(Integer id);

    SCresponse<Project> getProjectByIdReturnPreNextProj(Integer id);

    /**
     * 获取按时间排序的前num个Project
     * @param num
     * @return
     */
    List<SelfProject> getProjectByNum(int num);

    /**
     * 获取按visit排序的前num个Project
     * @param num
     * @return
     */
    List<SelfProject> findProjectNumByVisit(int num);

    /**
     * 获取Project并且分页
     * @param param
     * @return
     */
    SCresponse<SelfProject> getLimitProject(CSparam<SelfProject> param);

    /**
     * 获取数据库当汇总的Project的总的条数
     * @param Project对象paramObj
     * @return int总数量
     */
    int getTotalRecord(Project paramObj);

    /**
     * describe: 根据id删除Project
     * class_name: deleteProject
     * param: [id]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/6/0006
     * creat_time: 21:36
     **/
    void deleteProject(int id);

    /**
     * describe: 添加Project
     * class_name: addProject
     * param: [act]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/6/0006
     * creat_time: 21:36
     **/
    int addProject(Project act);

    /**
     * describe: 修改Project
     * class_name: modifyProject
     * param: [act]
     * return: void
     * creat_user: ZHAN
     * creat_date: 2018/1/6/0006
     * creat_time: 21:38
     **/
    void modifyProject(Project act);

    /**
     * describe: 根据ProjName或者CompanyName模糊搜索
     * class_name: searchProjectByProjNameOrCompanyName
     * param: [msg]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Project>
     * creat_user: ZHAN
     * creat_date: 2018/1/10/0010
     * creat_time: 17:07
     **/
    SCresponse<SelfProject> searchProjectByProjNameOrCompanyName(CSparam<Project> param);

    /**
     * describe: 根据project_id修改访问量
     * class_name: modifyVisit
     * param: [id]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/1/14/0014
     * creat_time: 22:30
     **/
    int modifyVisit(Integer id);

}
