package com.LLD.MovieBookingFinal.Entity;

import java.util.Objects;
import java.util.UUID;

public class Seat extends Entity{
    int rowId;
    int colId;

    public Seat(int rowId, int colId) {
        super(UUID.randomUUID().toString());
        
        this.rowId = rowId;
        this.colId = colId;
    }

    @Override
    public final boolean equals(Object obj){
        if(obj instanceof Seat) {
            Seat s = (Seat) obj;
            if(this.getId()==null){
                return s.getId()==null;
            }
            return this.getId().equals(s.getId());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.getId().hashCode();
    }
}