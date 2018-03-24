package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.File;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.FileService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-15 11:23
 **/
@RestController
public class FileRestController {

    @AutoLogger
    private static Logger logger;
    
    @Autowired
    @Qualifier("fileServiceImpl")
    private FileService fileService;

    /**
     * 根据id获取File
     *
     * @param id
     * @return File
     */
    @RequestMapping("/selectFileById")
    public ResponseMessage selectFileById(@RequestParam("id") Integer id) {
        logger.debug("selectFileById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = fileService.getFileById(id);
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
     * 获取图片的数量
     */
    @RequestMapping("/getFileNum")
    public ResponseMessage getFileNum() {
        logger.debug("getFileNum:");
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = fileService.getFileNum();
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
     * 删除图片
     *
     * @param id
     * @return
     */

    @RequestMapping("/deleteFile")
    public ResponseMessage deleteFile(@RequestParam("id") int id) {
        logger.debug("deleteFile:id=" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            fileService.deleteFile(id);
            message.setStatus(true);

        } catch (Exception e) {
            message.setMessage(e.toString());
            e.printStackTrace();
            message.setStatus(false);
        }

        return message;

    }

    /**
     * 修改File
     *
     * @param file
     * @param name
     * @param id
     * @return
     */
    @RequestMapping(value = "modifyFile", method = RequestMethod.POST)
    public ResponseMessage modifyFile(@RequestParam("upfile") MultipartFile file,
                                     @RequestParam("title") String title,
                                     @RequestParam("id") int id) {
        logger.debug("modifyFile:file=" + file + "title=" + title + "id=" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            fileService.modifyFile(file, title, id);
            message.setStatus(true);
        } catch (Exception e) {
            message.setMessage(e.toString());
            message.setStatus(false);
            e.printStackTrace();
        }
        return message;

    }

    @RequestMapping(value = "/updateFile", method = RequestMethod.POST)
    public ResponseMessage updateFile(@RequestBody File file) {
        logger.debug("updateFile");
        ResponseMessage message = new ResponseMessage();
        try {
            if (file.getFileId() == null)
                throw new RuntimeException();
            fileService.updateFile(file);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            message.setErrorCode(ErrorCode.DataBaseAccessError);
        }
        return message;

    }


    @RequestMapping("/getLimitFiles")
    public ResponseMessage getLimitFiles(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        logger.debug("getLimitFiles:currentPage=" + currentPage + ",pageSize=" + pageSize);
        ResponseMessage message = new ResponseMessage();
        CSparam<File> param = new CSparam<File>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);

        try {
            SCresponse<File> response = fileService.getLimitFiles(param) ;

            message.setData(response);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;
    }

//    /**
//     * 根据项目编号查File
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping("/selectByCategoryId")
//    public ResponseMessage selectByCategoryId(@RequestParam("categoryId") int id) {
//        logger.debug("selectByCategoryId: id=" + id);
//        ResponseMessage message = new ResponseMessage();
//        try {
//            List<File> pictureLocation = picturesService.selectByCategoryId(id);
//            message.setData(pictureLocation);
//            message.setStatus(true);
//        } catch (Exception e) {
//            message.setStatus(false);
//            message.setMessage(e.toString());
//            e.printStackTrace();
//        }
//        return message;
//    }
}
