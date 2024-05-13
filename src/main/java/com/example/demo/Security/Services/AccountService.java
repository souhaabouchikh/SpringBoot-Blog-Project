package com.example.demo.Security.Services;

import com.example.demo.Security.Entities.Role;
import com.example.demo.Security.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    User CreateUser(String username, String password, String email,String ConfirmPassword);
    Role CreateRole(String newRole);
    void AddRoleToUser(String username, String newRole);
    void RemoveRoleFromUser(String username, String newRole);
    User loadUserByUsername(String username);
    User GetUserByUsername(String username);
}
