package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.AccessoryType;
import com.chefknifestogo.KnifeDB.dao.AccessoryTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryTypeService {
    @Autowired
    private AccessoryTypeDao accessoryTypeDao;

    public AccessoryType getTypeById(Integer id)
    {
        return accessoryTypeDao.findById(id).get();
    }
    public List<AccessoryType> getAll(){return accessoryTypeDao.findAll();}
}
