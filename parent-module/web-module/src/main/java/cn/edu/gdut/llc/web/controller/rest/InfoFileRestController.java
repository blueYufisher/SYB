package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.mybatis.model.InfoFile;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.InfoFileService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 20:16
 **/
@RestController
public class InfoFileRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("infoFileServiceImpl")
    private InfoFileService infoFileService;

    @RequestMapping("/selectInfoIdByFileId")
    public ResponseMessage selectInfoIdByFileId(@RequestParam("fileId") Integer file_id) {
        /**
         * describe: 根据file_id查找info_id
         * class_name: selectInfoIdByFileId
         * param: [file_id]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infofile>
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:25
         **/
        logger.debug("selectInfoIdByFileId id:" + file_id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = infoFileService.selectInfoIdByFileId(file_id);
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

    @RequestMapping(value = "/insertFileIdReturnInfoID", method = RequestMethod.POST)
    public ResponseMessage insertFileIdReturnInfoID(@RequestBody InfoFile infoFile) {
        /**
         * describe: 插入file_id数据返回info_file_id
         * class_name: insertFileIdRetuenID
         * param: [infofile]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        logger.debug("insertFileIdReturnInfoID");
        ResponseMessage message = new ResponseMessage();
        try {
            int id = infoFileService.insertFileIdReturnID(infoFile);
            message.setStatus(true);
            message.setData(id);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/updateInfoFileByInfoId", method = RequestMethod.POST)
    public ResponseMessage updateInfoFileByInfoId(@RequestBody InfoFile infoFile) {
        /**
         * describe: 插入file_id数据返回info_file_id
         * class_name: insertFileIdRetuenID
         * param: [infofile]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/9/0009
         * creat_time: 19:39
         **/
        logger.debug("updateInfoFileByInfoId");
        ResponseMessage message = new ResponseMessage();
        try {
            infoFileService.updateInfoId(infoFile);
            message.setStatus(true);
//            message.setData();
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

}
