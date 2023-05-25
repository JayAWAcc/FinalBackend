package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.AccessoryComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoryCommentDao extends JpaRepository<AccessoryComment, Integer> {
    List<AccessoryComment> findAccessoryCommentsByAccessory_Id(int id);
    List<AccessoryComment> findByAccessoryIdAndUserid(int accessoryId, int userid);
}
