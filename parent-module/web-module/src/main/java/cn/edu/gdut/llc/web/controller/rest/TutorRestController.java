package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.Tutor;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.TutorService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 10:33
 **/
@RestController
public class TutorRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("tutorServiceImpl")
    private TutorService tutorService;


    /** 根据id获取Tutor
     * @param id
     * @return Tutor
     */
    @RequestMapping("/selectTutorById")
    public ResponseMessage selectTutorById(@RequestParam("id") Integer id) {
        logger.debug("selectTutorById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = tutorService.getTutorById(id);
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
     * 获取按时间排序的前num个Tutor
     * @param num
     * @return
     */
    @RequestMapping("/selectTutorsByNum")
    public ResponseMessage selectTutorsByNum(@RequestParam("num") Integer num) {
        logger.debug("selectTutorsByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = tutorService.getTutorByNum(num);
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
     * 获取Tutor并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitTutorsByCurrentPageAndPageSize")
    public ResponseMessage getLimitTutor(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) Tutor paramObj) {
        logger.debug("getLimitTutor currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<Tutor> param = new CSparam<Tutor>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = tutorService.getLimitTutor(param);

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
