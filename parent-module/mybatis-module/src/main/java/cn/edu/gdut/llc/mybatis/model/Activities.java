package cn.edu.gdut.llc.mybatis.model;

import java.util.Date;

public class Activities {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.title
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.cover_pic
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer coverPic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.url
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.keyword
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String keyword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.note
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String note;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.origin
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String origin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.release_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Date releaseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.update_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer file;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.visit
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private Integer visit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activities.content
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.id
     *
     * @return the value of activities.id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.id
     *
     * @param id the value for activities.id
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.title
     *
     * @return the value of activities.title
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.title
     *
     * @param title the value for activities.title
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.cover_pic
     *
     * @return the value of activities.cover_pic
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getCoverPic() {
        return coverPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.cover_pic
     *
     * @param coverPic the value for activities.cover_pic
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setCoverPic(Integer coverPic) {
        this.coverPic = coverPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.url
     *
     * @return the value of activities.url
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.url
     *
     * @param url the value for activities.url
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.keyword
     *
     * @return the value of activities.keyword
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.keyword
     *
     * @param keyword the value for activities.keyword
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.note
     *
     * @return the value of activities.note
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.note
     *
     * @param note the value for activities.note
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.origin
     *
     * @return the value of activities.origin
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.origin
     *
     * @param origin the value for activities.origin
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.release_time
     *
     * @return the value of activities.release_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.release_time
     *
     * @param releaseTime the value for activities.release_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.update_time
     *
     * @return the value of activities.update_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.update_time
     *
     * @param updateTime the value for activities.update_time
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.file
     *
     * @return the value of activities.file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getFile() {
        return file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.file
     *
     * @param file the value for activities.file
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setFile(Integer file) {
        this.file = file;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.visit
     *
     * @return the value of activities.visit
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public Integer getVisit() {
        return visit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.visit
     *
     * @param visit the value for activities.visit
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activities.content
     *
     * @return the value of activities.content
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activities.content
     *
     * @param content the value for activities.content
     *
     * @mbggenerated Fri Mar 23 15:34:22 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}