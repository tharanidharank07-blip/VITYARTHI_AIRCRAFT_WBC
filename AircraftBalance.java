import java.util.*;

class AirframeData {
    private final double emptyMass;   
    private final double emptyCG;     
    private final double maxTOW;      

    public AirframeData(double eMass, double eCG, double mTOW) {
        this.emptyMass = eMass;
        this.emptyCG = eCG;
        this.maxTOW = mTOW;
    }

    public double getEmptyMass() { return emptyMass; }
    public double getEmptyCG() { return emptyCG; }
    public double getMaxTOW() { return maxTOW; }
    
    public double getEmptyMoment() { return emptyMass * emptyCG; }
}

class LoadItem {
    private double mass; 
    private double arm;  

    public LoadItem(double mass, double arm) {
        this.mass = mass;
        this.arm = arm;
    }

    public double getMass() { return mass; }
    public double getArm() { return arm; }
    
    public double calcMoment() { return mass * arm; }
}

class WBCalculator {

    public void runCalculation(AirframeData aircraft, List<LoadItem> loads) {
        double currentMass = aircraft.getEmptyMass();
        double currentMoment = aircraft.getEmptyMoment();

        System.out.println("\nFlight Load Summary");
        for (LoadItem item : loads) {
            currentMass += item.getMass();
            currentMoment += item.calcMoment();
            System.out.printf("  Load: Mass=%.1f kg, Arm=%.2f m, Moment=%.1f kg*m\n", 
                               item.getMass(), item.getArm(), item.calcMoment());
        }

        double finalCGArm = currentMoment / currentMass;

        System.out.println("\nFinal W/B Results");
        System.out.printf("1. Total Takeoff Mass: %.1f kg\n", currentMass);
        System.out.printf("2. Total Moment: %.1f kg*m\n", currentMoment);
        System.out.printf("3. Final CG Location: %.3f meters\n", finalCGArm);

        if (currentMass > aircraft.getMaxTOW()) {
            System.err.printf("\n10CRITICAL WARNING: MASS LIMIT EXCEEDED\n");
            System.err.printf("Max Allowed Mass: %.1f kg. Current Mass: %.1f kg.\n", 
                               aircraft.getMaxTOW(), currentMass);
        } else {
            System.out.println("\nStatus: Takeoff Mass is safe. (Max: " + aircraft.getMaxTOW() + " kg)");
        }
    }
}

class InputHandler {

    private final Scanner kb = new Scanner(System.in);

    public List<LoadItem> getPayloads() {
        List<LoadItem> loadList = new ArrayList<>();
        System.out.println("\n Enter Payload Data (Mass in kg, Arm in meters)");
        System.out.println("Enter 'end' instead of a mass to finish.");

        while (true) {
            double mass = -1;
            double arm = -1;

            System.out.print("Mass (kg): ");
            if (kb.hasNext("end")) {
                kb.next(); 
                break;
            }

            try {
                mass = kb.nextDouble();
                if (mass <= 0) {
                    System.err.println("Input error: Mass must be positive.");
                    continue; 
                }
            } catch (InputMismatchException e) {
                System.err.println("Input error: Please enter a number for mass.");
                kb.next(); 
                continue;
            }

            try {
                System.out.print("Arm (m): ");
                arm = kb.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Input error: Please enter a number for arm.");
                kb.next(); 
                continue;
            }
            
            loadList.add(new LoadItem(mass, arm));
        }

        return loadList;
    }
}

public class AircraftBalance {
    public static void main(String[] args) {
        
      
        System.out.println("   Aircraft Weight & Balance Analyzer (SI)   ");
        

        double emptyMass_kg = 816.5;    
        double emptyCG_m = 2.286;       
        double maxTOW_kg = 1338.1;      

        AirframeData acSpecs = new AirframeData(emptyMass_kg, emptyCG_m, maxTOW_kg);

        InputHandler handler = new InputHandler();
        List<LoadItem> loads = handler.getPayloads();

        WBCalculator calc = new WBCalculator();
        calc.runCalculation(acSpecs, loads);

        
    }
}
