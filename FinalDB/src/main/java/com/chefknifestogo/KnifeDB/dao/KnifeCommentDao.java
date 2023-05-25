package com.chefknifestogo.KnifeDB.dao;

import com.chefknifestogo.KnifeDB.bean.Knife;
import com.chefknifestogo.KnifeDB.bean.KnifeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnifeCommentDao extends JpaRepository<KnifeComment,Integer> {
    List<KnifeComment> findKnifeCommentsByKnifeId(int id);
    List<KnifeComment> findByKnifeIdAndUserid(int knifeId,int userid);
}
