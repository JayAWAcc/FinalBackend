package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressDao extends JpaRepository<ShippingAddress,Integer> {
}
