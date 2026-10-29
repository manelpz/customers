package com.poc.model;

public class Customer {

    private int _id;
    private String _firstName;
    private String _lastName;
    private int _age;
    private String _email;

    public Customer(int id, String firstName,  String lastName, int age, String email){
        this._id = id;
        this._firstName = firstName;
        this._lastName = lastName;
        this._age = age;
        this._email = email;
    }

    public int getID(){
        return _id;
    }

     public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public int getAge() {
        return _age;
    }
    
    public String getEmail() {
        return _email;
    }
}
