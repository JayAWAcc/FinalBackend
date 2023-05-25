package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.*;
import com.chefknifestogo.KnifeDB.dao.*;
import com.chefknifestogo.KnifeDB.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {



    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccessoryDao accessoryDao;

    @Autowired
    private KnifeDao knifeDao;

    @Autowired
    private AuthService authService;
    @Autowired
    private OrderToAccessoryDao orderToAccessoryDao;
    @Autowired
    private OrderToKnifeDao orderToKnifeDao;


    public List<Order> getAll(){return orderDao.findAll();}


    public boolean hasPurchasedAccessory(int userId, int accessoryId){

        return orderToAccessoryDao.findByOrder_UserIdAndAccessory_Id(userId,accessoryId).size()>0;


    }

    public boolean hasPurchasedKnife(int userId, int knifeId){

        return orderToKnifeDao.findByOrder_UserIdAndAndKnife_Id(userId,knifeId).size()>0;


    }


    public Order getOrderById(Integer id){return orderDao.findById(id).get();}


    public List<Order> getOrderByUserId(Integer userId){
        return orderDao.findByUserId(userId);}

    //@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Response save(Order order, Authentication authentication) {
        try {
            Set<OrderToAccessory> orderToAccessories = order.getAccessoryPurchase();
            orderToAccessories.forEach((orderToAccessory) -> {
                // enrich the product object
                Accessory accessory = accessoryDao.findById(orderToAccessory.getAccessory().getId()).get();
                orderToAccessory.setAccessory(accessory);

                orderToAccessory.setOrder(order);
            });
            Set<OrderToKnife> orderToKnives=order.getKnifePurchase();
            orderToKnives.forEach((orderToKnife) -> {
                // enrich the product object
                Knife knife = knifeDao.findById(orderToKnife.getKnife().getId()).get();

                orderToKnife.setKnife(knife);
                orderToKnife.setOrder(order);
            });
            if(order.getStartingAddress()==null){
                StartingAddress startingAddress=new StartingAddress();
                startingAddress.setAddress1("5970 Executive Dr");
                startingAddress.setAddress2("Suite D");
                startingAddress.setCity("Fitchburg");
                startingAddress.setStates("WI");
                startingAddress.setZip("53719");
                order.setStartingAddress(startingAddress);
            }

            order.setUserId(authService.getUserId(authentication));
            orderDao.save(order);

            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false);
        }
    }

    public void deleteOrderToKnife(List<OrderToKnife> knife) {
        orderToKnifeDao.deleteAll(knife);
    }

    public Response updateOrder(Order order)
    {
        Order od= orderDao.findById(order.getId()).get();
        od.setShippingStatus(order.getShippingStatus());

        orderDao.save(od);
        return new Response(true);

    }
    public void deleteOrderToAccessory(List<OrderToAccessory> accessory) {
        orderToAccessoryDao.deleteAll(accessory);
    }
}
