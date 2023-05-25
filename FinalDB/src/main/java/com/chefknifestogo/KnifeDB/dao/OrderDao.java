package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.Knife;
import com.chefknifestogo.KnifeDB.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);
}
