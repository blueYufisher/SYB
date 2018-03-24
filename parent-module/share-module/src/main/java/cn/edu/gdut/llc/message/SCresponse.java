package cn.edu.gdut.llc.message;

import java.util.List;

public class SCresponse<T> {
    private List<T> preText;
    private List<T> nextText;
    private int totalPage;//总页数
    private int totalRecord;//总数
    private List<T> resultList;//结果集合

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public List<T> getPreText() {
        return preText;
    }

    public void setPreText(List<T> preText) {
        this.preText = preText;
    }

    public List<T> getNextText() {
        return nextText;
    }

    public void setNextText(List<T> nextText) {
        this.nextText = nextText;
    }
}
