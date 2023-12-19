package com.LLD.RestaurantManagementDesign.Entity;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class Chef extends Person{
    HashMap<Chef, HashSet<MenuItem>> chefItems;

    public Chef(String id, String name) {
        super(id, name);
        chefItems = new HashMap<>();
    }

    public Chef(String id, String name, HashMap<Chef, HashSet<MenuItem>> chefItems) {
        super(id, name);
        this.chefItems = chefItems;
    }
}
