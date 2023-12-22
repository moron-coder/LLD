package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Dao.ChefDao;
import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CookService {
    @Autowired
    private ChefDao chefDao;
    private static CookService instance;

    private CookService(){}

    public static CookService getInstance(){
        if(instance==null){
            instance = new CookService();
        }
        return instance;
    }

    public void assignOrderItems(Set<OrderItem> orderItems){
        for(OrderItem item:orderItems){
            if(!chefDao.getItemChefsMap().containsKey(item)){
                System.out.println("Unknown item "+item);
            }else{
                Queue<Chef> chefQueue = chefDao.getItemChefsMap().get(item);
                if(chefQueue.isEmpty()){
                    System.out.println("No chef left to cook item "+item);
                }else{
                    Chef chef = chefQueue.poll();
                    chef.addOrderItem(item);
                    chefQueue.add(chef);
                }
            }
        }
    }
}
