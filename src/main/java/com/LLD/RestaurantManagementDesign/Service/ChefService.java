package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Dao.ChefDao;
import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.Menu;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;
import com.LLD.RestaurantManagementDesign.Factory.MenuItemFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ChefService {
    @Autowired
    private ChefDao chefDao;
    private static ChefService instance;

    private ChefService(){}

    public static ChefService getInstance(){
        if(instance==null){
            instance = new ChefService();
        }
        return instance;
    }

    public Chef addChef(String name, Set<String> dishes){
        Chef chef = new Chef(String.valueOf(Chef.chefCount),name);
        Chef.chefCount=Chef.chefCount+1;
        Set<MenuItem> menuItemsToAdd = new HashSet<>();
        for(String dish:dishes){
            MenuItem menuItem = MenuItemFactory.getMenuItem(dish,null);
            if(menuItem!=null){
                menuItemsToAdd.add(menuItem);
            }
        }
        chef.addMenuItems(menuItemsToAdd);
        for(MenuItem item:menuItemsToAdd){
            chefDao.getItemChefsMap().get(item).add(chef);
        }
        chefDao.getChefs().add(chef);
        return chef;
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
