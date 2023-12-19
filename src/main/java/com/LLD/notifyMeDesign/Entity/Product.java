package com.LLD.notifyMeDesign.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Product {
    //  Same as editor
    String name;
    String productIdentifier;
    ProductEventManager productEventManager;

    public Product(String name, String productIdentifier){
        this.name = name;
        this.productIdentifier = productIdentifier;
    }
}
