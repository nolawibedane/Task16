import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create lists to store customer, driver, and restaurant information
        List<Customer> customers = new ArrayList<>();
        List<Driver> drivers = readDriversFromFile("drivers.txt");
        List<Restaurant> restaurants = new ArrayList<>(); // List to store restaurants

        Scanner scanner = new Scanner(System.in);

        // Capture restaurant details
        System.out.println("Enter restaurant details:");
        System.out.print("Restaurant Name: ");
        String restaurantName = scanner.nextLine();
        System.out.print("Restaurant Location: ");
        String restaurantLocation = scanner.nextLine();
        System.out.print("Restaurant Phone Number: ");
        String restaurantPhoneNumber = scanner.nextLine();

        // Create a Restaurant object with the captured details and add it to the list
        Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantPhoneNumber);
        restaurants.add(restaurant);

        System.out.println("Enter customer details:");
        Customer customer = captureCustomerDetails(scanner);
        customers.add(customer);

        scanner.close();

        try {
            PrintWriter writer = new PrintWriter("invoice.txt");

            // Iterate through each customer
            for (Customer cust : customers) {
                // Generate a random 4-digit order number
                int orderNumber = generateRandomOrderNumber();

                // Find the best driver for the current customer using the method
                Driver bestDriver = findBestDriver(cust, drivers);

                if (bestDriver != null) {
                    writer.println("Order Number: " + orderNumber);
                    writer.println("Customer: " + cust.name);
                    writer.println("Email Address: " + cust.emailAddress);
                    writer.println("Phone Number: " + cust.phoneNumber);
                    writer.println("Location: " + cust.city);
                    writer.println("");
                    writer.println(
                            "You have ordered the following from " + restaurantName + " in " + restaurantLocation);
                    writer.println("");

                    // Print food items with quantity, name, price, and total
                    writer.println("Food Items:");
                    double totalPrice = 0.0; // To keep track of the total price
                    for (FoodItem item : cust.foodItems) {
                        double itemTotal = item.getQuantity() * item.getPrice();
                        writer.println(
                                item.getQuantity() + " " + item.getName() + " " + item.getPrice() + " (Total: "
                                        + itemTotal + ")");
                        totalPrice += itemTotal; // Add the item's total to the overall total
                    }

                    writer.println("");
                    writer.println("Total Price of Food Items: " + totalPrice);
                    writer.println("");
                    writer.println("Special Instructions: " + cust.specialInstruct);
                    writer.println("");
                    writer.println(
                            bestDriver.name
                                    + " is the nearest to you, so they will be delivering your order to you at: "
                                    + cust.suburbAndStreet);
                    writer.println("");
                    writer.println(
                            "If you need to contact the restaurant, their phone number " + restaurantPhoneNumber);
                    bestDriver.load++;
                } else {
                    // If no suitable driver was found, write an appropriate message to invoice.txt
                    writer.println("Order Number: " + orderNumber);
                    writer.println("Customer: " + cust.name
                            + ", Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                }
            }

            // Close the writer after writing to invoice.txt
            writer.close();
            System.out.println("Matches have been written to invoice.txt.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while writing to invoice.txt.");
        }
    }

    // Method to capture customer details with exception handling
    private static Customer captureCustomerDetails(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Suburb & Street: ");
        String suburbAndStreet = scanner.nextLine();
        System.out.print("Email Address: ");
        String emailAddress = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        List<FoodItem> foodItems = new ArrayList<>();

        String anotherItem = "yes";

        while (anotherItem.equalsIgnoreCase("yes")) {
            System.out.print("Your Food Order: ");
            String order = scanner.nextLine();
            int quantity = 0;
            double price = 0.0;

            try {
                System.out.print("How Many Would You Like: ");
                quantity = scanner.nextInt();
                System.out.print("How Much Does Each Cost: ");
                price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.err.println("Invalid input. Please enter valid quantity and price.");
                System.exit(1); // Exit the program due to invalid input
            }

            foodItems.add(new FoodItem(order, quantity, price));

            System.out.print("Add another food item? (yes/no): ");
            anotherItem = scanner.nextLine();
        }

        System.out.print("Special Instructions: ");
        String specialInstruct = scanner.nextLine();

        // Create the Customer object with the collected details
        return new Customer(name, city, suburbAndStreet, emailAddress, phoneNumber, foodItems, specialInstruct);
    }

    // Method to read driver details from a file with exception handling
    private static List<Driver> readDriversFromFile(String filename) {
        List<Driver> drivers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String name = parts[0];
                    String location = parts[1];
                    int load = Integer.parseInt(parts[2]);
                    drivers.add(new Driver(name, location, load));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while reading driver data from the file.");
        }

        return drivers;
    }

    // Method to find the best driver for a customer
    private static Driver findBestDriver(Customer customer, List<Driver> drivers) {
        Driver bestDriver = null;
        int smallestLoad = Integer.MAX_VALUE;

        // Iterate through each driver
        for (Driver driver : drivers) {
            // Check if the driver's location matches the customer's city and the load is
            // smaller
            if (customer.city.equalsIgnoreCase(driver.location) && driver.load < smallestLoad) {
                smallestLoad = driver.load;
                bestDriver = driver;
            }
        }

        return bestDriver;
    }

    // Method to generate a random 4-digit order number with exception handling
    private static int generateRandomOrderNumber() {
        try {
            // Generate a random number between 1000 and 9999
            return new Random().nextInt(9000) + 1000;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred while generating the order number.");
            return -1; // A fallback value indicating an error
        }
    }
}