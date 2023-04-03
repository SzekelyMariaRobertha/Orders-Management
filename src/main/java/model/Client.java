package model;

/**
 * Client is the main entity we'll be using to do CRUD operations on clients from the database tabla called client
 *
 *
 * @author Szekely Maria-Robertha
 */

public class Client {

    private final int id;
    private final String name;
    private final String address;
    private final int age;
    private final String email;
    private final String phoneNr;

    public Client(int id, String name, String address, int age, String email, String phoneNr) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.phoneNr = phoneNr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    @Override
    public String toString() {
        return "Client [id = " + id + ", name = " + name + ", address = " + address + ", email = " + email + ", age = " + age + ", tel. =  " + phoneNr + "]";
    }
}