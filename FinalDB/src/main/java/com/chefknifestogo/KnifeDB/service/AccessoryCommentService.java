package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.AccessoryComment;
import com.chefknifestogo.KnifeDB.dao.AccessoryCommentDao;
import com.chefknifestogo.KnifeDB.dao.AccessoryDao;
import com.chefknifestogo.KnifeDB.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Float.NaN;

@Service
public class AccessoryCommentService {

    @Autowired
    private AccessoryDao accessoryDao;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AccessoryCommentDao accessoryCommentDao;

    public List<AccessoryComment> getCommentByAccessoryId(int id){
        return accessoryCommentDao.findAccessoryCommentsByAccessory_Id(id);
    }


    public boolean haveCommented(int userId, Authentication authentication){
        return accessoryCommentDao.findByAccessoryIdAndUserid(authService.getUserId(authentication),userId).size()>0;
    }
    public float getAverageRating(int id){
        float ret=0;

        int size=accessoryCommentDao.findAccessoryCommentsByAccessory_Id(id).size();
        for(int i=0;i<size;i++)
        {
            ret+=accessoryCommentDao.findAccessoryCommentsByAccessory_Id(id).get(i).getRating();
        }
        if(size>0){
            return ret/size;
        }
        else
        {
            return NaN;
        }
    }
}
