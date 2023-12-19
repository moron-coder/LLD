package com.LLD.notifyMeDesign.Service;

import com.LLD.notifyMeDesign.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProductService {
    HashMap<String, Integer> productQty;

    public void addProduct(Product product){
        if(!productQty.containsKey(product.getProductIdentifier())){
            productQty.put(product.getProductIdentifier(), 1);
        }else{
            Integer qtyCur = productQty.get(product.getProductIdentifier());
            productQty.put(product.getProductIdentifier(), qtyCur+1);
        }

    }
}
