package com.example.demo.Entities;

import com.example.demo.Security.Entities.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class _Comment_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "longtext")
    private String content;
    private String createdAt;
    @ManyToOne
    private User user; // **Many-to-One relationship with User** (one user can write many comments, one comment belongs to one user)

    @ManyToOne  // One Comment belongs to one BlogPost
    private _BlogPost_ blogPost;

    public _Comment_() {
    }


    public _Comment_(Long id, String content, String createdAt, User user, _BlogPost_ blogPost) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
        this.blogPost = blogPost;
    }

    public _BlogPost_ getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(_BlogPost_ blogPost) {
        this.blogPost = blogPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
