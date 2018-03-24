package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.News;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.NewsService;
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
 * @create 2017-12-09 10:51
 **/
@RestController
public class NewsRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("newsServiceImpl")
    private NewsService newsService;


    /** 根据id获取News
     * @param id
     * @return News
     */
    @RequestMapping("/selectNewById")
    public ResponseMessage selectNewById(@RequestParam("id") Integer id) {
        logger.debug("selectNewById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = newsService.getNewsById(id);
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
     * 获取按时间排序的前num个News
     * @param num
     * @return
     */
    @RequestMapping("/selectNewsByNum")
    public ResponseMessage selectNewsByNum(@RequestParam("num") Integer num) {
        logger.debug("selectNewsByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = newsService.getNewsByNum(num);
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
     * 获取News并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitNewsByCurrentPageAndPageSize")
    public ResponseMessage getLimitNews(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) News paramObj) {
        logger.debug("getLimitNews currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<News> param = new CSparam<News>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = newsService.getLimitNews(param);

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
