package cn.edu.gdut.llc.mybatis.model.self;

public class SelfRole {
    private Integer rid;

    private String rname;

    private String rnamezh;

    private String note;


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRnamezh() {
        return rnamezh;
    }

    public void setRnamezh(String rnamezh) {
        this.rnamezh = rnamezh;
    }
}