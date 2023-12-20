package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Dao.ChefDao;
import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;

import java.util.List;
import java.util.Queue;

public class CookService {
    private ChefDao chefDao;
    private WaiterService waiterService;

    public CookService(ChefDao chefDao, WaiterService waiterService){
        this.chefDao = chefDao;
        this.waiterService = waiterService;
    }

    public void assignOrderItems(List<OrderItem> orderItems){
        for(OrderItem item:orderItems){
            if(!chefDao.getItemChefsMap().containsKey(item)){
                System.out.println("Unknown item "+item);
            }else{
                Queue<Chef> chefQueue = chefDao.getItemChefsMap().get(item);
                if(chefQueue.isEmpty()){
                    System.out.println("No chef left to cook item "+item);
                }else{
                    Chef chef = chefQueue.poll();
                    chefDao.getChefOrderItemsMap().get(chef).add(item);
                    chefQueue.add(chef);
                }
            }
        }
    }
}
