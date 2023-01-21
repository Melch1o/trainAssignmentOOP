public class Passenger {
    private int ID;
    private String fullName;
    private int age;


    @Override
    public  String toString() {
        return "\nPassenger information:\n" +
                "ID: " + ID + "\n" +
                "Full name: " + fullName + "\n" +
                "Age: " + age + "\n";
    }

    public Passenger(int ID, String fullName, int age) {
        this.ID = ID;
        this.fullName = fullName;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
