package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.Accessory;
import com.chefknifestogo.KnifeDB.bean.AccessoryToType;
import com.chefknifestogo.KnifeDB.bean.Knife;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoryToTypeDao extends JpaRepository<AccessoryToType,Integer> {
    List<Accessory> findAccessoryToTypeByAccessory_Id(int accessoryId);

}
