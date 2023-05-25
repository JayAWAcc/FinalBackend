package com.chefknifestogo.KnifeDB.controller;

import com.chefknifestogo.KnifeDB.bean.Order;
import com.chefknifestogo.KnifeDB.http.Response;
import com.chefknifestogo.KnifeDB.service.AuthService;
import com.chefknifestogo.KnifeDB.service.OrderService;
import com.chefknifestogo.KnifeDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthService authService;

    @GetMapping
    public List<Order> getAll(){return  orderService.getAll();}

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id){return orderService.getOrderById(id);}

    @GetMapping("userId/{userId}")
    public List<Order> getByUserId(@PathVariable int userId){
        return orderService.getOrderByUserId(userId);}

    @GetMapping("hasPurchasedAccessory/{accessoryId}")
    public boolean hasPurchasedAccessory(@PathVariable int accessoryId, Authentication authentication){

        int userId=authService.getUserId(authentication);

        return orderService.hasPurchasedAccessory(userId,accessoryId);
    }

    @GetMapping("hasPurchasedKnife/{knifeId}")
    public boolean hasPurchasedKnife(@PathVariable int knifeId, Authentication authentication){

        int userId=authService.getUserId(authentication);

        return orderService.hasPurchasedKnife(userId,knifeId);
    }
    @PostMapping
    public Response save(@RequestBody Order order, Authentication authentication){
        Response response= orderService.save(order,authentication);
         return response;
    }
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id)
    {
        return new Response(true, "Order: "+ id + "is fake deleted!");
    }

    @PutMapping
    public Response updateOrder(@RequestBody Order order){return orderService.updateOrder(order);}
}
