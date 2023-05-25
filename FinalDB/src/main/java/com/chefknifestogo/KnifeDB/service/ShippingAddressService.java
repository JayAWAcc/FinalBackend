package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.ShippingAddress;
import com.chefknifestogo.KnifeDB.dao.ShippingAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressService {

    @Autowired
    private ShippingAddressDao shippingAddressDao;

}
