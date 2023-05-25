package com.chefknifestogo.KnifeDB.service;


import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.bean.UserDetail;
import com.chefknifestogo.KnifeDB.dao.UserDao;
import com.chefknifestogo.KnifeDB.dao.UserDetailDao;
import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.http.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailDao userDetailDao;

    public List<UserDetail> getAll(){
        return userDetailDao.findAll();
    }

    public UserDetail getUserDetailById(int userId)
    {
        try{
           return userDetailDao.findById(userId).get();
        }
        catch (Exception e)
        {

            e.printStackTrace();
            return new UserDetail();
        }
    }

    public Response addUserInfo(UserDetail userDetail, Authentication authentication){
        User user =userDao.findByUsername(authentication.getName());
        userDetail.setUser(user);
        return new UserDetailResponse(true, userDetailDao.save(userDetail));
    }

    public Response updateUserDetail(UserDetail userDetail){
        UserDetail ud= userDetailDao.findById(userDetail.getId()).get();
        userDetail.setUser(ud.getUser());
        ud=userDetail;
        userDetailDao.save(ud);
        return new Response(true);
    }
}
