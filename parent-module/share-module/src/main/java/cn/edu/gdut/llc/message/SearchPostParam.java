package cn.edu.gdut.llc.message;

import java.util.Date;

public class SearchPostParam {

    private Integer[] ints;
    private int currentPage;
    private int pageSize;
    private String title;
    private String note;

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
    public Integer[] getInts() { return ints; }
    public void setInts(Integer[] ints) { this.ints = ints; }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTitle(String title) {

        this.title = title;
    }


}
