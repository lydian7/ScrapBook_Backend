package com.ScrapBook.scrapbook_service_db.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_stamp")
    private String time_stamp;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    @JsonIgnoreProperties("posts")
//    private User user;

    @Column(name = "caption")
    private String caption;

    @Column(name = "img_link")
    private String img_link;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @JsonBackReference
    private Room room;

    public Post(String time_stamp, String caption, String img_link, Room room) {
        this.time_stamp = time_stamp;
//        this.user = user;
        this.caption = caption;
        this.img_link = img_link;
        this.room = room;
    }

    public Post() {
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
