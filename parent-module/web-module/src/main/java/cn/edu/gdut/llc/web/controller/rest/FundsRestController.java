package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.Funds;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.FundsService;
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
 * @create 2017-12-10 14:35
 **/
@RestController
public class FundsRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("fundsServiceImpl")
    private FundsService fundsService;


    /** 根据id获取Funds
     * @param id
     * @return Funds
     */
    @RequestMapping("/selectFundById")
    public ResponseMessage selectFundById(@RequestParam("id") Integer id) {
        logger.debug("selectFundById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = fundsService.getFundsById(id);
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
     * 获取按时间排序的前num个Funds
     * @param num
     * @return
     */
    @RequestMapping("/selectFundsByNum")
    public ResponseMessage selectFundsByNum(@RequestParam("num") Integer num) {
        logger.debug("selectFundsByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = fundsService.getFundsByNum(num);
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
     * 获取Funds并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitFundsByCurrentPageAndPageSize")
    public ResponseMessage getLimitFunds(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) Funds paramObj) {
        logger.debug("getLimitFunds currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<Funds> param = new CSparam<Funds>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = fundsService.getLimitFunds(param);

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
