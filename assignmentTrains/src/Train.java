import java.util.ArrayList;

public class Train {
    private int ID;
    private int capacity;
    private String departure;
    private String destination;
    private ArrayList<Passenger> passengers;

    @Override
    public String toString() {
        return "\nTrain information:\n" +
                "ID: " + ID + "\n" +
                "Capacity: " + capacity + "\n" +
                "Route: " +  getRoute() + "\n";
    }

    public Train(int ID, int capacity, String departure, String destination) {
        this.ID = ID;
        this.capacity = capacity;
        this.departure = departure;
        this.destination = destination;
        passengers = new ArrayList<Passenger>();
    }

    public int getID() {
        return ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getRoute() {
        return departure + " - " + destination;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPassenger(int ID, String fullName, int age) {
        if (passengers.size() < capacity) {
            passengers.add(new Passenger(ID, fullName, age));
            System.out.println("\nПассажир успешно добавлен!");
        }
        else {
            System.out.println("В поезде недостаточно места");
        }
    }
}
