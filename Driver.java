import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    // Properties to store driver's name, location, and load
    String name;
    String location;
    int load;

    // Constructor to create a Driver object with provided name, location, and load
    public Driver(String name, String location, int load) {
        this.name = name;
        this.location = location;
        this.load = load;
    }
}
