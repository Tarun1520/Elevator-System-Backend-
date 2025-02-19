# Elevator System Backend

This project implements the backend logic for a smart **Elevator System**, designed to efficiently manage elevator requests and simulate the movement of elevators in a building. It provides a robust, scalable, and easy-to-understand system to simulate elevator operations such as moving between floors, handling requests, and maintaining the system's state.

### Features:
- **Elevator Request Management**: Allows users to request elevators for specific floors, and handles requests in an optimized order based on the current elevator positions.
- **Multiple Elevators Support**: Simulates a multi-elevator system where multiple elevators can be in operation simultaneously.
- **Real-time Elevator Movement Simulation**: Simulates the movement of elevators between floors, responding to requests from users.
- **Floor Navigation**: Provides the ability to move elevators between floors with appropriate logic for up and down movement.
- **Request Prioritization**: Optimizes the order of elevator requests to improve system efficiency, ensuring the closest elevator is dispatched first.

### Tech Stack:
- **Backend**: Java (Spring Boot)
- **Database**: MongoDB (optional, for tracking requests and elevator data)
- **Other**: REST APIs, Object-Oriented Design (OOD) for system architecture

### Setup:
To get started with the Elevator System Backend project, clone this repository and follow the steps below:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Tarun1520/Elevator-System-Backend-.git
   ```

2. **Install dependencies**:
   Navigate to the project directory and install required dependencies (if applicable).

3. **Run the application**:
   Use the command below to start the backend application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API**:
   The API will be available locally, typically at `http://localhost:8080`.

