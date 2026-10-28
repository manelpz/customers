package com.poc;

public class Main {
    public static void main(String[] args) {
        

            Customer c1  = new Customer(1, "emmanuel", "lopez", 36, "emmanuel@ibero.com");
            Customer c2  = new Customer(2, "josé", "castro", 70, "jose@gmail.com");

            
            MySqlCRUD mysql1 = new MySqlCRUD(); 
          
            //update
            //mysql1.updateCustomer(c1.getID(), "elopez@ibero.com");

            //insert
            //mysql1.insertCustomer(c1);

            //seleccionar
            //mysql1.selectCustomer();

            //seleccionar por id
            //mysql1.selectCustomerById(c1.getID());
            
            //delete
            mysql1.deleteCustomerById(c1.getID());

            //cerrar conexion
            mysql1.close();
    }
}