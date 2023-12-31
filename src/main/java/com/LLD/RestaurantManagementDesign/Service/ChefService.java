package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Dao.ChefDao;
import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.Menu;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;
import com.LLD.RestaurantManagementDesign.Enums.OrderItemStatus;
import com.LLD.RestaurantManagementDesign.Factory.MenuItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class ChefService {
    private static ChefService instance;

    private ChefService(){}

    public static ChefService getInstance(){
        if(instance==null){
            instance = new ChefService();
        }
        return instance;
    }

    public void handleOrderItemCooked(OrderItem orderItem){
        Chef chef = orderItem.getChef();
        if(chef==null){
            System.out.println("No chef was assigned on "+orderItem);
            return;
        }
//        System.out.println(" 1) orderItems of chef : "+chef.getOrderItems());
        System.out.println(orderItem.getChef()+" cooked "+orderItem.getMenuItem());
        orderItem.setStatus(OrderItemStatus.COOKED);
        chef.getOrderItems().remove(orderItem);
//        System.out.println(" 2) orderItems of chef : "+chef.getOrderItems());

        WaiterService waiterService = WaiterService.getInstance();
        waiterService.handleOrderItemCooked(orderItem);
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

        ChefDao chefDao = ChefDao.getInstance();
        for(MenuItem item:menuItemsToAdd){
            Queue<Chef> chefQueue = chefDao.getItemChefsMap().get(item);
            if(CollectionUtils.isEmpty(chefQueue)){
                chefQueue = new LinkedList<>();
            }
            chefQueue.add(chef);
            chefDao.getItemChefsMap().put(item,chefQueue);
        }
        chefDao.getChefs().add(chef);
        return chef;
    }

    public void assignOrderItems(Set<OrderItem> orderItems){
        ChefDao chefDao = ChefDao.getInstance();
        for(OrderItem item:orderItems){
            HashMap<MenuItem,Queue<Chef>> mp = chefDao.getItemChefsMap();
            if(!mp.containsKey(item.getMenuItem())){
                System.out.println("-> Unknown item "+item);
            }else{
                Queue<Chef> chefQueue = chefDao.getItemChefsMap().get(item.getMenuItem());
                if(CollectionUtils.isEmpty(chefQueue) || chefQueue.peek()==null){
                    System.out.println("No chef left to cook item "+item);
                }else{
                    Chef chef = chefQueue.poll();
                    item.setStatus(OrderItemStatus.COOKING_IN_PROGRESS);
                    chef.addOrderItem(item);
                    System.out.println(chef+" is cooking "+item);
                    chefQueue.add(chef);
                }
            }
        }
    }


}
