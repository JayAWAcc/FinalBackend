package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.AccessoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoryTypeDao extends JpaRepository<AccessoryType,Integer> {
    List<AccessoryType> findByType(String type);
}
