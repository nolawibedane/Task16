public class Restaurant {
    String name; // Declare a string variable to store the restaurant's name
    String location; // Declare a string variable to store the restaurant's location

    // Constructor to create a Restaurant object with provided name and location
    public Restaurant(String name, String location) {
        this.name = name; // Assign the provided name to the "name" property
        this.location = location; // Assign the provided location to the "location" property
    }

    // Getter method to retrieve the restaurant's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the restaurant's location
    public String getLocation() {
        return location;
    }
}
