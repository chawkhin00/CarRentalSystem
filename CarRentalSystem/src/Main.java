import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
       private static final List<Vehicle> vehicles = new ArrayList<>();
  
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Information System!");

        while (true) {
          System.out.println("\nSelect a vehicle type to create:");
          System.out.println("1. Car");
          System.out.println("2. Motorcycle");
          System.out.println("3. Truck");
          System.out.println("4. Display Vehicle Details");
          System.out.println("5. Exit");
          System.out.print("Enter your choice: ");
          
          int choice = getIntInput(scanner);
          
           if (choice == 5) {
                       System.out.println("Exiting the program. Goodbye!");
                       break;
                   } else if (choice == 4) {
                       displayVehicleDetails();
                   } else {
                       Vehicle vehicle = createVehicle(choice, scanner);
                       if (vehicle != null) {
                           vehicles.add(vehicle);
                           System.out.println("Vehicle created successfully!");
                       }
                   }
               }
           }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    private static Vehicle createVehicle(int choice, Scanner scanner) {
        System.out.print("Enter brand: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();
        System.out.print("Enter year: ");
        int year = getIntInput(scanner);

        switch (choice) {
            case 1:
                Car car = new Car(make, model, year);
                System.out.print("Enter number of doors: ");
                car.setNumDoors(getIntInput(scanner));
                System.out.print("Enter fuel type (petrol, diesel, electric): ");
                car.setFuelType(scanner.next());
                return car;
            case 2:
                Motorcycle motorcycle = new Motorcycle(make, model, year);
                System.out.print("Enter number of wheels: ");
                motorcycle.setNumWheels(getIntInput(scanner));
                System.out.print("Enter motorcycle type (sport, cruiser, off-road): ");
                motorcycle.setMotorcycleType(scanner.next());
                return motorcycle;
            case 3:
                Truck truck = new Truck(make, model, year);
                System.out.print("Enter cargo capacity (in tons): ");
                truck.setCargoCapacity(scanner.nextDouble());
                System.out.print("Enter transmission type (manual, automatic): ");
                truck.setTransmissionType(scanner.next());
                return truck;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                return null;
        }
    }

  private static void displayVehicleDetails() {
      if (vehicles.isEmpty()) {
          System.out.println("No vehicles created yet.");
      } else {
          System.out.println("\nVehicle Details:");
          for (int i = 0; i < vehicles.size(); i++) {
              System.out.println("\nVehicle " + (i + 1) + ":");
              displayVehicleDetails(vehicles.get(i));
          }
      }
  }

    private static void displayVehicleDetails(Vehicle vehicle) {
        if (vehicle != null) {
            // System.out.println("\nVehicle Details:");
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Year: " + vehicle.getYear());

            if (vehicle instanceof CarVehicle) {
                CarVehicle car = (CarVehicle) vehicle;
                System.out.println("Number of Doors: " + car.getNumDoors());
                System.out.println("Fuel Type : " + car.getFuelType());
            }

            if (vehicle instanceof MotorVehicle) {
                MotorVehicle motorcycle = (MotorVehicle) vehicle;
                System.out.println("Number of Wheels: " + motorcycle.getNumWheels());
                System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
            }

            if (vehicle instanceof TruckVehicle) {
                TruckVehicle truck = (TruckVehicle) vehicle;
                System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
                System.out.println("Transmission Type: " + truck.getTransmissionType());
            }
        }
    }
}