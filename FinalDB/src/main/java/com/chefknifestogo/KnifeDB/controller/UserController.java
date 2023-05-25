package com.chefknifestogo.KnifeDB.controller;

import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public Response addUser(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("isAdmin")
    public boolean isAdmin(Authentication authentication){
        return userService.isAdmin(authentication.getAuthorities());
    }

    @GetMapping("isUsernameAvailable/{username}")
    public boolean isUsernameAvaialbe(@PathVariable String username)
    {
        return userService.isUsernameAvailable(username);
    }

    @GetMapping("isUser")
    public boolean isUser(Authentication authentication){
        return userService.isUser(authentication.getAuthorities());
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Response changeUser(@RequestBody User user, Authentication authentication) {
        return userService.changePassword(user, authentication);
    }


    @GetMapping("/getUsernameById/{id}")
    public String getUsernameById(@PathVariable int id){
        return userService.getUsernameById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
