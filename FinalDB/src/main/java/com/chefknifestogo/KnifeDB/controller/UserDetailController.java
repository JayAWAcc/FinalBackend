package com.chefknifestogo.KnifeDB.controller;

import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.bean.UserDetail;
import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-details")
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @GetMapping
    public List<UserDetail> getAllUserDetail(){
        return userDetailService.getAll();
    }
    @GetMapping("/{userId}")
    public UserDetail getUserDetail(@PathVariable("userId") int id){return userDetailService.getUserDetailById(id);}

    @PostMapping
    public Response postUserDetails(@RequestBody UserDetail userDetail, Authentication authentication){
        return userDetailService.addUserInfo(userDetail, authentication);
    }



    @GetMapping("/undefined")
    public UserDetail getUserDetail(){
        return new UserDetail();
    }
    @PutMapping
    public Response putUserInfos(@RequestBody UserDetail userDetail){return userDetailService.updateUserDetail(userDetail);}
}
