package com.CompletableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureApplication {
    public static void main(String[] args) {
        int x=10;
        System.out.println("T1 : "+new Date(System.currentTimeMillis()));

        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        for(int i=0;i<3;i++){
            //  these futures are individually running without blocking the main thread
            CompletableFuture<Integer> resFuture = CompletableFuture.supplyAsync(()->dummyDelayedMethod1(1))
                    .thenApply(CompletableFutureApplication::dummyDelayedMethod2);
            futures.add(resFuture);
        }

        List<Integer> futureResults = new ArrayList<>();

        for(CompletableFuture<Integer> future : futures){
            //  results are stored in 'futures'
            //  .get() will block individual thread and while 1 thread is blocked for 3 sec, possibly
            //  some other thread might have also completed its operation
            //  So, total time should not shoot upto 9s. It should be somewhere around 3s (more than 3 because context
            //  switching too will consume some time)
            try {
                Integer futureResult = future.get();
                futureResults.add(futureResult);
            }catch (Exception e){
                System.out.println("Exception while processing future result : "+e.getMessage());
            }
        }

        for(Integer futureResult : futureResults){
            System.out.println("res --> "+futureResult);
        }

        System.out.println("T2 : "+new Date(System.currentTimeMillis()));
    }

    private static int dummyDelayedMethod1(int x){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted exception while sleeping : "+e.getMessage());
        }
        return 1+x;
    }
    private static int dummyDelayedMethod2(int x){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Interrupted exception while sleeping : "+e.getMessage());
        }
        return 10*x;
    }
}
