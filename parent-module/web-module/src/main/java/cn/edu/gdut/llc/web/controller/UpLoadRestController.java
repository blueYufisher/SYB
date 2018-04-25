package cn.edu.gdut.llc.web.controller;


import cn.edu.gdut.llc.share.service.FileService;
import cn.edu.gdut.llc.share.service.PicturesService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.util.AutoLogger;


/**
 * @author wulei
 * 该类用于上传各类文档
 */
@RestController
//@Secured("ROLE_ADMIN")
//@RequestMapping("/admin")
public class UpLoadRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("picturesServiceImpl")
    private PicturesService picturesService;

    @Autowired
    @Qualifier("fileServiceImpl")
    private FileService fileService;


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseMessage upload(@RequestParam("upfile") MultipartFile file, @RequestParam("title") String title, @RequestParam("picLocation") String picLocation) {
        /**
         * describe:上传图片
         * class_name: upload
         * param: [file, title]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:32
         **/
        logger.debug("upload:file" + file + "title:" + title + "picLocation:" + picLocation);
        ResponseMessage message = new ResponseMessage();
        try {
            //response.sendRedirect("/upload2.html");
            int primaryKey = picturesService.uploadPicture(file, title, picLocation);
            Object data = picturesService.getPicturesById(primaryKey);
            message.setStatus(true);
            message.setData(data);
        } catch (Exception e) {
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;
    }

    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    public ResponseMessage uploadAvatar(@RequestParam("upfile") MultipartFile file, @RequestParam("title") String title, @RequestParam("picLocation") String picLocation) {
        /**
         * describe:上传图片
         * class_name: upload
         * param: [file, title]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/31/0031
         * creat_time: 14:32
         **/
        logger.debug("uploadAvatar:file" + file + "title:" + title + "picLocation:" + picLocation);
        ResponseMessage message = new ResponseMessage();
        try {
            //response.sendRedirect("/upload2.html");
            int primaryKey = picturesService.uploadAvatar(file, title, picLocation);
            Object data = picturesService.getPicturesById(primaryKey);
            message.setStatus(true);
            message.setData(data);
        } catch (Exception e) {
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseMessage uploadFile(@RequestParam("upfile") MultipartFile file, @RequestParam("title") String title) {
        /**
         * describe: 上传file
         * class_name: uploadFile
         * param: [file, title]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 11:22
         **/
        logger.debug("uploadFile:file" + file + "title:" + title);
        ResponseMessage message = new ResponseMessage();
        try {
            //response.sendRedirect("/upload2.html");
            int primaryKey = fileService.uploadFile(file, title);
            Object data = fileService.getFileById(primaryKey);
            message.setStatus(true);
            message.setData(data);
        } catch (Exception e) {
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;
    }

}
