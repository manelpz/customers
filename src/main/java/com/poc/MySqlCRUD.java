package com.poc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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


    public void close(){

        try {
            _connection.close();
        } catch (Exception e) {
           
              System.out.println("Error al cerrar a mysql: " +e.getMessage() );
        }
    }


    
}
