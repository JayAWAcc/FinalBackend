package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    List<User> findUserByUsername(String username);
}
