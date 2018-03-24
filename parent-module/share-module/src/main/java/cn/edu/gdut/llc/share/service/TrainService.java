package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.Train;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:09
 **/
public interface TrainService {
    /** 根据id获取Train
     * @param id
     * @return Train
     */
    Train getTrainById(Integer id);

    /**
     * 获取按时间排序的前num个Train
     * @param num
     * @return
     */
    List<Train> getTrainByNum(int num);

    /**
     * 获取Train并且分页
     * @param param
     * @return
     */
    SCresponse<Train> getLimitTrain(CSparam<Train> param);

    /**
     * 获取数据库当汇总的Train的总的条数
     * @param Train对象paramObj
     * @return int总数量
     */
    int getTotalRecord(Train paramObj);

    /**根据id删除Train
     * @param id
     */
    void deleteTrain(int id);

    /**添加Train
     * @param act
     */
    void addTrain(Train act);

    /**修改Train
     * @param act
     */
    void modifyTrain(Train act);
}
