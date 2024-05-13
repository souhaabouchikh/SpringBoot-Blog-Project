package com.example.demo.Entities;
import com.mysql.cj.jdbc.Blob;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class _Category_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String Name;
    @Column(columnDefinition = "longtext")
    public String Content;
    public String Created_At;
    public String Updated_At;
    public String Image;

    @ManyToMany  // Optional: Cascade persist for posts
    @JoinTable(name = "category_post",  // Define the name of the third table
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<_BlogPost_> posts;


    public String getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(String updated_At) {
        Updated_At = updated_At;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public List<_BlogPost_> getPosts() {
        return posts;
    }

    public void setPosts(List<_BlogPost_> posts) {
        this.posts = posts;
    }
}
