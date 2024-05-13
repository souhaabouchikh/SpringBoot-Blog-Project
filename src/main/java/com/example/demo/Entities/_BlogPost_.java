package com.example.demo.Entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class _BlogPost_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String Title;
    @Column(columnDefinition = "longtext")
    public String Content;
    public String Created_At;
    public String Updated_At;
    public String Image;

    @ManyToOne   // One post belongs to one category (optional, can be removed if a post can belong to multiple categories)
    private _Category_ category;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<_Like_>likes;


    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    private List<_Comment_> comments;

    public _BlogPost_(Long id, String title, String content, String created_At, String image, String updated_At, List<_Like_> likes, _Category_ category, List<_Comment_> comments) {
        Id = id;
        Title = title;
        Content = content;
        Created_At = created_At;
        Image = image;
        Updated_At = updated_At;
        this.likes = likes;
        this.category = category;
        this.comments = comments;
    }

    public _Category_ getCategory() {
        return category;
    }

    public void setCategory(_Category_ category) {
        this.category = category;
    }

    public List<_Comment_> getComments() {
        return comments;
    }

    public void setComments(List<_Comment_> comments) {
        this.comments = comments;
    }


    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }




    public _BlogPost_() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(String created_At) {
        Created_At = created_At;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(String updated_At) {
        Updated_At = updated_At;
    }

    public List<_Like_> getLikes() {
        return likes;
    }

    public void setLikes(List<_Like_> likes) {
        this.likes = likes;
    }
}
