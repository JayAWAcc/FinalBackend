package com.chefknifestogo.KnifeDB.controller;


import com.chefknifestogo.KnifeDB.bean.AccessoryComment;
import com.chefknifestogo.KnifeDB.bean.Knife;
import com.chefknifestogo.KnifeDB.bean.KnifeComment;
import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.service.KnifeCommentService;
import com.chefknifestogo.KnifeDB.service.KnifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("/knives")
public class KnifeController {
    @Autowired
    private KnifeService knifeService;

    @Autowired
    private KnifeCommentService knifeCommentService;

    @GetMapping
    public List<Knife> getAll(){
        return knifeService.getAll();
    }

    @PutMapping
    public Response updateKnife(@RequestBody Knife knife){
        return knifeService.updateKnife(knife);
    }

    @GetMapping("/brand/{brandName}")
    public List<Knife> findByBrand(@PathVariable String brandName){
        return knifeService.findByBrand(brandName);
    }
    @GetMapping("/knifetype/{type}")
    public List<Knife> findByKnifeType(@PathVariable String type){
        return knifeService.findByKnifeType(type);
    }

    @GetMapping("/steel/{steel}")
    public List<Knife> findBySteel(@PathVariable String steel){
        return knifeService.findBySteel(steel);
    }

    @GetMapping("/supplier/{supplier}")
    public List<Knife> findBySupplier(@PathVariable String supplier){
        return knifeService.findBySupplier(supplier);
    }

    @GetMapping("/{id}")
    public Knife getKnifeById(@PathVariable int id){
        return knifeService.getKnifeById(id);
    }

    @GetMapping("/comment/{id}")
    public List<KnifeComment> getKnifeCommentById(@PathVariable int id)
    {
        return knifeCommentService.getCommentsByKnifeId(id);
    }

    @GetMapping("/comment/hasCommented/{knifeId}")
    public boolean haveCommented(@PathVariable int knifeId, Authentication authentication)
    {
        return knifeCommentService.haveCommented(knifeId, authentication);
    }
    @GetMapping ("/comment/average_rate/{id}")
    public float getAverageReview(@PathVariable int id)
    {
        return knifeCommentService.getAverageRating(id);
    }

    @PostMapping("/comment/{id}")
    public Response addComment(@PathVariable int id, @RequestBody KnifeComment knifeComment){
        return knifeService.addComment(id,knifeComment);
    }


    @PostMapping
    public Response save(@RequestBody Knife knife) {
        System.out.println("Saved"+ knife);
        return knifeService.save(knife);
    }

    //getbyname
    //getbysteel
    //getbybrand
    //getbytype

}
