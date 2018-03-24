package cn.edu.gdut.llc.message;

public class CSearchparam<T> {

    private int num;
    private int currentPage;//当前页
    private int pageSize;//页面大小
    private T paramObj;
    private Integer[] ints;//需要查询的数组

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public Integer[] getInts() {
        return ints;
    }

    public void setInts(Integer[] ints) {
        this.ints = ints;
    }

}
