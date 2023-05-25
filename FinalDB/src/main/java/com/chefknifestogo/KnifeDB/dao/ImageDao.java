package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.Image;
import com.chefknifestogo.KnifeDB.bean.Knife;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image,Integer> {
    List<Image> findByKnife(Knife knife);
}
