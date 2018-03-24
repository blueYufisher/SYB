package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.mybatis.model.ProjPic;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.ProjectPictureService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-11 19:20
 **/
@RestController
public class ProjectPictureRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("projectPictureServiceImpl")
    private ProjectPictureService projectPictureService;

    @RequestMapping("/selectProjectIdByPictureId")
    public ResponseMessage selectProjectIdByPictureId(@RequestParam("picId") Integer pic_id) {
        /**
         * describe: 根据pic_id查找proj_id
         * class_name: selectInfoIdByPictureId
         * param: [pic_id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:22
         **/
        logger.debug("selectProjectIdByPictureId id:" + pic_id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectPictureService.selectProjectIdByPictureId(pic_id);
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

    @RequestMapping(value = "/insertPictureIdReturnProjectID", method = RequestMethod.POST)
    public ResponseMessage insertPictureIdReturnProjectID(@RequestBody ProjPic projPic) {
        /**
         * describe: 插入pic_id数据返回info_pic_id
         * class_name: insertPictureIdReturnID
         * param: [infopic]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:23
         **/
        logger.debug("insertPictureIdReturnProjectID");
        ResponseMessage message = new ResponseMessage();
        try {
            int id = projectPictureService.insertPictureIdReturnID(projPic);
            message.setStatus(true);
            message.setData(id);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/updateProjectId", method = RequestMethod.POST)
    public ResponseMessage updateProjectId(@RequestBody ProjPic projPic) {
        /**
         * describe: 更新project_id
         * class_name: updateInfoId
         * param: [infopic]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:23
         **/
        logger.debug("updateProjectId");
        ResponseMessage message = new ResponseMessage();
        try {
            projectPictureService.updateProjectId(projPic);
            message.setStatus(true);
//            message.setData();
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

}
