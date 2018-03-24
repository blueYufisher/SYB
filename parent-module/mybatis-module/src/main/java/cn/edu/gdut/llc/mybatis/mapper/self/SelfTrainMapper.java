package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Train;
import cn.edu.gdut.llc.share.mesaage.SMParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2017-12-09 11:05
 **/
public interface SelfTrainMapper {

    /**
     *获取按时间排序的前num个Train
     * @param num
     * @return
     */
    List<Train> findTrainByNum(int num);

    /**
     *获取Train并且分页
     * @param param
     * @return
     */
    List<Train> findLimitTrain(SMParam<Train> param);
}
