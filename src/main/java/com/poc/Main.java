package com.poc;

public class Main {
    public static void main(String[] args) {
        

            Customer c1  = new Customer(1, "emmanuel", "lopez", 36, "emmanuel@ibero.com");
            Customer c2  = new Customer(2, "josé", "castro", 70, "jose@gmail.com");

            
            MySqlCRUD mysql1 = new MySqlCRUD(); 

            mysql1.close();
    }
}