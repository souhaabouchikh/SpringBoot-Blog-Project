package com.example.demo.Entities;
import jakarta.persistence.*;

@Entity
public class _Like_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    @ManyToOne
    public _BlogPost_ post;
}
