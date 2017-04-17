package com.example.lenovo.kuaikan.community;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/1.
 */

public class BeanFeeds {

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

        private long current;
        private int pub_feed;
        private long since;
        private List<FeedsBean> feeds;

        public long getCurrent() {
            return current;
        }

        public void setCurrent(long current) {
            this.current = current;
        }

        public int getPub_feed() {
            return pub_feed;
        }

        public void setPub_feed(int pub_feed) {
            this.pub_feed = pub_feed;
        }

        public long getSince() {
            return since;
        }

        public void setSince(long since) {
            this.since = since;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public static class FeedsBean implements Parcelable {


            private int likes_count;
            private long updated_at;
            private int comments_count;
            private String share_url;
            private boolean following;
            private long created_at;
            private int shared_count;
            private int feed_type;
            private UserBean user;
            private ContentBean content;
            private long feed_id;
            private boolean is_liked;
            private String topic_title;
            private int topic_id;

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public long getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(long updated_at) {
                this.updated_at = updated_at;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public boolean isFollowing() {
                return following;
            }

            public void setFollowing(boolean following) {
                this.following = following;
            }

            public long getCreated_at() {
                return created_at;
            }

            public void setCreated_at(long created_at) {
                this.created_at = created_at;
            }

            public int getShared_count() {
                return shared_count;
            }

            public void setShared_count(int shared_count) {
                this.shared_count = shared_count;
            }

            public int getFeed_type() {
                return feed_type;
            }

            public void setFeed_type(int feed_type) {
                this.feed_type = feed_type;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public long getFeed_id() {
                return feed_id;
            }

            public void setFeed_id(long feed_id) {
                this.feed_id = feed_id;
            }

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public String getTopic_title() {
                return topic_title;
            }

            public void setTopic_title(String topic_title) {
                this.topic_title = topic_title;
            }

            public int getTopic_id() {
                return topic_id;
            }

            public void setTopic_id(int topic_id) {
                this.topic_id = topic_id;
            }

            public static class UserBean implements Parcelable {


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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.pub_feed);
                    dest.writeString(this.avatar_url);
                    dest.writeInt(this.grade);
                    dest.writeString(this.nickname);
                    dest.writeString(this.reg_type);
                    dest.writeInt(this.id);
                }

                public UserBean() {
                }

                protected UserBean(Parcel in) {
                    this.pub_feed = in.readInt();
                    this.avatar_url = in.readString();
                    this.grade = in.readInt();
                    this.nickname = in.readString();
                    this.reg_type = in.readString();
                    this.id = in.readInt();
                }

                public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
                    @Override
                    public UserBean createFromParcel(Parcel source) {
                        return new UserBean(source);
                    }

                    @Override
                    public UserBean[] newArray(int size) {
                        return new UserBean[size];
                    }
                };
            }

            public static class ContentBean implements Parcelable {

                private String identity;
                private String image_base;
                private String text;
                private List<String> images;

                public String getIdentity() {
                    return identity;
                }

                public void setIdentity(String identity) {
                    this.identity = identity;
                }

                public String getImage_base() {
                    return image_base;
                }

                public void setImage_base(String image_base) {
                    this.image_base = image_base;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public List<String> getImages() {
                    return images;
                }

                public void setImages(List<String> images) {
                    this.images = images;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.identity);
                    dest.writeString(this.image_base);
                    dest.writeString(this.text);
                    dest.writeStringList(this.images);
                }

                public ContentBean() {
                }

                protected ContentBean(Parcel in) {
                    this.identity = in.readString();
                    this.image_base = in.readString();
                    this.text = in.readString();
                    this.images = in.createStringArrayList();
                }

                public static final Creator<ContentBean> CREATOR = new Creator<ContentBean>() {
                    @Override
                    public ContentBean createFromParcel(Parcel source) {
                        return new ContentBean(source);
                    }

                    @Override
                    public ContentBean[] newArray(int size) {
                        return new ContentBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.likes_count);
                dest.writeLong(this.updated_at);
                dest.writeInt(this.comments_count);
                dest.writeString(this.share_url);
                dest.writeByte(this.following ? (byte) 1 : (byte) 0);
                dest.writeLong(this.created_at);
                dest.writeInt(this.shared_count);
                dest.writeInt(this.feed_type);
                dest.writeParcelable(this.user, flags);
                dest.writeParcelable( this.content, flags);
                dest.writeLong(this.feed_id);
                dest.writeByte(this.is_liked ? (byte) 1 : (byte) 0);
                dest.writeString(this.topic_title);
                dest.writeInt(this.topic_id);
            }

            public FeedsBean() {
            }

            protected FeedsBean(Parcel in) {
                this.likes_count = in.readInt();
                this.updated_at = in.readLong();
                this.comments_count = in.readInt();
                this.share_url = in.readString();
                this.following = in.readByte() != 0;
                this.created_at = in.readLong();
                this.shared_count = in.readInt();
                this.feed_type = in.readInt();
                this.user = in.readParcelable(UserBean.class.getClassLoader());
                this.content = in.readParcelable(ContentBean.class.getClassLoader());
                this.feed_id = in.readLong();
                this.is_liked = in.readByte() != 0;
                this.topic_title = in.readString();
                this.topic_id = in.readInt();
            }

            public static final Parcelable.Creator<FeedsBean> CREATOR = new Parcelable.Creator<FeedsBean>() {
                @Override
                public FeedsBean createFromParcel(Parcel source) {
                    return new FeedsBean(source);
                }

                @Override
                public FeedsBean[] newArray(int size) {
                    return new FeedsBean[size];
                }
            };
        }
    }
}
