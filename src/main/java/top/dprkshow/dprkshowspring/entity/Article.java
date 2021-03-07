package top.dprkshow.dprkshowspring.entity;

import java.awt.*;

public class Article {
    private Integer aid;
    private String snap;
    private String title;
    private String description;
    private String abanner;
    private String content;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getSnap() {
        return snap;
    }

    public void setSnap(String snap) {
        this.snap = snap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getAbanner() {
        return abanner;
    }

    public void setAbanner(String abanner) {
        this.abanner = abanner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
