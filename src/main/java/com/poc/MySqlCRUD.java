package com.poc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlCRUD {

    private Connection _connection;

    public MySqlCRUD(){
        try {
            Properties config = new Properties();
            config.load(new FileInputStream("src/main/resources/config.properties"));
            _connection = DriverManager.getConnection(
                    config.getProperty("mysql.url"),
                    config.getProperty("mysql.username"),
                    config.getProperty("mysql.password"));

        } catch (Exception e) {
            System.out.println("Error al conectar a mysql: " +e.getMessage() );

        }
    }

    public void insertCustomer(Customer customer){
         try {
            PreparedStatement statement = _connection.prepareStatement("insert into customers (id, first_name, last_name, age, email) values (?, ?, ?, ?, ?)");
            statement.setInt(1, customer.getID());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setInt(4, customer.getAge());
            statement.setString(5, customer.getEmail());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error  al insertar " + e.getMessage() );
            e.printStackTrace();
        }
    }

    public void updateCustomer (int id, String mail){
        try {
            PreparedStatement statement = _connection.prepareStatement("update customers set email = ? where id = ?");
            statement.setString(1, mail);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error  al actualizar " + e.getMessage() );
            e.printStackTrace();
        }
    }


    public void selectCustomer (){
        try {
            PreparedStatement statement = _connection.prepareStatement("select * from customers");
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                System.out.println("mi id " + rs.getInt("id") + " y nombre: "+rs.getString("first_name") 
                
                + " apellido: " +rs.getString("last_name") + " edad: " + rs.getInt("age") + " email: "+rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("error  al seleccionar " + e.getMessage() );
            e.printStackTrace();
        }
    }


    public void selectCustomerById (int id){
        try {
            PreparedStatement statement = _connection.prepareStatement("select * from customers where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                System.out.println("mi unico id " + rs.getInt("id") + " y nombre: "+rs.getString("first_name") 
                
                + " apellido: " +rs.getString("last_name") + " edad: " + rs.getInt("age") + " email: "+rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("error al seleccionar " + e.getMessage() );
            e.printStackTrace();
        }
    }


    public void deleteCustomerById (int id){
        try {
            PreparedStatement statement = _connection.prepareStatement("delete from customers where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch ( Exception e) {
            System.out.println("error  al eliminar " + e.getMessage() );
            e.printStackTrace();
        }
    }

    

    public void close(){

        try {
            _connection.close();
        } catch (Exception e) {
           
              System.out.println("Error al cerrar a mysql: " +e.getMessage() );
        }
    }


    
}
