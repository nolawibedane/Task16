import java.util.List;

public class Customer {
    String name; // Declare a string variable to store the customer's name
    String city; // Declare a string variable to store the customer's city
    String suburbAndStreet; // Declare a string variable to store the customer's suburb & street
    String emailAddress; // Declare a string variable to store the customer's email address
    String phoneNumber; // Declare a string variable to store the customer's phone number
    List<FoodItem> foodItems; // Use List to store food items
    String specialInstruct; // Declare a string variable to store the customer's special instructions

    // Constructor to create a Customer object with provided details
    public Customer(String name, String city, String suburbAndStreet, String emailAddress, String phoneNumber,
            List<FoodItem> foodItems, String specialInstruct) {
        this.name = name; // Assign the provided name to the "name" property
        this.city = city; // Assign the provided city to the "city" property
        this.suburbAndStreet = suburbAndStreet; // Assign the provided suburb & street to the "suburbAndStreet" property
        this.emailAddress = emailAddress; // Assign the provided email address to the "emailAddress" property
        this.phoneNumber = phoneNumber; // Assign the provided phone number to the "phoneNumber" property
        this.foodItems = foodItems; // Assign the provided food items to the "foodItems" property
        this.specialInstruct = specialInstruct; // Assign the provided special instructions to the "specialInstruct" property
    }
}
