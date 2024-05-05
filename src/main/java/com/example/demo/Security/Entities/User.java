package com.example.demo.Security.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    public String userId;
    @Column(unique = true)
    public String username;
    public String password;
    public String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles= new ArrayList<>();
}
