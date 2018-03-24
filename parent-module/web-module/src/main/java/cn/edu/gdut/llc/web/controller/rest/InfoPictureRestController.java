package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.mybatis.model.Infopic;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.InfoPictureService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-09 19:45
 **/
@RestController
public class InfoPictureRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("infoPictureServiceImpl")
    private InfoPictureService infoPictureService;

    @RequestMapping("/selectInfoIdByPictureId")
    public ResponseMessage selectInfoIdByPictureId(@RequestParam("picId") Integer pic_id) {
        /**
         * describe: 根据pic_id查找info_id
         * class_name: selectInfoIdByPictureId
         * param: [pic_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infopic>
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:25
         **/
        logger.debug("selectInfoIdByPictureId id:" + pic_id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = infoPictureService.selectInfoIdByPictureId(pic_id);
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

    @RequestMapping(value = "/insertPictureIdReturnInfoID", method = RequestMethod.POST)
    public ResponseMessage insertPictureIdReturnInfoID(@RequestBody Infopic infopic) {
        /**
         * describe: 插入pic_id数据返回info_pic_id
         * class_name: insertPictureIdRetuenID
         * param: [infopic]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        logger.debug("insertPictureIdReturnInfoID");
        ResponseMessage message = new ResponseMessage();
        try {
            int id = infoPictureService.insertPictureIdRetuenID(infopic);
            message.setStatus(true);
            message.setData(id);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/updateInfoId", method = RequestMethod.POST)
    public ResponseMessage updateInfoId(@RequestBody Infopic infopic) {
        /**
         * describe: 插入pic_id数据返回info_pic_id
         * class_name: insertPictureIdRetuenID
         * param: [infopic]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        logger.debug("updateInfoId");
        ResponseMessage message = new ResponseMessage();
        try {
            infoPictureService.updateInfoId(infopic);
            message.setStatus(true);
//            message.setData();
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }
}
