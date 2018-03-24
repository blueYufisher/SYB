package cn.edu.gdut.llc.share.mesaage;

/**
 * 分页查询各层之间传参数用
 *
 * @author wulei
 */
public class SMParam<T> {

    private int num;//显示数量
    private int pageSize;//页面大小
    private int startNum;//需要记录的最小的编号
    private T paramObj;//需要限制的参数对象
    private Integer[] ints;//需要查询的数组

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
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
