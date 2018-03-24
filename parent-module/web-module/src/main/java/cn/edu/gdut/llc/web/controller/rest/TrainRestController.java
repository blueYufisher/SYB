package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.mybatis.model.Train;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.TrainService;
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
 * @create 2017-12-09 11:11
 **/
@RestController
public class TrainRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("trainServiceImpl")
    private TrainService trainService;


    /** 根据id获取Train
     * @param id
     * @return Train
     */
    @RequestMapping("/selectTrainById")
    public ResponseMessage selectTrainById(@RequestParam("id") Integer id) {
        logger.debug("selectTrainById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = trainService.getTrainById(id);
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
     * 获取按时间排序的前num个Train
     * @param num
     * @return
     */
    @RequestMapping("/selectTrainsByNum")
    public ResponseMessage selectTrainsByNum(@RequestParam("num") Integer num) {
        logger.debug("selectTrainsByNum num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = trainService.getTrainByNum(num);
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
     * 获取Train并进行分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param paramObj    需要设置的限制条件可有可无
     * @return ResponseMessage
     * 分页及模糊查询
     */
    @RequestMapping("/limitTrainsByCurrentPageAndPageSize")
    public ResponseMessage getLimitTrain(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestBody(required = false) Train paramObj) {
        logger.debug("getLimitTrain currentPage:" + currentPage + "pageSize:" + pageSize + "Paper" + paramObj);
        CSparam<Train> param = new CSparam<Train>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);
        param.setParamObj(paramObj);


        ResponseMessage message = new ResponseMessage();
        try {
            Object data = trainService.getLimitTrain(param);

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
