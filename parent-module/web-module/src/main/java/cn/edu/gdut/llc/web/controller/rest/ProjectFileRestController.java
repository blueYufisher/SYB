package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.mybatis.model.ProjFile;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.ProjectFileService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-03-21 20:28
 **/
@RestController
public class ProjectFileRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("projectFileServiceImpl")
    private ProjectFileService projectFileService;

    @RequestMapping("/selectProjectIdByFileId")
    public ResponseMessage selectProjectIdByFileId(@RequestParam("fileId") Integer file_id) {
        /**
         * describe: 根据file_id查找proj_id
         * class_name: selectInfoIdByFileId
         * param: [file_id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:22
         **/
        logger.debug("selectProjectIdByFileId id:" + file_id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = projectFileService.selectProjectIdByFileId(file_id);
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

    @RequestMapping(value = "/insertFileIdReturnProjectID", method = RequestMethod.POST)
    public ResponseMessage insertFileIdReturnProjectID(@RequestBody ProjFile projFile) {
        /**
         * describe: 插入file_id数据返回info_file_id
         * class_name: insertFileIdReturnID
         * param: [infofile]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:23
         **/
        logger.debug("insertFileIdReturnProjectID");
        ResponseMessage message = new ResponseMessage();
        try {
            int id = projectFileService.insertFileIdReturnID(projFile);
            message.setStatus(true);
            message.setData(id);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/updateProjectFileByProjectId", method = RequestMethod.POST)
    public ResponseMessage updateProjectFileByProjectId(@RequestBody ProjFile projFile) {
        /**
         * describe: 更新project_id
         * class_name: updateInfoId
         * param: [infofile]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/11/0011
         * creat_time: 19:23
         **/
        logger.debug("updateProjectFileByProjectId");
        ResponseMessage message = new ResponseMessage();
        try {
            projectFileService.updateProjectId(projFile);
            message.setStatus(true);
//            message.setData();
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

}
