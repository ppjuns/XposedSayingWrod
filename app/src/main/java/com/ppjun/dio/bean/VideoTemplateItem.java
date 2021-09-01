package com.ppjun.dio.bean;

import java.io.File;
import java.io.Serializable;

public class VideoTemplateItem implements Serializable {
    public static final int TYPE_GREENSENCE = 9;
    public static final int TYPE_MATTING = 13;
    private String author;
    private int classification;
    private String compress;
    private String compressName;
    private String created;
    private Integer enabled;
    private String icon;
    private int id;
    private Object ios_diversion;
    private boolean isDownload;
    public boolean isFeedIndex;
    private Integer is_android_ios;
    private Integer is_douyin_top;
    private int is_erect;
    private int is_instep;
    private int is_kx;
    private Integer is_look_background;
    private Integer is_top;
    private int is_ve;
    private String link;
    private String localPath;
    private String material;
    private String material_info;
    private String mbSearch;
    private String mbsearch;
    private Integer newtype;
    private int picture_num;
    private Integer preview;
    private Integer reading;
    private Integer reading2;
    private Integer required_material;
    private Integer set_erect;
    private Integer shear_click;
    private Integer shear_num;
    private Integer sort;
    private Integer special;
    private int special_effects;
    private Integer test;
    private String thumb;
    private int timelen;
    private String title;
    private int type;
    private String typeName;
    private int video_num;
    private Integer yesterday_num;
    private Integer yesterday_youth_num;

    public boolean isFeedIndex() {
        return this.isFeedIndex;
    }

    public void setFeedIndex(boolean z) {
        this.isFeedIndex = z;
    }

    public int getSpecial_effects() {
        return this.special_effects;
    }

    public void setSpecial_effects(int i) {
        this.special_effects = i;
    }

    public boolean isGreenSence() {
        return this.classification == 9;
    }

    public boolean isMatting() {
        return this.is_kx == 1;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setMbSearch(String str) {
        this.mbSearch = str;
    }

    public String getMbSearch() {
        return this.mbSearch;
    }

    public void setClassification(int i) {
        this.classification = i;
    }

    public int getClassification() {
        return this.classification;
    }

    public boolean isVeTemplate() {
        return this.is_ve == 1;
    }

    public void setIs_ve(int i) {
        this.is_ve = i;
    }

    public int getIs_ve() {
        return this.is_ve;
    }

    public int getIs_kx() {
        return this.is_kx;
    }

    public void setIs_kx(int i) {
        this.is_kx = i;
    }

    public int getIs_instep() {
        return this.is_instep;
    }

    public void setIs_instep(int i) {
        this.is_instep = i;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getCompress() {
        return this.compress;
    }

    public void setCompress(String str) {
        this.compress = str;
    }

    public int getTimelen() {
        return this.timelen;
    }

    public void setTimelen(int i) {
        this.timelen = i;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String str) {
        this.material = str;
    }

    public int getPicture_num() {
        return this.picture_num;
    }

    public void setPicture_num(int i) {
        this.picture_num = i;
    }

    public int getVideo_num() {
        return this.video_num;
    }

    public void setVideo_num(int i) {
        this.video_num = i;
    }

    public String getMaterial_info() {
        return this.material_info;
    }

    public void setMaterial_info(String str) {
        this.material_info = str;
    }

    public int getIs_erect() {
        return this.is_erect;
    }

    public void setIs_erect(int i) {
        this.is_erect = i;
    }

    public void setDownload(boolean z) {
        this.isDownload = z;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public boolean getIsInstep() {
        return this.is_instep == 1;
    }

    public void setIsInstep(int i) {
        this.is_instep = i;
    }


    public void setIsDownload(boolean z) {
        this.isDownload = z;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer num) {
        this.enabled = num;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer num) {
        this.sort = num;
    }

    public String getCompressName() {
        return this.compressName;
    }

    public void setCompressName(String str) {
        this.compressName = str;
    }

    public Integer getTest() {
        return this.test;
    }

    public void setTest(Integer num) {
        this.test = num;
    }

    public Integer getIs_android_ios() {
        return this.is_android_ios;
    }

    public void setIs_android_ios(Integer num) {
        this.is_android_ios = num;
    }

    public Integer getSet_erect() {
        return this.set_erect;
    }

    public void setSet_erect(Integer num) {
        this.set_erect = num;
    }

    public Integer getRequired_material() {
        return this.required_material;
    }

    public void setRequired_material(Integer num) {
        this.required_material = num;
    }

    public Integer getPreview() {
        return this.preview;
    }

    public void setPreview(Integer num) {
        this.preview = num;
    }

    public Integer getReading() {
        return this.reading;
    }

    public void setReading(Integer num) {
        this.reading = num;
    }

    public Integer getReading2() {
        return this.reading2;
    }

    public void setReading2(Integer num) {
        this.reading2 = num;
    }

    public Integer getNewtype() {
        return this.newtype;
    }

    public void setNewtype(Integer num) {
        this.newtype = num;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String str) {
        this.created = str;
    }

    public String getMbsearch() {
        return this.mbsearch;
    }

    public void setMbsearch(String str) {
        this.mbsearch = str;
    }

    public Object getIos_diversion() {
        return this.ios_diversion;
    }

    public void setIos_diversion(Object obj) {
        this.ios_diversion = obj;
    }

    public Integer getYesterday_num() {
        return this.yesterday_num;
    }

    public void setYesterday_num(Integer num) {
        this.yesterday_num = num;
    }

    public Integer getYesterday_youth_num() {
        return this.yesterday_youth_num;
    }

    public void setYesterday_youth_num(Integer num) {
        this.yesterday_youth_num = num;
    }

    public Integer getIs_look_background() {
        return this.is_look_background;
    }

    public void setIs_look_background(Integer num) {
        this.is_look_background = num;
    }

    public Integer getIs_douyin_top() {
        return this.is_douyin_top;
    }

    public void setIs_douyin_top(Integer num) {
        this.is_douyin_top = num;
    }

    public Integer getIs_top() {
        return this.is_top;
    }

    public void setIs_top(Integer num) {
        this.is_top = num;
    }

    public Integer getSpecial() {
        return this.special;
    }

    public void setSpecial(Integer num) {
        this.special = num;
    }

    public Integer getShear_num() {
        return this.shear_num;
    }

    public void setShear_num(Integer num) {
        this.shear_num = num;
    }

    public Integer getShear_click() {
        return this.shear_click;
    }

    public void setShear_click(Integer num) {
        this.shear_click = num;
    }
}