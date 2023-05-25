package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.dao.UserDao;
import com.chefknifestogo.KnifeDB.http.AuthenticationSuccessResponse;
import com.chefknifestogo.KnifeDB.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserDao userDao;


    public Response checkLogin(Authentication authentication)
    {
        if(authentication!=null){
            Response response= new AuthenticationSuccessResponse(true,200,"Logged In", userDao.findByUsername(authentication.getName()));
            return response;
        }
        else
        {
            return new Response(false);
        }
    }

    public Integer getUserId(Authentication authentication)
    {
        if(authentication!=null){
            return userDao.findByUsername(authentication.getName()).getId();
        }
        else{
            return -1;
        }
    }
}
