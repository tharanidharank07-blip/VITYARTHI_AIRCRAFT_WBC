## Problem Statement
The inability to quickly and accurately calculate the total takeoff mass and the precise Center of Gravity (CG) location poses a significant safety risk in aviation. This project solves this by providing a reliable, modular tool to perform these critical calculations, ensuring regulatory compliance and flight stability before takeoff.

## Scope of the Project
The scope is limited to calculating the longitudinal (fore and aft) CG Arm and the Total Takeoff Mass. It uses fundamental physics formulas (Moment = Mass * Arm) and validates the output against a fixed Maximum Takeoff Weight (MaxTOW) limit.

## Target Users
* Student Aerospace Engineers
* Flight Planners and Ground Operations Crew
* General Aviation Pilots

## High-Level Features
1.  **Fixed Aircraft Data Input:** Stores permanent empty aircraft specifications (mass, arm, MaxTOW).
2.  **Dynamic Load Input:** Accepts multiple user-defined payload inputs (mass and arm).
3.  **Core Calculation:** Computes Total Moment and Final CG Arm.
4.  **Safety Validation:** Alerts the user if the calculated Total Mass exceeds the MaxTOW.
