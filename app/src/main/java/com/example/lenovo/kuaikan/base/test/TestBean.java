package com.example.lenovo.kuaikan.base.test;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/25.
 */

public class TestBean {


    /**
     * discover_image_url :
     * vertical_image_url : http://f2.kkmh.com/image/170317/tj8qkte83.webp-w320
     * cover_image_url : http://f2.kkmh.com/image/170317/u7vfbkarg.webp-w640
     * update_day : (每周一更新)
     * description : 在百年鬼宅里拍摄还原鬼宅历史的电影是什么体验？！少女金小伊随着剧组入住这座神秘的月令馆后，一系列剧本之外的灵异事件竟陆续发生！黑夜已经到来，在历史中模糊了的悲剧，正在古宅真实重演！【独家/每周一更新  责编：33】
     * created_at : 1489738459
     * title : 月令馆神秘事件
     * update_status : 连载中
     * updated_at : 1489738459
     * id : 1055
     * label_id : 32
     * order : 0
     * comics_count : 7
     * comments_count : 9550
     * likes_count : 622783
     * fav_count : 347797
     * is_favourite : false
     * sort : 0
     * user : {"pub_feed":0,"avatar_url":"http://f2.kkmh.com/image/170317/mauf4ammw.webp-w180","grade":1,"nickname":"Maharo/Daum webtoon","reg_type":"author","id":37132892}
     * related_authors : [{"pub_feed":0,"avatar_url":"http://f2.kkmh.com/image/170317/mauf4ammw.webp-w180","grade":1,"nickname":"Maharo/Daum webtoon","reg_type":"author","id":37132892},{"pub_feed":0,"avatar_url":"http://f2.kkmh.com/image/170317/xjuz4lqba.webp-w180","grade":1,"nickname":"Goc/Daum webtoon","reg_type":"author","id":37132934}]
     * view_count : 48106573
     * label : {"id":32,"text":"悬疑","text_color":"#ffffff","bg_color":"#1e4691"}
     * category : ["剧情","灵异"]
     * is_free : true
     * comics : [{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170421/huionoorw.webp-w640","storyboard_cnt":33,"created_at":1492984204,"has_pay":false,"title":"第6话 藏尸","url":"http://www.kuaikanmanhua.com/comics/24436","likes_count":52047,"special_offer":{},"updated_at":1492779141,"comments_count":528,"is_free":true,"push_flag":1,"id":24436,"topic_id":1055,"serial_no":0,"status":"published"},{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170414/reu9yv655.webp-w640","storyboard_cnt":44,"created_at":1492379404,"has_pay":false,"title":"第5话 永别","url":"http://www.kuaikanmanhua.com/comics/23835","likes_count":70224,"special_offer":{},"updated_at":1492172673,"comments_count":808,"is_free":true,"push_flag":1,"id":23835,"topic_id":1055,"serial_no":0,"status":"published"},{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170407/lbacb62ux.webp-w640","storyboard_cnt":33,"created_at":1491774604,"has_pay":false,"title":"第4话 开启！神秘古董盒","url":"http://www.kuaikanmanhua.com/comics/23491","likes_count":74492,"special_offer":{},"updated_at":1491536876,"comments_count":807,"is_free":true,"push_flag":1,"id":23491,"topic_id":1055,"serial_no":0,"status":"published"},{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170401/i97lcm9rw.webp-w640","storyboard_cnt":33,"created_at":1491169804,"has_pay":false,"title":"第3话 奇怪的演员们","url":"http://www.kuaikanmanhua.com/comics/23328","likes_count":97918,"special_offer":{},"updated_at":1491045286,"comments_count":927,"is_free":true,"push_flag":1,"id":23328,"topic_id":1055,"serial_no":0,"status":"published"},{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170326/t4xowijri.webp-w640","storyboard_cnt":33,"created_at":1490565003,"has_pay":false,"title":"第2话 窗外神秘人","url":"http://www.kuaikanmanhua.com/comics/23040","likes_count":112648,"special_offer":{},"updated_at":1490510959,"comments_count":2249,"is_free":true,"push_flag":1,"id":23040,"topic_id":1055,"serial_no":0,"status":"published"},{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170320/j0sddahcn.webp-w640","storyboard_cnt":44,"created_at":1490019514,"has_pay":false,"title":"第1话 在凶宅拍恐怖片？！","url":"http://www.kuaikanmanhua.com/comics/22723","likes_count":179391,"special_offer":{},"updated_at":1489738779,"comments_count":3897,"is_free":true,"push_flag":0,"id":22723,"topic_id":1055,"serial_no":0,"status":"published"},{"can_view":true,"cover_image_url":"http://f2.kkmh.com/image/170319/4km8y9ksv.webp-w640","storyboard_cnt":44,"created_at":1489933097,"has_pay":false,"title":"序章 古宅心慌慌","url":"http://www.kuaikanmanhua.com/comics/22774","likes_count":36063,"special_offer":{},"updated_at":1489925635,"comments_count":334,"is_free":true,"push_flag":0,"id":22774,"topic_id":1055,"serial_no":0,"status":"published"}]
     */

    private String discover_image_url;
    private String vertical_image_url;
    private String cover_image_url;
    private String update_day;
    private String description;
    private int created_at;
    private String title;
    private String update_status;
    private int updated_at;
    private int id;
    private int label_id;
    private int order;
    private int comics_count;
    private int comments_count;
    private int likes_count;
    private int fav_count;
    private boolean is_favourite;
    private int sort;
    private UserBean user;
    private int view_count;
    private LabelBean label;
    private boolean is_free;
    private List<RelatedAuthorsBean> related_authors;
    private List<String> category;
    private List<ComicsBean> comics;

    public String getDiscover_image_url() {
        return discover_image_url;
    }

    public void setDiscover_image_url(String discover_image_url) {
        this.discover_image_url = discover_image_url;
    }

    public String getVertical_image_url() {
        return vertical_image_url;
    }

    public void setVertical_image_url(String vertical_image_url) {
        this.vertical_image_url = vertical_image_url;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public String getUpdate_day() {
        return update_day;
    }

    public void setUpdate_day(String update_day) {
        this.update_day = update_day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(String update_status) {
        this.update_status = update_status;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLabel_id() {
        return label_id;
    }

    public void setLabel_id(int label_id) {
        this.label_id = label_id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getComics_count() {
        return comics_count;
    }

    public void setComics_count(int comics_count) {
        this.comics_count = comics_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getFav_count() {
        return fav_count;
    }

    public void setFav_count(int fav_count) {
        this.fav_count = fav_count;
    }

    public boolean isIs_favourite() {
        return is_favourite;
    }

    public void setIs_favourite(boolean is_favourite) {
        this.is_favourite = is_favourite;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public LabelBean getLabel() {
        return label;
    }

    public void setLabel(LabelBean label) {
        this.label = label;
    }

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public List<RelatedAuthorsBean> getRelated_authors() {
        return related_authors;
    }

    public void setRelated_authors(List<RelatedAuthorsBean> related_authors) {
        this.related_authors = related_authors;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<ComicsBean> getComics() {
        return comics;
    }

    public void setComics(List<ComicsBean> comics) {
        this.comics = comics;
    }

    public static class UserBean {
        /**
         * pub_feed : 0
         * avatar_url : http://f2.kkmh.com/image/170317/mauf4ammw.webp-w180
         * grade : 1
         * nickname : Maharo/Daum webtoon
         * reg_type : author
         * id : 37132892
         */

        private int pub_feed;
        private String avatar_url;
        private int grade;
        private String nickname;
        private String reg_type;
        private int id;

        public int getPub_feed() {
            return pub_feed;
        }

        public void setPub_feed(int pub_feed) {
            this.pub_feed = pub_feed;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getReg_type() {
            return reg_type;
        }

        public void setReg_type(String reg_type) {
            this.reg_type = reg_type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class LabelBean {
        /**
         * id : 32
         * text : 悬疑
         * text_color : #ffffff
         * bg_color : #1e4691
         */

        private int id;
        private String text;
        private String text_color;
        private String bg_color;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText_color() {
            return text_color;
        }

        public void setText_color(String text_color) {
            this.text_color = text_color;
        }

        public String getBg_color() {
            return bg_color;
        }

        public void setBg_color(String bg_color) {
            this.bg_color = bg_color;
        }
    }

    public static class RelatedAuthorsBean {
        /**
         * pub_feed : 0
         * avatar_url : http://f2.kkmh.com/image/170317/mauf4ammw.webp-w180
         * grade : 1
         * nickname : Maharo/Daum webtoon
         * reg_type : author
         * id : 37132892
         */

        private int pub_feed;
        private String avatar_url;
        private int grade;
        private String nickname;
        private String reg_type;
        private int id;

        public int getPub_feed() {
            return pub_feed;
        }

        public void setPub_feed(int pub_feed) {
            this.pub_feed = pub_feed;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getReg_type() {
            return reg_type;
        }

        public void setReg_type(String reg_type) {
            this.reg_type = reg_type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ComicsBean {
        /**
         * can_view : true
         * cover_image_url : http://f2.kkmh.com/image/170421/huionoorw.webp-w640
         * storyboard_cnt : 33
         * created_at : 1492984204
         * has_pay : false
         * title : 第6话 藏尸
         * url : http://www.kuaikanmanhua.com/comics/24436
         * likes_count : 52047
         * special_offer : {}
         * updated_at : 1492779141
         * comments_count : 528
         * is_free : true
         * push_flag : 1
         * id : 24436
         * topic_id : 1055
         * serial_no : 0
         * status : published
         */

        private boolean can_view;
        private String cover_image_url;
        private int storyboard_cnt;
        private int created_at;
        private boolean has_pay;
        private String title;
        private String url;
        private int likes_count;
        private SpecialOfferBean special_offer;
        private int updated_at;
        private int comments_count;
        private boolean is_free;
        private int push_flag;
        private int id;
        private int topic_id;
        private int serial_no;
        private String status;

        public boolean isCan_view() {
            return can_view;
        }

        public void setCan_view(boolean can_view) {
            this.can_view = can_view;
        }

        public String getCover_image_url() {
            return cover_image_url;
        }

        public void setCover_image_url(String cover_image_url) {
            this.cover_image_url = cover_image_url;
        }

        public int getStoryboard_cnt() {
            return storyboard_cnt;
        }

        public void setStoryboard_cnt(int storyboard_cnt) {
            this.storyboard_cnt = storyboard_cnt;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public boolean isHas_pay() {
            return has_pay;
        }

        public void setHas_pay(boolean has_pay) {
            this.has_pay = has_pay;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public SpecialOfferBean getSpecial_offer() {
            return special_offer;
        }

        public void setSpecial_offer(SpecialOfferBean special_offer) {
            this.special_offer = special_offer;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isIs_free() {
            return is_free;
        }

        public void setIs_free(boolean is_free) {
            this.is_free = is_free;
        }

        public int getPush_flag() {
            return push_flag;
        }

        public void setPush_flag(int push_flag) {
            this.push_flag = push_flag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTopic_id() {
            return topic_id;
        }

        public void setTopic_id(int topic_id) {
            this.topic_id = topic_id;
        }

        public int getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(int serial_no) {
            this.serial_no = serial_no;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public static class SpecialOfferBean {
        }
    }
}
