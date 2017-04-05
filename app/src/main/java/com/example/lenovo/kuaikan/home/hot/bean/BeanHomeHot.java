package com.example.lenovo.kuaikan.home.hot.bean;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/3/31.
 */

public class BeanHomeHot {


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


        private int timestamp;
        private int since;
        private List<ComicsBean> comics;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getSince() {
            return since;
        }

        public void setSince(int since) {
            this.since = since;
        }

        public List<ComicsBean> getComics() {
            return comics;
        }

        public void setComics(List<ComicsBean> comics) {
            this.comics = comics;
        }

        public static class ComicsBean {

            private int info_type;
            private String label_color;
            private String cover_image_url;
            private int storyboard_cnt;
            private int created_at;
            private String title;
            private String url;
            private int likes_count;
            private boolean can_comment;
            private int updated_at;
            private int selling_kk_currency;
            private int comments_count;
            private String label_text;
            private boolean is_free;
            private int push_flag;
            private TopicBean topic;
            private int shared_count;
            private int id;
            private String label_text_color;
            private int serial_no;
            private String status;
            private boolean is_liked;

            public int getInfo_type() {
                return info_type;
            }

            public void setInfo_type(int info_type) {
                this.info_type = info_type;
            }

            public String getLabel_color() {
                return label_color;
            }

            public void setLabel_color(String label_color) {
                this.label_color = label_color;
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

            public boolean isCan_comment() {
                return can_comment;
            }

            public void setCan_comment(boolean can_comment) {
                this.can_comment = can_comment;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getSelling_kk_currency() {
                return selling_kk_currency;
            }

            public void setSelling_kk_currency(int selling_kk_currency) {
                this.selling_kk_currency = selling_kk_currency;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public String getLabel_text() {
                return label_text;
            }

            public void setLabel_text(String label_text) {
                this.label_text = label_text;
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

            public TopicBean getTopic() {
                return topic;
            }

            public void setTopic(TopicBean topic) {
                this.topic = topic;
            }

            public int getShared_count() {
                return shared_count;
            }

            public void setShared_count(int shared_count) {
                this.shared_count = shared_count;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLabel_text_color() {
                return label_text_color;
            }

            public void setLabel_text_color(String label_text_color) {
                this.label_text_color = label_text_color;
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

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public static class TopicBean {


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
                private UserBean user;
                private int label_id;
                private int order;
                private int comics_count;

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

                public static class UserBean {
                    /**
                     * pub_feed : 0
                     * avatar_url : http://f2.kkmh.com/default_avatar_image.jpg-w180
                     * grade : 1
                     * nickname : Jogeumsan
                     * reg_type : author
                     * id : 37514008
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
            }
        }
    }
}
