package com.LLD.AmazonLocker.Entity;

import com.LLD.AmazonLocker.Enums;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    Integer id;
    User user;
    DeliveryPerson deliveryPerson;
    List<LineItem> lineItems;
    DestinationDetails destinationDetails;
}
