package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Guides;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.GuidesService;
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
 * @create 2017-12-09 15:51
 **/
@RestController
public class GuidesRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("guidesServiceImpl")
    private GuidesService guidesService;

    @RequestMapping("/selectGuideById")
    public ResponseMessage selectGuideById(@RequestParam("id") Integer id) {
        /**
         * describe: 根据id查Guide
         * class_name: selectGuideById
         * param: [id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:54
         **/
        logger.debug("selectGuideById id：" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = guidesService.getGuidesById(id);
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

    @RequestMapping("/selectGuideByIdAndType")
    public ResponseMessage selectGuideByIdAndType(@RequestParam("id") Integer id, @RequestParam("type") String type) {
        /**
         * describe: 根据id和type查询Guides
         * class_name: selectGuideByIdAndType
         * param: [id, type]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:56
         **/
        logger.debug("selectGuideByIdAndType id：" + id + "type:" + type);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = guidesService.findGuideByIdAndType(id, type);
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

    @RequestMapping("/limitGuidesByTypeAndCurrentPageAndPageSize")
    public ResponseMessage getGuidesLimit(@RequestParam("type") String type,
                                          @RequestParam("currentPage") int currentPage,
                                          @RequestParam("pageSize") int pageSize) {
        /**
         * describe: 根据type找出所有的Guides并进行分页
         * class_name: getGuidesLimit
         * param: [type, currentPage, pageSize]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:23
         **/
        logger.debug("getGuidesLimit currentPage:" + currentPage + "pageSize:" + pageSize + "Type" + type);
        // 创建参数对象
        CSparam<Guides> cs = new CSparam<Guides>();
        cs.setCurrentPage(currentPage);
        cs.setPageSize(pageSize);
        Guides guides = new Guides();
        guides.setType(type);
        cs.setParamObj(guides);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<Guides> res = guidesService.findGuidesByTypeList(cs);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }


}
