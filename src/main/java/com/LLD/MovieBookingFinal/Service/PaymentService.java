package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Utils.Enum;

public class PaymentService {
    private static PaymentService instance;
    private PaymentService(){};
    public synchronized static PaymentService getInstance(){
        if(instance==null){
            instance = new PaymentService();
        }
        return instance;
    }

    public Enum.PaymentStatus makePaymentDummy(Enum.PaymentMode paymentMode){
        return Enum.PaymentStatus.SUCCESS;
    }

}
