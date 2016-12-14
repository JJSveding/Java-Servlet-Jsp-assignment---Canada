package helperClasses;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 * 	Student number: 101087617
 *	Date:			29/10/2016 
 *
 * 	Description:	Used to create connection to the database.
 * 
 * 					Singleton Database class
 * 					Only one instance can be instatiatet.
 */


/**
 * Created by Jens on 10/17/16.
 *

 */
public class MySQLDatabase
{

    private static MySQLDatabase mySQLDatabase = new MySQLDatabase("jdbc:mysql://localhost:3306/COMP3095?useSSL=false", "root", "admin");

    private Connection connection;
    private String dbURL;
    private String dbUser;
    private String dbPass;

    private MySQLDatabase(String dbURL, String dbUser, String dbPass)
    {

        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPass = dbPass;

        //Driver init
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();}

    }

    /*
   This method returns the instance of the class.
     */
    public static MySQLDatabase getInstance()
    {
        return mySQLDatabase;
    }

    /*
   Creates and returns a connection to MySQL.
     */
    public Connection getConnection()
    {
        try
        {
            this.connection = DriverManager.getConnection(this.dbURL, this.dbUser, this.dbPass);
        }catch (Exception e){e.printStackTrace();}
        return this.connection;
    }

}
