package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.Image;
import com.chefknifestogo.KnifeDB.bean.Knife;
import com.chefknifestogo.KnifeDB.dao.ImageDao;
import com.chefknifestogo.KnifeDB.dao.KnifeDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class ImageService {
    @Autowired
    private ImageDao imageDao;

    public List<Image> getAll(){return imageDao.findAll();}
    public List<Image> getByKnife(Knife knife){return imageDao.findByKnife(knife);}
}
