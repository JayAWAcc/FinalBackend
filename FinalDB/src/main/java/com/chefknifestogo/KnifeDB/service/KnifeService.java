package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.AccessoryComment;
import com.chefknifestogo.KnifeDB.bean.Knife;
import com.chefknifestogo.KnifeDB.bean.KnifeComment;
import com.chefknifestogo.KnifeDB.dao.KnifeCommentDao;
import com.chefknifestogo.KnifeDB.dao.KnifeDao;
import com.chefknifestogo.KnifeDB.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnifeService {

    @Autowired
    private KnifeDao knifeDao;

    @Autowired
    private KnifeCommentDao knifeCommentDao;
    public Response save(Knife knife) {

        try {
            knife.getImage().forEach((image) -> {
                image.setKnife(knife);
            });

            knifeDao.save(knife);
            return new Response(true);

        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false);
        }
    }

    public Response updateKnife(Knife knife){
        try{
            Knife knife1=knifeDao.findById(knife.getId()).get();
            knife.setComment(knife1.getComment());
            knife.setImage(knife1.getImage());
            knife1=knife;
            knifeDao.save(knife1);

            return new Response(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new Response(false);
        }
    }

    public Knife getKnifeById(Integer id){
        return knifeDao.findById(id).get();
    }

    public Response addComment(int id, KnifeComment knifeComment){
        try{
            knifeComment.setKnife(knifeDao.getById(id));
            knifeCommentDao.save(knifeComment);

            return new Response(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new Response(false);
        }

    }
    public List<Knife> findByBrand(String brand){
            return knifeDao.findByBrand(brand);}

    public List<Knife> findByKnifeType(String knifeType){
        return knifeDao.findByKnifeType(knifeType);
    }
    public List<Knife> findBySteel(String steel)
    {
        return knifeDao.findBySteel(steel);
    }
    public List<Knife> findBySupplier(String steel)
    {
        return knifeDao.findBySupplier(steel);
    }
    public List<Knife> getAll(){return knifeDao.findAll();}

    //getbyname
    //getbysteel
    //getbybrand
    //getbytype

}
