package com.LLD.GumballMachine;

import com.LLD.GumballMachine.service.MachineService;

public class GumballMachineApplication {
    public static void main(String[] args) {
        MachineService machineService = MachineService.getInstance();


        machineService.insertBalls(2);
        machineService.insertQuarter();
        machineService.insertQuarter();

        machineService.insertBalls(3);
    }
}
