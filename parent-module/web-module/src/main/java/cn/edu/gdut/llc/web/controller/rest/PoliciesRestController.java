package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.Policies;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.PoliciesService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
public class PoliciesRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("policiesServiceImpl")
    private PoliciesService policiesService;

    /**
     * 根据id获取Policies
     * @param id
     * @return
     */
    @RequestMapping("/selectPolicyById")
    public ResponseMessage selectPolicyById(@RequestParam("id") Integer id) {
        logger.debug("selectPolicyById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = policiesService.getPoliciesById(id);
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
     * 获取按时间排序的前num个Policies
     * @param num
     * @return
     */
    @RequestMapping("/selectPoliciesByNum")
    public ResponseMessage selectPoliciesByNum(@RequestParam("num") Integer num) {
        logger.debug("selectPoliciesByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = policiesService.getPoliciesByNum(num);
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
     * 获取Policies并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitPoliciesByCurrentPageAndPageSize")
    public ResponseMessage getLimitPolicies(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) Policies paramObj) {
        logger.debug("getLimitPolicies currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<Policies> param = new CSparam<Policies>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = policiesService.getLimiPolicies(param);
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
