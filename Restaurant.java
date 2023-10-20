public class Restaurant {
    String name; // Declare a string variable to store the restaurant's name
    String location; // Declare a string variable to store the restaurant's location
    String restaurantPhoneNumber; // Add phone number property

    // Constructor to create a Restaurant object with provided name and location
    public Restaurant(String name, String location, String restaurantPhoneNumber) {
        this.name = name; // Assign the provided name to the "name" property
        this.location = location; // Assign the provided location to the "location" property
        this.restaurantPhoneNumber = restaurantPhoneNumber; // Initialize phone number
    }
}