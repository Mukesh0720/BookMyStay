/**
 * HotelBookingApp is the entry point of the Hotel Booking Management System.
 *
 * This class demonstrates how a Java application starts execution using the
 * main() method and prints output to the console.
 *
 * It also introduces basic object-oriented modeling of rooms using
 * abstraction, inheritance, and polymorphism.
 *
 * @author Mukesh
 * @version 1.0
 */
public class HotelBookingApp {

    /**
     * Main method - Entry point of the application.
     * JVM starts execution from this method.
     *
     * @param args Command line arguments (not used here)
     */
    public static void main(String[] args) {

        // Welcome message (UC1)
        System.out.println("====================================");
        System.out.println(" Welcome to Hotel Booking System ");
        System.out.println(" Version: v1.0 ");
        System.out.println("====================================");

        // UC2: Room Modeling
        System.out.println("\n--- Room Details & Availability ---");

        // Polymorphism (Room reference)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability (simple variables)
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        single.displayDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable + "\n");

        // End message
        System.out.println("Application terminated.");
    }
}