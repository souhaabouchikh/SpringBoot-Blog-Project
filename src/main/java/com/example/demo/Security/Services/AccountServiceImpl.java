package com.example.demo.Security.Services;

import com.example.demo.Security.Entities.Role;
import com.example.demo.Security.Entities.User;
import com.example.demo.Security.Repositories.RoleRepository;
import com.example.demo.Security.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    BCryptPasswordEncoder  bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public User CreateUser(String username, String password, String email, String ConfirmPassword) {
//        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setUserName(username);
//        user.setPassword(bCryptPasswordEncoder.encode(password));
//        user.setEmail(email);
//        userRepository.save(user);

           User user1=userRepository.findByUsername(username);
           if(user1!=null)throw new RuntimeException("User Already Exists");
           if(!password.equals(ConfirmPassword))throw new RuntimeException("Confirm Password Not Matched");
           user1 = User.builder()
           .userId(UUID.randomUUID().toString())
           .username(username)
           .email(email)
           .password(bCryptPasswordEncoder.encode(password))
           .build();
           return userRepository.save(user1);
    }

    @Override
    public Role CreateRole(String role) {
        Role role1=roleRepository.findByRole(role);
        if(role1!=null)throw new RuntimeException("Role Already Exists");
                role1=Role.builder()
                .role(role)
                .build();
        return roleRepository.save(role1);
    }

    @Override
    public void AddRoleToUser(String username, String newRole) {
        User user1 = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByRole(newRole);
        user1.getRoles().add(role1);
    }

    @Override
    public void RemoveRoleFromUser(String username, String newRole) {
        User user1 = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByRole(newRole);
        user1.getRoles().remove(role1);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
