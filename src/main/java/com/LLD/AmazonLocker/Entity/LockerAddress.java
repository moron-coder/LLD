package com.LLD.AmazonLocker.Entity;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class LockerAddress implements DestinationDetails {
    Set<Integer> lockerIds;
    String lockerLocality;

    @Override
    public String getFullAddress() {
        StringBuilder sb = new StringBuilder();
        lockerIds.forEach(lockerId->sb.append(lockerId).append(", "));
        sb.append(lockerLocality);
        return sb.toString();
    }
}
