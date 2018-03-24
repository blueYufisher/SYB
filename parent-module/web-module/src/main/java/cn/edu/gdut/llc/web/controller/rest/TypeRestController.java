package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.TypeService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-12 14:54
 **/
@RestController
public class TypeRestController {
    @AutoLogger
    private static Logger logger;

    @Autowired
    @Qualifier("typeServiceImpl")
    private TypeService typeService;

    @RequestMapping("/selectTypeById")
    public ResponseMessage selectTypeById(@RequestParam("id") Integer id) {
        /**
         * describe: 根据type_id找type
         * class_name: selectTypeById
         * param: [id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/12/0012
         * creat_time: 14:56
         **/
        logger.debug("selectTypeById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = typeService.getTypeById(id);
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
