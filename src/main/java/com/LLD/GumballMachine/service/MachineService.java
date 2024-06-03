package com.LLD.GumballMachine.service;

import java.util.concurrent.atomic.AtomicInteger;

public class MachineService {

    private static final AtomicInteger ballsCount = new AtomicInteger(0);
    private static final AtomicInteger machineState = new AtomicInteger(1);

    private static MachineService instance;

    public static MachineService getInstance(){
        if(instance==null) {
            instance = new MachineService();
        }
        return instance;
    }

    final static int OUT_OF_GUMBALLS = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int GUMBALL_SOLD = 3;

    public void insertBalls(int ballsCt){
        if(ballsCt<=0){
            System.out.println("Positive number of balls can be inserted");
            return;
        }
        AtomicInteger initCt = ballsCount;
        System.out.println("Trying to insert "+ballsCt+" balls");
        System.out.println(ballsCount.get()+" is current value and "+initCt.get()+" is expected value");
        if(ballsCount.compareAndSet(initCt.get(), initCt.addAndGet(ballsCt))) {
            System.out.println("No race condition");
            if (!machineState.compareAndSet(OUT_OF_GUMBALLS, NO_QUARTER)
                    && !(machineState.get() == NO_QUARTER)) {
                System.out.println("Cannot insert balls at state " + machineState.get());
                ballsCount.set(initCt.get());
            }else{
                System.out.println("Successfully inserted "+ballsCount.get()+" balls");
            }
        }else{
            System.out.println("Race condition!!!");
        }
    }

    public void insertQuarter(){
        if(machineState.compareAndSet(NO_QUARTER,HAS_QUARTER)){
            if(ballsCount.get()==0){
                ejectQuarter();
            }else{
                sold();
            }
        }else{
            System.out.println("Cannot insert quarter at state "+machineState.get());
        }
    }

    private void ejectQuarter(){
        if(machineState.compareAndSet(HAS_QUARTER,NO_QUARTER)){
            System.out.println("Out of gumballs. Reverting back to default state");
        }else{
            System.out.println("Cannot eject quarter at state "+machineState.get());
        }
    }

    private void sold(){
        if(machineState.compareAndSet(HAS_QUARTER, GUMBALL_SOLD)){
            ballsCount.set(ballsCount.get()-1);
            System.out.println("Take a gumball !!!!!!");
            checkOutOfGumballs();
        }else{
            System.out.println("Cannot sell gumballs at state "+machineState.get());
        }
    }

    private void checkOutOfGumballs(){
        if(ballsCount.get()>0){
            System.out.println("    Balls are still left");
            if(machineState.compareAndSet(GUMBALL_SOLD, NO_QUARTER)){

            }else{
                System.out.println("Cannot reset to default state at state "+machineState.get());
            }
            return;
        }
        if(machineState.compareAndSet(GUMBALL_SOLD,OUT_OF_GUMBALLS)){
            System.out.println("Oops!!! out of gumballs");
        }else{
            System.out.println("Cannot sell gumballs at state "+machineState.get());
        }
    }
}
