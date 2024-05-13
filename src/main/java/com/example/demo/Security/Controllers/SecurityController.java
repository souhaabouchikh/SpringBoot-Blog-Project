package com.example.demo.Security.Controllers;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Security.Entities.Role;
import com.example.demo.Security.Entities.User;
import com.example.demo.Security.Repositories.UserRepository;
import com.example.demo.Security.Services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class SecurityController {

    private final UserRepository userRepository;
    private AccountService accountService;
    private final BCryptPasswordEncoder passwordEncoder; // Add this line

    @GetMapping("/AdminHome")
    public String AdminHome() {
        return "redirect:/CategoryPanel";
    }

     @GetMapping("/Access_Denied")
    public String AccessDenied() {
        return "Access_Denied";
    }

    @GetMapping("/login")
    public String login() {
        return "/Login";
    }
    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }
    @RequestMapping("/SaveNewUser")
    public String SaveNewUser(@ModelAttribute("user") User user, BindingResult result){
//        System.out.println(user.toString());
//        accountService.CreateUser(user.getUsername(),user.getPassword(),user.getEmail(),user.getPassword());
//        accountService.AddRoleToUser(user.getUsername(),"CLIENT");

        System.out.println("Processing registration form...");

        if (result.hasErrors()) {
            System.out.println("Binding errors: " + result.getAllErrors());
            return "Login"; // Return to the registration form if there are errors
        }
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            System.out.println("Username is already taken: " + user.getUsername());
            result.rejectValue("username", "error.user", "Username is already taken");
            return "Login"; // Return to the registration form if the username is taken
        }
        // Set necessary properties of the Customer object from the User object
        List<Role> roleList =new ArrayList<>();
        Role role = new Role("CLIENT");
        roleList.add(role);
        user.setRoles(roleList);
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Saving user: " + user);
        user.setUserId(UUID.randomUUID().toString());// from yahya s help
        // Save the user
        userRepository.save(user);
        System.out.println("User saved: " + user);
        return "signup";
    }
    @RequestMapping("/ProfileAdmin")
    public String ProfileAdmin(ModelMap modelMap){
        User user=accountService.GetUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        modelMap.addAttribute("user", user);
        return "Profile";
    }
    @RequestMapping("/Profile")
    public String Profile(ModelMap modelMap){
        User user=accountService.GetUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        modelMap.addAttribute("user", user);
        return "ProfileClient";
    }

}
