package com.LLD.AmazonLocker.Entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAddress implements DestinationDetails{
    String flatNo;
    String streetNo;
    String locality;
    String pincode;
    String city;

    @Override
    public String getFullAddress() {
        String deliverableLocation = new StringBuilder(flatNo).append(", ")
                .append(streetNo).append(", ")
                .append(locality).append(", ")
                .append(pincode).append(", ")
                .append(city).toString();
        return deliverableLocation;
    }
}
