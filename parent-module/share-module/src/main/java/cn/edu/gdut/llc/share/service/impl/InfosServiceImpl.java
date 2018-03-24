package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.message.CSearchparam;
import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Infos;
import cn.edu.gdut.llc.mybatis.model.self.SelfInfos;
import cn.edu.gdut.llc.share.dao.InfosDao;
import cn.edu.gdut.llc.share.dao.PicturesDao;
import cn.edu.gdut.llc.share.dao.TypeDao;
import cn.edu.gdut.llc.share.mesaage.InfosVisitParam;
import cn.edu.gdut.llc.share.mesaage.SMParam;
import cn.edu.gdut.llc.share.mesaage.SearchParam;
import cn.edu.gdut.llc.share.service.InfosService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-11 21:17
 **/
@Service
public class InfosServiceImpl implements InfosService {

    @Autowired
    @Qualifier("infosDaoImpl")
    private InfosDao infosDao;
    @Autowired
    @Qualifier("picturesDaoImpl")
    private PicturesDao picturesDao;

    @Autowired
    @Qualifier("typeDaoImpl")
    private TypeDao typeDao;

    @Override
    /**
     * describe: 根据id查Guide
     * class_name: getInfosById
     * param: [id]
     * return: cn.edu.gdut.llc.mybatis.model.Infos
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:44
     **/
    public SelfInfos getInfosById(Integer id) {
    	SelfInfos selfInfos = infosDao.getInfosById(id);
//        SelfInfos selfInfos = new SelfInfos();

//        String pic_id = String.valueOf(infos.getCoverPic());
//        int picId = 0;
//        if (!pic_id.equals("null")) {
//            picId = Integer.parseInt(pic_id);
//            String pic_url = picturesDao.getPicturesById(picId).getPicUrl();
//            selfInfos.setPicUrl(pic_url);
//        }
//        selfInfos.setId(infos.getId());
//        selfInfos.setCoverPic(infos.getCoverPic());
//        selfInfos.setType(infos.getType());
//        selfInfos.setTitle(infos.getTitle());
//        selfInfos.setContent(infos.getContent());
//        selfInfos.setInfosUrl(infos.getInfosUrl());
//        selfInfos.setKeyword(infos.getKeyword());
//        selfInfos.setOrigin(infos.getOrigin());
//        selfInfos.setNote(infos.getNote());
//        selfInfos.setReleaseTime(infos.getReleaseTime());
//        selfInfos.setUpdateTime(infos.getUpdateTime());
//        selfInfos.setVisit(infos.getVisit());
//        selfInfos.setFile(infos.getFile());

        return selfInfos;
    }

    @Override
    /**
     * describe: 根据id和type查询Infos
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    public SCresponse<SelfInfos> findInfoByIdAndType(CSparam<SelfInfos> msg) {
        Infos infos = new Infos();
//        CSparam<Infos> pm = new CSparam<Infos>();
        SMParam<Infos> param = new SMParam<Infos>();
        infos.setId(msg.getParamObj().getId());
        infos.setType(msg.getParamObj().getType());
//        pm.setParamObj(infos);
        param.setParamObj(infos);

        SelfInfos selfInfos = new SelfInfos();
        SMParam<SelfInfos> _param = new SMParam<SelfInfos>();
        selfInfos.setId(msg.getParamObj().getId());
        selfInfos.setType(msg.getParamObj().getType());
        _param.setParamObj(selfInfos);


        SCresponse<SelfInfos> response = new SCresponse<SelfInfos>();
        response.setPreText(infosDao.findPreInfoById(_param));
        response.setNextText(infosDao.findNextInfoById(_param));

        List<SelfInfos> resultList = infosDao.findInfoByIdAndType(_param);

        response.setResultList(resultList);

        return response;
    }

    @Override
    /**
     * describe: 根据num和type查询Infos
     * class_name: findGuideByIdAndType
     * param: [id, type]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 15:48
     **/
    public SCresponse<SelfInfos> findInfoByNumAndType(CSparam<SelfInfos> pm) {
        // 将传入的参数转换成Dao成需要的参数
        SMParam<SelfInfos> param = new SMParam<SelfInfos>();
        param.setNum(pm.getNum());
        param.setParamObj(pm.getParamObj());
        // 查询满足条件的所有记录
        List<SelfInfos> resultList = infosDao.findInfoByNumAndType(param);

        for (SelfInfos infos : resultList) {
            String typeTitle = infos.getTypeList().get(0).getTypeTitle();
            infos.setTypeTitle(typeTitle);
        }


        SCresponse<SelfInfos> response = new SCresponse<SelfInfos>();
        response.setResultList(resultList);
        return response;
    }

    @Override
    public SCresponse<Infos> findInfoNumByVisit(CSearchparam<Infos> msg) {
        /**
         * describe: 根据num和visit排序找Info
         * class_name: findInfoNumByVisit
         * param: [msg]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2018/1/15/0015
         * creat_time: 9:48
         **/
        InfosVisitParam<Infos> param = new InfosVisitParam<Infos>();
        param.setNum(msg.getNum());
        param.setInts(msg.getInts());
//        param.setParamObj(msg.getParamObj());

        // 查询满足条件的所有记录
        SCresponse<Infos> response = new SCresponse<Infos>();
        response.setResultList(infosDao.findInfoNumByVisit(param));
        return response;
    }

    @Override
    /**
     * describe: 根据type查出该组的Infos并进行分页
     * class_name: findInfosByTypeList
     * param: [param]
     * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
     * creat_user: ZHAN
     * creat_date: 2017/12/9/0009
     * creat_time: 16:12
     **/
    public SCresponse<SelfInfos> findInfosByTypeList(CSparam<SelfInfos> pm) {
        // 将传入的参数转换成Dao成需要的参数
        SMParam<SelfInfos> param = new SMParam<SelfInfos>();
        param.setPageSize(pm.getPageSize());
        param.setStartNum((pm.getCurrentPage() - 1) * pm.getPageSize());
        param.setParamObj(pm.getParamObj());

        List<SelfInfos> resultList = infosDao.findInfosByTypeList(param);

        List<SelfInfos> selfInfosList = new ArrayList<SelfInfos>();
        for (SelfInfos infos : resultList) {
            String typeTitle = infos.getTypeList().get(0).getTypeTitle();
            infos.setTypeTitle(typeTitle);

            if(infos.getPicList().size() != 0){
                String picUrl = infos.getPicList().get(0).getPicUrl();
                infos.setPicUrl(picUrl);	
            }
//            SelfInfos selfInfos = new SelfInfos();
//            String pic_id = String.valueOf(infos.getCoverPic());
//            int picId = 0;
//            if (!pic_id.equals("null")) {
//                picId = Integer.parseInt(pic_id);
//                String pic_url = picturesDao.getPicturesById(picId).getUrl();
//                selfInfos.setPicUrl(pic_url);
//            }
//            String type_id = String.valueOf(infos.getType());
//            int typeId = 0;
//            if (!type_id.equals("null")){
//                typeId = Integer.parseInt(type_id);
//                String typeTitle = typeDao.getTypeById(typeId).getTypeTitle();
//                selfInfos.setTypeTitle(typeTitle);
//            }
//            selfInfos.setId(infos.getId());
//            selfInfos.setType(infos.getType());
//            selfInfos.setTitle(infos.getTitle());
//            selfInfos.setContent(infos.getContent());
//            selfInfos.setUrl(infos.getUrl());
//            selfInfos.setKeyword(infos.getKeyword());
//            selfInfos.setOrigin(infos.getOrigin());
//            selfInfos.setNote(infos.getNote());
//            selfInfos.setReleaseTime(infos.getReleaseTime());
//            selfInfos.setUpdateTime(infos.getUpdateTime());
//            selfInfos.setVisit(infos.getVisit());
//            selfInfos.setFile(infos.getFile());
//            selfInfosList.add(selfInfos);
        }


        // 查询总记录数
        int totalRecord = infosDao.countInfosByType(pm.getParamObj().getType());
      
        // 查询满足条件的所有记录
        SCresponse<SelfInfos> response = new SCresponse<SelfInfos>();
        response.setTotalRecord(totalRecord);
        response.setResultList(resultList);
        // 计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }

    @Override
    public SCresponse<SelfInfos> searchInfosTypeByTitleOrNote(CSparam<Infos> pm) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: searchInfosTypeByTitleOrNote
         * param: [pm]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/15/0015
         * creat_time: 10:49
         **/
        SMParam<Infos> infosSMParam = new SMParam<Infos>();
        infosSMParam.setPageSize(pm.getPageSize());
        infosSMParam.setStartNum((pm.getCurrentPage() - 1) * pm.getPageSize());
        infosSMParam.setParamObj(pm.getParamObj());
        List<Infos> resultList = infosDao.searchInfosTypeByTitleOrNote(infosSMParam);

        List<SelfInfos> selfInfosList = new ArrayList<SelfInfos>();
        for (Infos infos : resultList) {
            SelfInfos selfInfos = new SelfInfos();
            String pic_id = String.valueOf(infos.getCoverPic());
            int picId = 0;
            if (!pic_id.equals("null")) {
                picId = Integer.parseInt(pic_id);
                String pic_url = picturesDao.getPicturesById(picId).getPicUrl();
                selfInfos.setPicUrl(pic_url);
            }
            selfInfos.setId(infos.getId());
            selfInfos.setType(infos.getType());
            selfInfos.setTitle(infos.getTitle());
            selfInfos.setContent(infos.getContent());
            selfInfos.setInfosUrl(infos.getInfosUrl());
            selfInfos.setKeyword(infos.getKeyword());
            selfInfos.setOrigin(infos.getOrigin());
            selfInfos.setNote(infos.getNote());
            selfInfos.setReleaseTime(infos.getReleaseTime());
            selfInfos.setUpdateTime(infos.getUpdateTime());
            selfInfos.setVisit(infos.getVisit());
            selfInfos.setFile(infos.getFile());
            selfInfosList.add(selfInfos);
        }

        // 查询总记录数
        int totalRecord = infosDao.countInfosByTitleOrNote(infosSMParam);

        // 查询满足条件的所有记录
        SCresponse<SelfInfos> response = new SCresponse<SelfInfos>();
        response.setResultList(selfInfosList);
        // 计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }

    @Override
    public SCresponse<SelfInfos> searchInfosByTitleOrNote(CSparam<Infos> pm) {
        /**
         * describe: 根据title或者note模糊搜索
         * class_name: searchInfosByTitleOrNote
         * param: [pm]
         * return: cn.edu.gdut.llc.message.SCresponse<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2017/12/15/0015
         * creat_time: 10:49
         **/
        SMParam<Infos> infosSMParam = new SMParam<Infos>();
        infosSMParam.setPageSize(pm.getPageSize());
        infosSMParam.setStartNum((pm.getCurrentPage() - 1) * pm.getPageSize());
        infosSMParam.setParamObj(pm.getParamObj());
        List<Infos> resultList = infosDao.searchInfosByTitleOrNote(infosSMParam);

        List<SelfInfos> selfInfosList = new ArrayList<SelfInfos>();
        for (Infos infos : resultList) {
            SelfInfos selfInfos = new SelfInfos();
            String pic_id = String.valueOf(infos.getCoverPic());
            int picId = 0;
            if (!pic_id.equals("null")) {
                picId = Integer.parseInt(pic_id);
                String pic_url = picturesDao.getPicturesById(picId).getPicUrl();
                selfInfos.setPicUrl(pic_url);
            }
            selfInfos.setId(infos.getId());
            selfInfos.setType(infos.getType());
            selfInfos.setTitle(infos.getTitle());
            selfInfos.setContent(infos.getContent());
            selfInfos.setInfosUrl(infos.getInfosUrl());
            selfInfos.setKeyword(infos.getKeyword());
            selfInfos.setOrigin(infos.getOrigin());
            selfInfos.setNote(infos.getNote());
            selfInfos.setReleaseTime(infos.getReleaseTime());
            selfInfos.setUpdateTime(infos.getUpdateTime());
            selfInfos.setVisit(infos.getVisit());
            selfInfos.setFile(infos.getFile());
            selfInfosList.add(selfInfos);
        }

        // 查询总记录数
        int totalRecord = infosDao.countInfosByTitleOrNote(infosSMParam);

        // 查询满足条件的所有记录
        SCresponse<SelfInfos> response = new SCresponse<SelfInfos>();
        response.setResultList(selfInfosList);
        // 计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / pm.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }

    @Override
    public void deleteInfo(int id) {
        /**
         * describe: 根据id删除Info
         * class_name: deleteInfo
         * param: [id]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:17
         **/
        infosDao.deleteInfo(id);
    }

    @Override
    public int addInfo(Infos infos) {
        /**
         * describe: 添加Info
         * class_name: addInfo
         * param: [infos]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:17
         **/
//        return infosDao.addInfo(infos);
        int id = infosDao.addInfo(infos);
        String category = infos.getType().toString() ;
        int categoryId = id;
        String pic_id = String.valueOf(infos.getCoverPic());
        int picId = 0;
        if(!pic_id.equals("null")){
            picId = Integer.parseInt(pic_id);
            picturesDao.modifyPictureInfo(category,categoryId,picId);
        }
        return id;
    }

    @Override
    public void modifyInfo(Infos infos) {
        /**
         * describe: 修改Info
         * class_name: modifyInfo
         * param: [infos]
         * return: void
         * creat_user: ZHAN
         * creat_date: 2018/1/1/0001
         * creat_time: 0:22
         **/
        infosDao.modifyInfo(infos);
        int id = infos.getId();
        String category = infos.getType().toString() ;
        int categoryId = id;

        String pic_id = String.valueOf(infos.getCoverPic());
        int picId = 0;
        if(!pic_id.equals("null")){
            picId = Integer.parseInt(pic_id);
            picturesDao.modifyPictureInfo(category,categoryId,picId);
        }

    }

    @Override
    public int modifyVisit(Integer id) {
        /**
         * describe: 根据info_id修改访问量
         * class_name: modifyVisit
         * param: [id]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/1/14/0014
         * creat_time: 22:30
         **/
        return infosDao.modifyVisit(id);
    }

    @Override
    public SCresponse<Infos> getInfoByTypeId_foreach_array(CSearchparam<Infos> msg) {
        /**
         * describe: 根据输入的type数据搜索info
         * class_name: getInfoByTypeId_foreach_array
         * param: [msg]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Infos>
         * creat_user: ZHAN
         * creat_date: 2018/2/3/0003
         * creat_time: 1:23
         **/
        SearchParam<Infos> param = new SearchParam<Infos>();
        param.setPageSize(msg.getPageSize());
        param.setStartNum((msg.getCurrentPage() - 1) * msg.getPageSize());
        param.setParamObj(msg.getParamObj());
        param.setInts(msg.getInts());

        List<Infos> resultList = infosDao.getInfoByTypeId_foreach_array(param);

        // 查询总记录数
        int totalRecord = infosDao.countInfoByTypeId_foreach_array(param);

        // 查询满足条件的所有记录
        SCresponse<Infos> response = new SCresponse<Infos>();
        response.setTotalRecord(totalRecord);
        response.setResultList(resultList);
        // 计算总页面
        int totalPage = (int) Math.ceil((double) totalRecord / param.getPageSize());
        response.setTotalPage(totalPage);
        return response;
    }
}

