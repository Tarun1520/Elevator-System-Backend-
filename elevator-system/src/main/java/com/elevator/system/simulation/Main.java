package com.elevator.system.simulation;

import com.elevator.system.elevator_system.ElevatorManager;
import com.elevator.system.elevator_system.Request;

public class Main {
    public static void main(String[] args) {
        // Initialize ElevatorManager with 3 elevators and starting at floor 0
        ElevatorManager manager = new ElevatorManager(3, 0);

        // Add some requests
        manager.addRequest(new Request(2, 5));
        manager.addRequest(new Request(1, 3));
        manager.addRequest(new Request(0, 1));

        // Process requests
        manager.processRequestQueue();
    }
}
