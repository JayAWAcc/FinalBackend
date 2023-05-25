package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.OrderToKnife;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderToKnifeDao extends JpaRepository<OrderToKnife,Integer> {
    List<OrderToKnife> findByOrder_UserIdAndAndKnife_Id(int userId, int knifeId);
}
