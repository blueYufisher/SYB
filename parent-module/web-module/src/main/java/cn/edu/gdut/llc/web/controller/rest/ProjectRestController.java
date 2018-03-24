package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Project;
import cn.edu.gdut.llc.mybatis.model.self.SelfProject;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.ProjectService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import cn.edu.gdut.llc.share.util.LoggerUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:31
 **/
@RestController
public class ProjectRestController {


    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;


    /**
     * 根据id获取Project
     *
     * @param id
     * @return Project
     */
    @RequestMapping("/selectProjectById")
    public ResponseMessage selectProjectById(HttpServletRequest request, @RequestParam("id") Integer id) {
        logger.debug("selectProjectById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectService.getProjectById(id);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping("/getProjectByIdReturnPreNextProj")
    public ResponseMessage getProjectByIdReturnPreNextProj(HttpServletRequest request, @RequestParam("id") Integer id) {
        logger.debug("getProjectByIdReturnPreNextProj id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectService.getProjectByIdReturnPreNextProj(id);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    /**
     * 获取按时间排序的前num个Project
     *
     * @param num
     * @return
     */
    @RequestMapping("/selectProjectsByNum")
    public ResponseMessage selectProjectsByNum(HttpServletRequest request, @RequestParam("num") Integer num) {
        logger.debug("selectProjectsByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectService.getProjectByNum(num);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;

    }

    /**
     * 获取按visit排序的前num个Project
     *
     * @param num
     * @return
     */
    @RequestMapping("/findProjectNumByVisit")
    public ResponseMessage findProjectNumByVisit(HttpServletRequest request, @RequestParam("num") Integer num) {
        logger.debug("findProjectNumByVisit num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectService.findProjectNumByVisit(num);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;

    }

    /**
     * 获取Project并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitProjectsByCurrentPageAndPageSize")
    public ResponseMessage getLimitProject(HttpServletRequest request,
                                           @RequestParam("currentPage") int currentPage,
                                           @RequestParam("pageSize") int pageSize,
                                           @RequestBody(required = false) SelfProject paramObj) {
        logger.debug("getLimitProject currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<SelfProject> param = new CSparam<SelfProject>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectService.getLimitProject(param);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping("/searchProjectByProjNameOrCompanyName")
    public ResponseMessage searchProjectByProjNameOrCompanyName(HttpServletRequest request,
                                                                @RequestParam("currentPage") int currentPage,
                                                                @RequestParam("pageSize") int pageSize,
                                                                @RequestBody(required = false) Project paramObj) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: getInfosLimit
         * param: [type, currentPage, pageSize]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:23
         **/
        logger.debug("searchProjectByProjNameOrCompanyName currentPage:" + currentPage + "pageSize:" + pageSize + "Projects" + paramObj);
        // 创建参数对象
        CSparam<Project> cs = new CSparam<Project>();
        cs.setCurrentPage(currentPage);
        cs.setPageSize(pageSize);
        Project project = new Project();
        project.setProjName(paramObj.getProjName());
        project.setCompanyName(paramObj.getCompanyName());
        cs.setParamObj(project);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<SelfProject> res = projectService.searchProjectByProjNameOrCompanyName(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

    @RequestMapping("/deleteProject")
    public ResponseMessage deleteProject(HttpServletRequest request, @RequestParam("id") int id) {
        /**
         * describe: 根据id删除Project
         * class_name: deleteProject
         * param: [id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:23
         **/
        logger.debug("deleteProject");
        ResponseMessage message = new ResponseMessage();
        try {
            projectService.deleteProject(id);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            message.setErrorCode(ErrorCode.DataBaseAccessError);
        }
        return message;
    }


    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ResponseMessage addProject(HttpServletRequest request, @RequestBody Project project) {
        /**
         * describe: 添加Project
         * class_name: addProject
         * param: [p]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:25
         **/
        logger.debug("addProject");
        ResponseMessage message = new ResponseMessage();
        try {
            int id = projectService.addProject(project);
            JSONObject obj = new JSONObject();
            obj.put("id:", id);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setStatus(true);
            message.setData(id);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/modifyProject", method = RequestMethod.POST)
    public ResponseMessage modifyProject(HttpServletRequest request, @RequestBody Project project) {
        /**
         * describe: 修改Project
         * class_name: modifyProject
         * param: [p]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:26
         **/
        logger.debug("modifyProject");
        ResponseMessage message = new ResponseMessage();
        try {
            if (project.getId() == null)
                throw new RuntimeException();
            projectService.modifyProject(project);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            message.setErrorCode(ErrorCode.DataBaseAccessError);
        }
        return message;
    }

    @RequestMapping("/modifyProjectVisit")
    public ResponseMessage modifyProjectVisit(HttpServletRequest request, @RequestParam("id") Integer id) {
        /**
         * describe: 根据info_id修改访问量
         * class_name: modifyVisit
         * param: [request, id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/14/0014
         * creat_time: 22:31
         **/
        logger.debug("modifyProjectVisit id：" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            int data = projectService.modifyVisit(id);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

}
