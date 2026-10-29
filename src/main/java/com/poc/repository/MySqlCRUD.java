package com.poc.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.poc.model.Customer;

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

    public Connection getConnection(){

        return _connection;
    }


    public void close(){

        try {
            _connection.close();
        } catch (Exception e) {
           
              System.out.println("Error al cerrar a mysql: " +e.getMessage() );
        }
    }


    
}
