package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Pictures;
import cn.edu.gdut.llc.mybatis.model.self.SelfPictures;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.PicturesService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 14:30
 **/
@RestController
public class PicturesRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("picturesServiceImpl")
    private PicturesService picturesService;


    /**
     * 根据id获取Pictures
     *
     * @param id
     * @return Pictures
     */
    @RequestMapping("/selectPictureById")
    public ResponseMessage selectPictureById(@RequestParam("id") Integer id) {
        logger.debug("selectPictureById id:" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = picturesService.getPicturesById(id);
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
    @RequestMapping("/getPicNum")
    public ResponseMessage getPicNum() {
        logger.debug("getPicNum:");
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = picturesService.getPictureNum();
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

    @RequestMapping("/deletePic")
    public ResponseMessage deletePic(@RequestParam("id") int id) {
        logger.debug("deletePic:id=" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            picturesService.deletePicture(id);
            message.setStatus(true);

        } catch (Exception e) {
            message.setMessage(e.toString());
            e.printStackTrace();
            message.setStatus(false);
        }

        return message;

    }

    /**
     * 修改图片
     *
     * @param upfile
     * @param title
     * @param id
     * @return
     */
    @RequestMapping(value = "modifyPic", method = RequestMethod.POST)
    public ResponseMessage modifyPic(@RequestParam("upfile") MultipartFile file,
                                     @RequestParam("title") String title,
                                     @RequestParam("id") int id) {
        logger.debug("modifyPic:file=" + file + "title=" + title + "id=" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            picturesService.modifyPicture(file, title, id);
            message.setStatus(true);
        } catch (Exception e) {
            message.setMessage(e.toString());
            message.setStatus(false);
            e.printStackTrace();
        }
        return message;

    }

    @RequestMapping(value = "/updatePic", method = RequestMethod.POST)
    public ResponseMessage updatePic(@RequestBody Pictures pictures) {
        logger.debug("updatePic");
        ResponseMessage message = new ResponseMessage();
        try {
            if (pictures.getPicId() == null)
                throw new RuntimeException();
            picturesService.updatePicture(pictures);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            message.setErrorCode(ErrorCode.DataBaseAccessError);
        }
        return message;

    }


    @RequestMapping("/getLimitPics")
    public ResponseMessage getLimitPics(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        logger.debug("getLimitPics:currentPage=" + currentPage + ",pageSize=" + pageSize);
        ResponseMessage message = new ResponseMessage();
        CSparam<Pictures> param = new CSparam<Pictures>();
        param.setCurrentPage(currentPage);
        param.setPageSize(pageSize);

        try {
            SCresponse<SelfPictures> response = picturesService.getLimitPics(param);

            message.setData(response);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;
    }

    /**
     * 根据项目编号查图片
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectByCategoryId")
    public ResponseMessage selectByCategoryId(@RequestParam("categoryId") int id) {
        logger.debug("selectByCategoryId: id=" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            List<Pictures> pictureLocation = picturesService.selectByCategoryId(id);
            message.setData(pictureLocation);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }
        return message;
    }

}
