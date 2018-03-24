package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.Alumnus;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.AlumnusService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnusRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("alumnusServiceImpl")
    private AlumnusService alumnusService;


    /** 根据id获取Alumnus
     * @param id
     * @return Alumnus
     */
    @RequestMapping("/selectAlumniById")
    public ResponseMessage selectAlumniById(@RequestParam("id") Integer id) {
        logger.debug("selectAlumniById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = alumnusService.getAlumnusById(id);
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
     * 获取按时间排序的前num个Alumnus
     * @param num
     * @return
     */
    @RequestMapping("/selectAlumnusByNum")
    public ResponseMessage selectAlumnusByNum(@RequestParam("num") Integer num) {
        logger.debug("selectAlumnusByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = alumnusService.getAlumnusByNum(num);
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
     * 获取Alumnus并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitAlumnusByCurrentPageAndPageSize")
    public ResponseMessage getLimitAlumnus(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) Alumnus paramObj) {
        logger.debug("getLimitAlumnus currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<Alumnus> param = new CSparam<Alumnus>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = alumnusService.getLimitAlumnus(param);

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
