package com.example.lenovo.kuaikan.discover.classify;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/2.
 */

public class BeanContent {


    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {


        private int since;
        private List<TopicsBean> topics;
        private List<TagsBean> tags;

        public int getSince() {
            return since;
        }

        public void setSince(int since) {
            this.since = since;
        }

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TopicsBean {


            private String discover_image_url;
            private String vertical_image_url;
            private String cover_image_url;
            private String update_day;
            private String description;
            private int created_at;
            private boolean is_favourite;
            private String title;
            private int likes_count;
            private String update_status;
            private int updated_at;
            private SpecialOfferBean special_offer;
            private int user_id;
            private int comments_count;
            private boolean is_free;
            private int id;
            private UserBean user;
            private int label_id;
            private int comics_count;
            private int order;


            public String getLatest_comic_title() {
                return latest_comic_title;
            }

            public void setLatest_comic_title(String latest_comic_title) {
                this.latest_comic_title = latest_comic_title;
            }

            private String latest_comic_title;

            public long getView_count() {
                return view_count;
            }

            public void setView_count(long view_count) {
                this.view_count = view_count;
            }

            private long view_count;


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

            public boolean isIs_favourite() {
                return is_favourite;
            }

            public void setIs_favourite(boolean is_favourite) {
                this.is_favourite = is_favourite;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
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

            public SpecialOfferBean getSpecial_offer() {
                return special_offer;
            }

            public void setSpecial_offer(SpecialOfferBean special_offer) {
                this.special_offer = special_offer;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public int getLabel_id() {
                return label_id;
            }

            public void setLabel_id(int label_id) {
                this.label_id = label_id;
            }

            public int getComics_count() {
                return comics_count;
            }

            public void setComics_count(int comics_count) {
                this.comics_count = comics_count;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }


            public static class SpecialOfferBean {
            }

            public static class UserBean {


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
        }

        public static class TagsBean {
            /**
             * tag_id : 0
             * title : 全部
             */

            private int tag_id;
            private String title;

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
                this.tag_id = tag_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
