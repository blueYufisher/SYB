package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.message.CSearchparam;
import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.message.SearchPostParam;
import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.self.SelfInfos;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.InfosService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import cn.edu.gdut.llc.share.util.LoggerUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:19
 **/
@RestController
public class InfosRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("infosServiceImpl")
    private InfosService infosService;

    @RequestMapping("/selectInfoById")
    public ResponseMessage selectInfoById(HttpServletRequest request, @RequestParam("id") Integer id) {
        /**
         * describe: 根据id查Info
         * class_name: selectGuideById
         * param: [id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:54
         **/
        logger.debug("selectInfoById id：" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = infosService.getInfosById(id);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
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

    @RequestMapping("/selectInfoByIdAndType")
    public ResponseMessage selectInfoByIdAndType(HttpServletRequest request, @RequestBody(required = false) Infos paramObj) {
        /**
         * describe: 根据id和type查询Infos
         * class_name: selectGuideByIdAndType
         * param: [id, type]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:56
         **/
        logger.debug("selectInfoByIdAndType paramObj：" + paramObj);
        ResponseMessage message = new ResponseMessage();
        try {
            SelfInfos selfInfos = new SelfInfos();
            CSparam<SelfInfos> sparam = new CSparam<SelfInfos>();
            selfInfos.setType(paramObj.getType());
            selfInfos.setId(paramObj.getId());
            sparam.setParamObj(selfInfos);
            Object data = infosService.findInfoByIdAndType(sparam);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
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

    @RequestMapping("/selectInfoByNumAndType")
    public ResponseMessage selectInfoByNumAndType(HttpServletRequest request,
                                                  @RequestParam("type") int type,
                                                  @RequestParam("num") int num) {
        /**
         * describe: 根据num和type查询Infos
         * class_name: findGuideByIdAndType
         * param: [id, type]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:48
         **/
        logger.debug("selectInfoByNumAndType type:" + type + "num:" + num);
        // 创建参数对象
        CSparam<SelfInfos> cs = new CSparam<SelfInfos>();
        cs.setNum(num);
        SelfInfos infos = new SelfInfos();
        infos.setType(type);
        cs.setParamObj(infos);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<SelfInfos> res = infosService.findInfoByNumAndType(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

//    @RequestMapping("/findInfoNumByVisit")
//    public ResponseMessage findInfoNumByVisit(HttpServletRequest request,
//                                              @RequestParam("type") int type,
//                                              @RequestParam("num") int num) {
//        /**
//         * describe: 根据num和visit排序找Info
//         * class_name: findInfoNumByVisit
//         * param: [type, num]
//         * return: cn.edu.gdut.llc.share.response.ResponseMessage
//         * creat_user: ZHAN
//         * creat_date: 2018/1/15/0015
//         * creat_time: 9:50
//         **/
//        logger.debug("findInfoNumByVisit type:" + type + "num:" + num);
//        // 创建参数对象
//        CSparam<Infos> cs = new CSparam<Infos>();
//        cs.setNum(num);
//        Infos infos = new Infos();
//        infos.setType(type);
//        cs.setParamObj(infos);
//
//        // 创建返回值对象
//        ResponseMessage message = new ResponseMessage();
//
//        try {
//            SCresponse<Infos> res = infosService.findInfoNumByVisit(cs);
//            JSONObject obj = new JSONObject();
//            obj.put("res:", res);
//            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
//            message.setData(res);
//            message.setStatus(true);
//
//        } catch (Exception e) {
//            message.setStatus(false);
//            message.setMessage(e.toString());
//            e.printStackTrace();
//        }
//
//        return message;
//
//    }

    @RequestMapping("/findInfoNumByVisit")
    public ResponseMessage findInfoNumByVisit(HttpServletRequest request,
                                                     @RequestBody CSearchparam param) {
        /**
         * describe: 根据num和visit排序找Info
         * class_name: findInfoNumByVisit
         * param: [type, num]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 9:50
         **/
        logger.debug("findInfoNumByVisit param:" + param);
        // 创建参数对象
        CSearchparam<Infos> cs = new CSearchparam<Infos>();
        cs.setNum(param.getNum());
        cs.setInts(param.getInts());

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {
            SCresponse<Infos> res = infosService.findInfoNumByVisit(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

    @RequestMapping("/limitInfosByTypeAndCurrentPageAndPageSize")
    public ResponseMessage getInfosLimit(HttpServletRequest request,
                                         @RequestParam("type") int type,
                                         @RequestParam("currentPage") int currentPage,
                                         @RequestParam("pageSize") int pageSize) {
        /**
         * describe: 根据type找出所有的Infos并进行分页
         * class_name: getInfosLimit
         * param: [type, currentPage, pageSize]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:23
         **/
        logger.debug("getInfosLimit currentPage:" + currentPage + "pageSize:" + pageSize + "Type" + type);
        // 创建参数对象
        CSparam<SelfInfos> cs = new CSparam<SelfInfos>();
        cs.setCurrentPage(currentPage);
        cs.setPageSize(pageSize);
        SelfInfos infos = new SelfInfos();
        infos.setType(type);
        cs.setParamObj(infos);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<SelfInfos> res = infosService.findInfosByTypeList(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

    @RequestMapping("/searchInfosTypeByTitleOrNote")
    public ResponseMessage searchInfosTypeByTitleOrNote(HttpServletRequest request,
                                                        @RequestParam("type") int type,
                                                        @RequestParam("currentPage") int currentPage,
                                                        @RequestParam("pageSize") int pageSize,
                                                        @RequestBody(required = false) Infos paramObj) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: getInfosLimit
         * param: [type, currentPage, pageSize]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:23
         **/
        logger.debug("searchInfosTypeByTitleOrNote currentPage:" + currentPage + "pageSize:" + pageSize + "Type" + type + "Infos" + paramObj);
        // 创建参数对象
        CSparam<Infos> cs = new CSparam<Infos>();
        cs.setCurrentPage(currentPage);
        cs.setPageSize(pageSize);
        Infos infos = new Infos();
        infos.setType(type);
        infos.setTitle(paramObj.getTitle());
        infos.setNote(paramObj.getNote());
        cs.setParamObj(infos);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<SelfInfos> res = infosService.searchInfosTypeByTitleOrNote(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

    @RequestMapping("/searchInfosByTitleOrNote")
    public ResponseMessage searchInfosByTitleOrNote(HttpServletRequest request,
                                                    @RequestParam("currentPage") int currentPage,
                                                    @RequestParam("pageSize") int pageSize,
                                                    @RequestBody(required = false) Infos paramObj) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: getInfosLimit
         * param: [type, currentPage, pageSize]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 16:23
         **/
        logger.debug("searchInfosByTitleOrNote currentPage:" + currentPage + "pageSize:" + pageSize + "Infos" + paramObj);
        // 创建参数对象
        CSparam<Infos> cs = new CSparam<Infos>();
        cs.setCurrentPage(currentPage);
        cs.setPageSize(pageSize);
        Infos infos = new Infos();
        infos.setTitle(paramObj.getTitle());
        infos.setNote(paramObj.getNote());
        cs.setParamObj(infos);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<SelfInfos> res = infosService.searchInfosByTitleOrNote(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

    @RequestMapping("/deleteInfo")
    public ResponseMessage deleteInfo(HttpServletRequest request, @RequestParam("id") int id) {
        /**
         * describe: 根据id删除Info
         * class_name: deleteInfo
         * param: [id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:23
         **/
        logger.debug("deleteInfo");
        ResponseMessage message = new ResponseMessage();
        try {
            infosService.deleteInfo(id);
            message.setStatus(true);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            message.setErrorCode(ErrorCode.DataBaseAccessError);
        }
        return message;
    }


    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    public ResponseMessage addInfo(HttpServletRequest request, @RequestBody Infos infos) {
        /**
         * describe: 添加Info
         * class_name: addInfo
         * param: [p]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:25
         **/
        logger.debug("addInfo");
        ResponseMessage message = new ResponseMessage();
        try {
            int id = infosService.addInfo(infos);
            JSONObject obj = new JSONObject();
            obj.put("id:", id);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setStatus(true);
            message.setData(id);
        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
    public ResponseMessage modifyInfo(HttpServletRequest request, @RequestBody Infos infos) {
        /**
         * describe: 修改Info
         * class_name: modifyInfo
         * param: [p]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:26
         **/
        logger.debug("modifyInfo");
        ResponseMessage message = new ResponseMessage();
        try {
            if (infos.getId() == null)
                throw new RuntimeException();
            infosService.modifyInfo(infos);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            message.setErrorCode(ErrorCode.DataBaseAccessError);
        }
        return message;
    }


    @RequestMapping("/modifyInfoVisit")
    public ResponseMessage modifyInfoVisit(HttpServletRequest request, @RequestParam("id") Integer id) {
        /**
         * describe: 根据info_id修改访问量
         * class_name: modifyVisit
         * param: [request, id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/1/14/0014
         * creat_time: 22:31
         **/
        logger.debug("modifyInfoVisit id：" + id);
        ResponseMessage message = new ResponseMessage();
        try {
            int data = infosService.modifyVisit(id);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
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

    @RequestMapping("/searchInfoByTypeId")
    public ResponseMessage searchInfoByTypeId(HttpServletRequest request,
    										  @RequestBody SearchPostParam param) {
        /**
         * describe: 根据输入的type数据搜索info
         * class_name: searchInfoByTypeId
         * param: [request, param]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/3/0003
         * creat_time: 9:27
         **/
        logger.debug("searchInfoByTypeId param:" + param);
        // 创建参数对象
        CSearchparam<Infos> cs = new CSearchparam<Infos>();
        cs.setCurrentPage(param.getCurrentPage());
        cs.setPageSize(param.getPageSize());
        cs.setInts(param.getInts());
        Infos infos = new Infos();
        infos.setTitle(param.getTitle());
        infos.setNote(param.getNote());
        cs.setParamObj(infos);

        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();

        try {

            SCresponse<Infos> res = infosService.getInfoByTypeId_foreach_array(cs);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

    @RequestMapping("/selectInfoNumByReleaseTime")
    public ResponseMessage selectInfoNumByReleaseTime(HttpServletRequest request,
                                                      @RequestParam("num") Integer num) {
        /**
         * describe: 根据数量找到最新的infos
         * class_name: selectInfoNumByReleaseTime
         * param: [request, num]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/4/25/0025
         * creat_time: 15:41
         **/
        logger.debug("selectInfoNumByReleaseTime num:" + num);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = infosService.selectInfoNumByReleaseTime(num);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
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
