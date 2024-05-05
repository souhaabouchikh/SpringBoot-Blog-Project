package com.example.demo.Security.Repositories;

import com.example.demo.Security.Entities.Role;
import com.example.demo.Security.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRole(String name);
}
