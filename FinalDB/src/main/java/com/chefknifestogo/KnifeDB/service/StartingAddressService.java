package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.StartingAddress;
import com.chefknifestogo.KnifeDB.dao.StartingAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartingAddressService {

    @Autowired
    private StartingAddressDao startingAddressDao;

    private StartingAddress getStartingAddressByOrderId(int id){
        return startingAddressDao.getById(id);
    }
}
