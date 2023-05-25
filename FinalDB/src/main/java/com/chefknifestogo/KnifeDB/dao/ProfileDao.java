package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository<Profile,Integer> {
}
