package com.elevator.system.elevator_system;

public class Elevator {
    private int id;
    private int currentFloor;
    private String status;
    private String direction;

    // Constructor with ID, currentFloor, status, and direction
    public Elevator(int id, int currentFloor, String status, String direction) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.status = status;
        this.direction = direction;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    // Method to move elevator to a floor
    public void move(int floor) {
        this.currentFloor = floor;
    }

    @Override
    public String toString() {
        return "Elevator{id=" + id + ", currentFloor=" + currentFloor + ", status='" + status + "', direction='" + direction + "'}";
    }
}
