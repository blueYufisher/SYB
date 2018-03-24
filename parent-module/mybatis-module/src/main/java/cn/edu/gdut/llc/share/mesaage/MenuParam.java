package cn.edu.gdut.llc.share.mesaage;

/**
 * 菜单各层之间传参数用
 *
 * @author wulei
 */
public class MenuParam<T> {

    private Integer[] mids;//需要查询的数组
    private T paramObj;//需要限制的参数对象
    public Integer[] getMids() {
        return mids;
    }
    public void setMids(Integer[] mids) {
        this.mids = mids;
    }
    public T getParamObj() {
        return paramObj;
    }
    public void setParamObj(T paramObj) {
        this.paramObj = paramObj;
    }

}
