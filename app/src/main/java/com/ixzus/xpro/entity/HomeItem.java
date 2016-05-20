package com.ixzus.xpro.entity;

/**
 * Created by metro on 2016/5/20.
 * 描述:
 */
public class HomeItem {

    /**
     * careNum : 1
     * certification : 1
     * id : 232
     * imgUrl : recommend/img/20160317/up_recommend_img_1458185148706_93_550_559jpg
     * link : http://m.zhubaoshi.cn/article/getArticleDetail.html?id=298
     * tag :
     * targetId : 298
     * title : A4腰炫腹什么仇什么怨
     * type : 2
     * username : 小狮子
     */

    private int careNum;
    private int certification;
    private int id;
    private String imgUrl;
    private String link;
    private String tag;
    private int targetId;
    private String title;
    private int type;
    private String username;

    public int getCareNum() {
        return careNum;
    }

    public void setCareNum(int careNum) {
        this.careNum = careNum;
    }

    public int getCertification() {
        return certification;
    }

    public void setCertification(int certification) {
        this.certification = certification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" username="+"title=" + title + username +" imgUrl=" + imgUrl);
        return sb.toString();
    }
}
