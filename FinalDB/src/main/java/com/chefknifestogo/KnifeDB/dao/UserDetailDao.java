package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.bean.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailDao extends JpaRepository<UserDetail,Integer> {
    UserDetail findByUserId(int userid);
    UserDetail findByUser(User user);
}
