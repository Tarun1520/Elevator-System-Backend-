package com.elevator.system.elevator_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elevator") // All endpoints will start with /api/elevator
public class ElevatorController {

    private final ElevatorManager elevatorManager;

    @Autowired
    public ElevatorController(ElevatorManager elevatorManager) {
        this.elevatorManager = elevatorManager;
    }

    // Endpoint to add request for the elevator
    @PostMapping("/request")
    public String addRequest(@RequestBody Request request) {
        elevatorManager.addRequest(request);
        return "Request added: " + request;
    }

    // Endpoint to process all queued requests
    @PostMapping("/process")
    public String processRequests() {
        elevatorManager.processRequestQueue();
        return "Requests processed!";
    }

    // Endpoint to get status of all elevators
    @GetMapping("/status")
    public List<Elevator> getElevatorStatus() {
        return elevatorManager.getElevators();
    }

    // Endpoint to fetch the status of a specific elevator
    @GetMapping("/status/{id}")
    public Elevator getElevatorById(@PathVariable int id) {
        if (id < 1 || id >= elevatorManager.getElevators().size()) {
            throw new IllegalArgumentException("Invalid elevator ID");
        }
        return elevatorManager.getElevators().get(id-1);
    }

    // Endpoint to reset an elevator to a specific floor
    @PostMapping("/reset/{id}")
    public String resetElevator(@PathVariable int id, @RequestParam int floor) {
        if (id < 0 || id >= elevatorManager.getElevators().size()) {
            throw new IllegalArgumentException("Invalid elevator ID");
        }
        elevatorManager.resetElevator(id);
        return "Elevator " + id + " reset to floor " + floor;
    }

    // Endpoint to stop an elevator (EMERGENCY STOP)
    @PostMapping("/emergency-stop/{id}")
    public String emergencyStop(@PathVariable int id) {
        if (id < 0 || id >= elevatorManager.getElevators().size()) {
            throw new IllegalArgumentException("Invalid elevator ID");
        }
        elevatorManager.emergencyStop(id);
        return "Elevator " + id + " stopped!";
    }

    // Endpoint to restart an elevator that was stopped
    @PostMapping("/restart/{id}")
    public String restartElevator(@PathVariable int id) {
        if (id < 0 || id >= elevatorManager.getElevators().size()) {
            throw new IllegalArgumentException("Invalid elevator ID");
        }
        Elevator elevator = elevatorManager.getElevators().get(id);
        if ("stopped".equals(elevator.getStatus())) {
            elevator.setStatus("idle");
            return "Elevator " + id + " restarted!";
        } else {
            return "Elevator " + id + " is not stopped";
        }
    }

    // Endpoint for factory reset (resets all elevators to ground floor)
    @PostMapping("/factory-reset")
    public String factoryReset() {
        elevatorManager.factoryReset();
        return "Factory reset completed. All elevators have been reset to the ground floor.";
    }
}
