package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.Knife;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnifeDao extends JpaRepository<Knife, Integer> {
    List<Knife> findByBrand(String brand);
    List<Knife> findByKnifeType(String knifeType);
    List<Knife> findBySteel(String steel);
    List<Knife> findBySupplier(String supplier);
}
