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


    @ManyToOne // One BlogPost belongs to one Category
    @JoinColumn(name = "category_id") // Foreign key column name (optional)
    private _Category_ category;

    @OneToMany
    public List<_Like_>likes;

    public _BlogPost_(Long id, String title, String content, String created_At, String updated_At, _Category_ category, List<_Like_> likes) {
        Id = id;
        Title = title;
        Content = content;
        Created_At = created_At;
        Updated_At = updated_At;
        this.category = category;
        this.likes = likes;
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

    public _Category_ getCategory() {
        return category;
    }

    public void setCategory(_Category_ category) {
        this.category = category;
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
