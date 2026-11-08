
import java.util.Scanner;

     // Customer Class
class Customer {
    String name;
    String phone;
    String email;
    String licenseNumber;

    Customer(String name, String phone, String email, String licenseNumber) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("License: " + licenseNumber);
    }
}

// Car Class
class Car {
    int id;
    String name;
    String model;
    double rentPerDay;
    boolean available;

    Car(int id, String name, String model,
        double rentPerDay, boolean available) {

        this.id = id;
        this.name = name;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = available;
    }

    void displayCar() {
        System.out.println(
            id + ". " + name + " " + model
            + " | Rent: Rs. " + rentPerDay
            + " | Status: "
            + (available ? "Available" : "Already Booked")
        );
    }
}

// Main Class
public class CarRentalSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Car[] cars = {
            new Car(1, "Toyota", "Corolla", 5000, true),
            new Car(2, "Honda", "Civic", 7000, false),
            new Car(3, "Suzuki", "Alto", 3000, true),
            new Car(4, "Toyota", "Yaris", 4500, true)
        };

        System.out.println("================================");
        System.out.println("       CAR RENTAL SYSTEM");
        System.out.println("================================");

        // Customer Registration

        System.out.println("\nCUSTOMER REGISTRATION");

        System.out.print("Enter your full name: ");
        String name = input.nextLine();

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();

        System.out.print("Enter email: ");
        String email = input.nextLine();

        System.out.print("Enter driving license number: ");
        String license = input.nextLine();

        Customer customer =
            new Customer(name, phone, email, license);

        System.out.println("\nRegistration Successful!");

        // Display Cars

        System.out.println("\nAVAILABLE CAR LIST");

        for (Car car : cars) {
            car.displayCar();
        }

        // Car Selection

        Car selectedCar = null;

        while (selectedCar == null) {

            System.out.print("\nEnter Car ID to rent: ");
            int choice = input.nextInt();

            boolean found = false;

            for (Car car : cars) {

                if (car.id == choice) {

                    found = true;

                    if (car.available) {

                        selectedCar = car;

                    } else {

                        System.out.println(
                            "Sorry! This car is already booked."
                        );

                        System.out.println(
                            "Please select another available car."
                        );
                    }

                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid Car ID! Try again.");
            }
        }

        // Rental Days

        System.out.print("Enter rental days: ");
        int days = input.nextInt();

        if (days <= 0) {
            System.out.println("Invalid rental days!");
            input.close();
            return;
        }

        // Booking Confirmation

        selectedCar.available = false;

        double totalRent = selectedCar.rentPerDay * days;

        // Final Receipt

        System.out.println("\n================================");
        System.out.println("        BOOKING RECEIPT");
        System.out.println("================================");

        customer.displayCustomer();

        System.out.println("--------------------------------");
        System.out.println("Car: " + selectedCar.name
            + " " + selectedCar.model);

        System.out.println("Rental Days: " + days);

        System.out.println("Daily Rent: Rs. "
            + selectedCar.rentPerDay);

        System.out.println("Total Rent: Rs. " + totalRent);

        System.out.println("Booking Status: Confirmed");

        System.out.println("================================");

        input.close();
    }
}
