package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.Knowledges;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.KnowledgesService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHAN
 */
@RestController
public class KnowledgesRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("knowledgesServiceImpl")
    private KnowledgesService knowledgesService;

    /** 根据id获取Knowledges
     * @param id
     * @return Knowledges
     */
    @RequestMapping("/selectKnowledgeById")
    public ResponseMessage selectKnowledgeById(@RequestParam("id") Integer id) {
        logger.debug("selectKnowledgeById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = knowledgesService.getKnowledgesById(id);
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
     * 获取按时间排序的前num个Knowledges
     * @param num
     * @return
     */
    @RequestMapping("/selectKnowledgesByNum")
    public ResponseMessage selectKnowledgesByNum(@RequestParam("num") Integer num) {
        logger.debug("selectKnowledgesByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = knowledgesService.getKnowledgesByNum(num);
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
     * 获取Knowledges并且分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitKnowledgesByCurrentPageAndPageSize")
    public ResponseMessage getLimitKnowledges(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) Knowledges paramObj) {
        logger.debug("getLimitKnowledges currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<Knowledges> param = new CSparam<Knowledges>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = knowledgesService.getLimitKnowledges(param);

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
