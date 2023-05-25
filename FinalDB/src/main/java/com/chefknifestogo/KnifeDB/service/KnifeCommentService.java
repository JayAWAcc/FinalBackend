package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.KnifeComment;
import com.chefknifestogo.KnifeDB.dao.KnifeCommentDao;
import com.chefknifestogo.KnifeDB.dao.KnifeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Float.NaN;

@Service
public class KnifeCommentService {
    @Autowired
    private KnifeDao knifeDao;

    @Autowired
    private AuthService authService;
    @Autowired
    private KnifeCommentDao knifeCommentDao;

    public List<KnifeComment> getCommentsByKnifeId(int id){
        return knifeCommentDao.findKnifeCommentsByKnifeId(id);
    }

    public float getAverageRating(int id){
        float ret=0;

        int size=knifeCommentDao.findKnifeCommentsByKnifeId(id).size();
        for(int i=0;i<size;i++)
        {
            ret+=knifeCommentDao.findKnifeCommentsByKnifeId(id).get(i).getRating();
        }
        if(size>0){
            return ret/size;
        }
        else
        {
            return NaN;
        }
    }

    public boolean haveCommented(int knifeId, Authentication authentication){
        return knifeCommentDao.findByKnifeIdAndUserid(knifeId,authService.getUserId(authentication)).size()>0;
    }
}
