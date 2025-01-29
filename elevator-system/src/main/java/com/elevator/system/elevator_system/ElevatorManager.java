package com.elevator.system.elevator_system;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ElevatorManager {

    private List<Elevator> elevators;
    private Queue<Request> requestQueue;

    public ElevatorManager() {
        this(3, 0); // Default 3 elevators starting at floor 0 (ground floor)
    }

    public ElevatorManager(int numberOfElevators, int initialFloor) {
        elevators = new ArrayList<>();
        requestQueue = new LinkedList<>();
        for (int i = 1; i <= numberOfElevators; i++) {
            elevators.add(new Elevator(i, initialFloor, "idle", "up"));
        }
    }

    public void assignElevatorToRequest(Request request) {
        if (elevators.isEmpty()) {
            System.out.println("No elevators available.");
            return;
        }

        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        // Find the closest elevator to the source floor
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - request.getSourceFloor());
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }

        // Move the closest elevator to the source floor
        if (closestElevator != null) {
            closestElevator.move(request.getSourceFloor());  // Move elevator to the source floor
            System.out.println("Elevator " + closestElevator.getId() + " is assigned to request from floor " + request.getSourceFloor() + " to " + request.getDestinationFloor());
            System.out.println("Elevator " + closestElevator.getId() + " moved to source floor " + request.getSourceFloor());
            closestElevator.move(request.getDestinationFloor());  // Move elevator to the destination floor
            System.out.println("Elevator " + closestElevator.getId() + " moved to destination floor " + request.getDestinationFloor());
        }
    }

    public void processRequestQueue() {
        while (!requestQueue.isEmpty()) {
            Request request = requestQueue.poll();
            assignElevatorToRequest(request);
        }
    }

    public void addRequest(Request request) {
        if (request != null) {
            requestQueue.add(request);
        } else {
            System.out.println("Invalid request.");
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    // Emergency stop for a specific elevator
    public void emergencyStop(int elevatorId) {
        Elevator elevator = findElevatorById(elevatorId);
        if (elevator != null) {
            elevator.setStatus("stopped");
            System.out.println("Emergency stop activated for Elevator " + elevatorId + ". Elevator is now stopped.");
        } else {
            System.out.println("Elevator " + elevatorId + " not found.");
        }
    }

    // Reset a specific elevator to the ground floor (0)
    public void resetElevator(int elevatorId) {
        Elevator elevator = findElevatorById(elevatorId);
        if (elevator != null) {
            elevator.setCurrentFloor(0);  // Reset to the ground floor
            elevator.setStatus("idle");
            elevator.setDirection("up");
            System.out.println("Elevator " + elevatorId + " has been reset to the ground floor and is now idle.");
        } else {
            System.out.println("Elevator " + elevatorId + " not found.");
        }
    }

    // Factory reset: Reset all elevators to the ground floor (0)
    public void factoryReset() {
        for (Elevator elevator : elevators) {
            elevator.setCurrentFloor(0);  // Reset to the ground floor
            elevator.setStatus("idle");
            elevator.setDirection("up");
            System.out.println("Elevator " + elevator.getId() + " has been reset to the ground floor and is now idle.");
        }
        System.out.println("Factory reset completed. All elevators have been reset to the ground floor.");
    }

    private Elevator findElevatorById(int elevatorId) {
        for (Elevator elevator : elevators) {
            if (elevator.getId() == elevatorId) {
                return elevator;
            }
        }
        return null;
    }
}
