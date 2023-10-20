class Customer {
    String name; // Declare a string variable to store the customer's name
    String city; // Declare a string variable to store the customer's city
    String suburbAndStreet; // Declare a string variable to store the customer's suburb & street
    String emailAddress; // Declare a string variable to store the customer's email address
    String phoneNumber; // Declare a string variable to store the customer's phone number
    String foodOrder;
    Integer quantity;
    Double price;
    String specialInstruct;

    // Constructor to create a Customer object with provided details
    public Customer(String name, String city, String suburbAndStreet, String emailAddress, String phoneNumber,
            String foodOrder, int quantity, double price, String specialInstruct) {
        this.name = name; // Assign the provided name to the "name" property
        this.city = city; // Assign the provided city to the "city" property
        this.suburbAndStreet = suburbAndStreet; // Assign the provided suburb & street to the "suburbAndStreet" property
        this.emailAddress = emailAddress; // Assign the provided email address to the "emailAddress" property
        this.phoneNumber = phoneNumber; // Assign the provided phone number to the "phoneNumber" property
        this.foodOrder = foodOrder;
        this.quantity = quantity;
        this.price = price;
        this.specialInstruct = specialInstruct;
    }
}
