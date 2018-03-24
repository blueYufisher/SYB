package cn.edu.gdut.llc.share.mesaage;

/**
 * 搜索各层之间传参数用
 *
 * @author wulei
 */
public class InfosVisitParam<T> {

    private Integer[] ints;//需要查询的数组
    private int num;//页面大小
    private T paramObj;//需要限制的参数对象

    public Integer[] getInts() {
        return ints;
    }

    public void setInts(Integer[] ints) {
        this.ints = ints;
    }


    public T getParamObj() {
        return paramObj;
    }

    public void setParamObj(T paramObj) {
        this.paramObj = paramObj;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
