# Aircraft Mass & Balance Analyzer (SI Units)

## Project Overview
This project implements a core safety function for flight planning: calculating the total **Takeoff Mass** and the precise **Center of Gravity (CG) location** for a small general aviation aircraft. By using fundamental physics (Moment = Mass * Arm), the tool ensures the aircraft is safe and compliant with mass limits before departure.

## Features
* **Mass & Balance Calculation:** Computes the total mass and total moment of the fully loaded aircraft configuration.
* **Final CG Determination:** Calculates the final CG Arm in **meters (m)**.
* **Safety Validation (Non-Functional Requirement):** Implements a critical check to flag an error if the calculated Total Mass exceeds the fixed Maximum Takeoff Weight (MaxTOW).
* **Modular Design:** Implements Object-Oriented Programming (OOP) principles using five distinct classes (`AirframeData`, `LoadItem`, etc.) to separate data from logic.
* **Robust Input:** Includes basic validation logic to reject non-numeric or invalid (zero/negative) inputs.

## Technologies Used
* **Language:** Java
* **Environment:** Console/Command Line Interface (CLI)
* **Units:** SI Units (Kilograms for Mass, Meters for Arm)

## Run Instructions
This project is a single-file Java application.

1.  **Save the File:** Ensure your source code is saved as **`AircraftBalance.java`**.
2.  **Compile:** Open a terminal and use the Java Compiler (`javac`):
    ```bash
    javac AircraftBalance.java
    ```
3.  **Execute:** Run the compiled class file from the same terminal:
    ```bash
    java AircraftBalance
    ```
4.  **Input:** Follow the on-screen prompts, entering **Mass (kg)** and **Arm (m)** for each load item (fuel, crew, etc.). Type **`end`** when you are finished entering data.

## Testing for Validation (Overweight Check)
To demonstrate the **Error Handling** feature, use the following inputs to purposely exceed the aircraft's fixed mass limit (1338.1 kg). The system should print a **CRITICAL WARNING** message.

| Load Item | Mass (kg) | Arm (m) |
| :--- | :--- | :--- |
| Pilot | 100.0 | 2.15 |
| Fuel | 350.0 | 2.50 |
| Cargo | 150.0 | 3.00 |
| Finish | end | --- |
