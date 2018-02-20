public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    public Person(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }
}
