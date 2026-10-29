package com.poc;

import com.poc.model.Customer;
import com.poc.repository.MySqlCRUD;
import com.poc.repository.MongoCRUD;
import com.poc.service.CustomerServiceMongo;
import com.poc.service.CustomerServiceMySQL;

public class Main {
    public static void main(String[] args) {
        

            Customer c1  = new Customer(1, "emmanuel", "lopez", 36, "emmanuel@ibero.com");
            Customer c2  = new Customer(2, "josé", "castro", 70, "jose@gmail.com");

            MongoCRUD mongo1 = new MongoCRUD(); 
            CustomerServiceMongo mongoService = new CustomerServiceMongo();

             //update
            /*mongoService.updateCustomer(c1.getID(), "elopez@ibero.com");

            //insert
            mongoService.insertCustomer(c1);

            //seleccionar
            mongoService.selectCustomer();

            //seleccionar por id
            mongoService.selectCustomerById(c1.getID());
            
            //delete
            mongoService.deleteCustomerById(c1.getID());*/

            //cerrar conexion
            mongo1.close();



            /*MySqlCRUD mysql1 = new MySqlCRUD(); 
            CustomerServiceMySQL mysqlService = new CustomerServiceMySQL(mysql1.getConnection());
          
            //update
            mysqlService.updateCustomer(c1.getID(), "elopez@ibero.com");

            //insert
            mysqlService.insertCustomer(c1);

            //seleccionar
            mysqlService.selectCustomer();

            //seleccionar por id
            mysqlService.selectCustomerById(c1.getID());
            
            //delete
            mysqlService.deleteCustomerById(c1.getID());

            //cerrar conexion
            mysql1.close();*/
    }
}