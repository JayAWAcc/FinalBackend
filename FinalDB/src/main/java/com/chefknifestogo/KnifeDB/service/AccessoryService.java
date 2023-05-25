package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.Accessory;
import com.chefknifestogo.KnifeDB.bean.AccessoryType;
import com.chefknifestogo.KnifeDB.bean.AccessoryComment;
import com.chefknifestogo.KnifeDB.dao.AccessoryCommentDao;
import com.chefknifestogo.KnifeDB.dao.AccessoryDao;
import com.chefknifestogo.KnifeDB.dao.AccessoryToTypeDao;
import com.chefknifestogo.KnifeDB.dao.AccessoryTypeDao;
import com.chefknifestogo.KnifeDB.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryDao accessoryDao;

    @Autowired
    private AccessoryCommentDao accessoryCommentDao;
    @Autowired
    private AccessoryTypeDao accessoryTypeDao;

    @Autowired
    private AccessoryToTypeDao accessoryToTypeDao;

    public List<Accessory> getAll(){return accessoryDao.findAll();}

    public Accessory getAccessoryById(Integer id){return  accessoryDao.findById(id).get();}

    public Response addComment(int id, AccessoryComment comment){
        try{
            comment.setAccessory(getAccessoryById(id));
            accessoryCommentDao.save(comment);

            return new Response(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new Response(false);
        }

    }

    public Response updateAccessory(Accessory accessory){
        try{
            Accessory accessory1=accessoryDao.findById(accessory.getId()).get();
            accessory.setComment(accessory1.getComment());
            accessory.setType(accessory1.getType());
            accessory1=accessory;
            accessoryDao.save(accessory1);

            return new Response(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new Response(false);

        }

    }
    public void save(Accessory accessory){

        accessory.getType().forEach((type)->{


            if(accessoryTypeDao.findByType(type.getType().getType()).size()==0)
            {
                AccessoryType accessoryType= new AccessoryType(type.getType().getType());
                accessoryTypeDao.save(accessoryType);
                accessoryType=accessoryTypeDao.findByType(type.getType().getType()).get(0);
                type.setType(accessoryType);
                type.setAccessory(accessory);

            }
            else{
                AccessoryType accessoryType=accessoryTypeDao.findByType(type.getType().getType()).get(0);
                type.setType(accessoryType);
                type.setAccessory(accessory);

            }

        });
        accessoryDao.save(accessory);
    }
}
