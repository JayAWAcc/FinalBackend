package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.OrderToAccessory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderToAccessoryDao extends JpaRepository<OrderToAccessory,Integer> {
    List<OrderToAccessory> findByAccessory_Id(int accessoryId);
    List <OrderToAccessory> findByOrder_UserIdAndAccessory_Id(int userId, int accessoryId);
}
