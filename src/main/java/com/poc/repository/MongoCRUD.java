package com.poc.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Properties;

import org.bson.Document;
import java.io.FileInputStream;

public class MongoCRUD {

    private MongoClient _mongoClient;
    private MongoCollection<Document> _collection;

    public MongoCRUD(){
        try{
             Properties config = new Properties();
            config.load(new FileInputStream("src/main/resources/config.properties"));
            
            _mongoClient = MongoClients.create(config.getProperty("monguito.url"));
            MongoDatabase  database = _mongoClient.getDatabase(config.getProperty("monguito.database"));
            _collection = database.getCollection(config.getProperty("monguito.collection"));


        }catch( Exception e){
            System.out.println("Error al conectar a monguito: " +e.getMessage() );
        }
    }


    public void close(){
        if(_mongoClient != null)
            { 
                _mongoClient.close();
            }  
    }
    
}
