package cn.edu.gdut.llc.share.mesaage;

/**
 * 用户各层之间传参数用
 *
 * @author wulei
 */
public class UserParam<T> {

    private Integer[] rids;//需要查询的数组
    private T paramObj;//需要限制的参数对象
    public Integer[] getRids() {
        return rids;
    }
    public void setRids(Integer[] rids) {
        this.rids = rids;
    }
    public T getParamObj() {
        return paramObj;
    }
    public void setParamObj(T paramObj) {
        this.paramObj = paramObj;
    }

}
