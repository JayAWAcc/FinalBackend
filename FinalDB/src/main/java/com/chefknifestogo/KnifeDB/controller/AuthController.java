package com.chefknifestogo.KnifeDB.controller;


import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.service.AuthService;
import com.chefknifestogo.KnifeDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;


    @GetMapping("/checklogin")
    public Response checklogin(Authentication authentication){
        if(authentication!=null) {
            System.out.println(authentication.getName());
        }
        else {
            System.out.println("null");
        }
        return authService.checkLogin(authentication);}

    @GetMapping("/currentUserId")
    public Integer getCurrentLogin(Authentication authentication){return authService.getUserId(authentication);}


}
