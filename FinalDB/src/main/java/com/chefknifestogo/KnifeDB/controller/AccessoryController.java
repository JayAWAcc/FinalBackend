package com.chefknifestogo.KnifeDB.controller;

import com.chefknifestogo.KnifeDB.bean.Accessory;
import com.chefknifestogo.KnifeDB.bean.AccessoryComment;
import com.chefknifestogo.KnifeDB.dao.AccessoryCommentDao;
import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.service.AccessoryCommentService;
import com.chefknifestogo.KnifeDB.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@RequestMapping("/accessories")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private AccessoryCommentService accessoryCommentService;
    @Autowired
    private AccessoryCommentDao accessoryCommentDao;

    @PutMapping
    public Response updateAccessory(@RequestBody Accessory accessory){
        return accessoryService.updateAccessory(accessory);
    }
    @GetMapping
    public List<Accessory> getAll(){return accessoryService.getAll();}

    @PostMapping("/comment/{id}")
    public Response addComment(@PathVariable int id, @RequestBody AccessoryComment comment){
    return accessoryService.addComment(id,comment);
    }

    @GetMapping("/comment/hasCommented/{accessoryId}")
    public boolean haveCommented(@PathVariable int accessoryId, Authentication authentication)
    {
        return accessoryCommentService.haveCommented(accessoryId, authentication);
    }

    @GetMapping ("/comment/average_rate/{id}")
    public float getAverageReview(@PathVariable int id)
    {
        return accessoryCommentService.getAverageRating(id);
    }

    @GetMapping("/{id}")
    public Accessory getById(@PathVariable int id){return accessoryService.getAccessoryById(id);}

    @GetMapping("/comment/{id}")
    public List<AccessoryComment> getComment(@PathVariable int id){
        return accessoryCommentDao.findAccessoryCommentsByAccessory_Id(id);
    }
    @PostMapping
    public void save(@RequestBody Accessory accessory){
        accessoryService.save(accessory);
    }

}
