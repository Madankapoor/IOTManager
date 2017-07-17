/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.coda.iotmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.naming.InitialContext;
import java.util.Date;
/**
 *
 * @author main
 */

public class IotDatabaseHelper {
    static InitialContext initialContext;
    static  String CONNECTIONURL;
    static String DRIVER;
    static String USER;
    static String PASSWORD;
             
    static
    {
        try
        {
             InitialContext initialContext = new javax.naming.InitialContext();
             CONNECTIONURL =(String) initialContext.lookup("java:comp/env/MYSQL_CONNECTIONURL");
             DRIVER =(String) initialContext.lookup("java:comp/env/DRIVER");
             USER =(String) initialContext.lookup("java:comp/env/MYSQL_USER");
             PASSWORD =(String) initialContext.lookup("java:comp/env/MYSQL_PASS");
              
        }
        catch(Exception e)
        {

        }
    }
   

    
    Connection connection ;
    Statement statement;
    public IotDatabaseHelper()
    {   
        
        connection=null;
        statement=null;
    }
    
    public String add(String q,String[] m) throws Exception
   {    
       int status=-1;
         
        // Load JBBC driver "com.mysql.jdbc.Driver"
        Class.forName(DRIVER).newInstance();
        /* Create a connection by using getConnection() method that takes parameters 
        of string type connection url, user name and password to connect to database.*/
        connection = DriverManager.getConnection(CONNECTIONURL,USER , PASSWORD);

        // sql query to retrieve values from the secified table.
        PreparedStatement ps=connection.prepareStatement(q);  
        for(int i=0;i<m.length;i++)
        {    ps.setString(i+1,m[i]);
        }
        
        status=ps.executeUpdate();  


        if(status!=1) throw new Exception("row not added");

        connection.close();
    return "row added Successfully";
   }
    
     
     public String addwithTimeStamp(String q,String[] m) throws Exception
   {    
       int status=-1;
         
        // Load JBBC driver "com.mysql.jdbc.Driver"
        Class.forName(DRIVER).newInstance();
        /* Create a connection by using getConnection() method that takes parameters 
        of string type connection url, user name and password to connect to database.*/
        connection = DriverManager.getConnection(CONNECTIONURL,USER , PASSWORD);

        // sql query to retrieve values from the secified table.
        PreparedStatement ps=connection.prepareStatement(q);  
        for(int i=0;i<m.length;i++)
        {   ps.setString(i+1,m[i]);
        }
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        ps.setTimestamp(m.length+1, timestamp);
        
        status=ps.executeUpdate();  


        if(status!=1) throw new Exception("row not added");

        connection.close();
    return "row added Successfully";
   }
     
     public ResultSet resultQuery(String q,String[] m)
     {
          ResultSet rs=null;  
       try
       { // Load JBBC driver "com.mysql.jdbc.Driver"
        Class.forName(DRIVER).newInstance();
        /* Create a connection by using getConnection() method that takes parameters 
        of string type connection url, user name and password to connect to database.*/
        connection = DriverManager.getConnection(CONNECTIONURL,USER , PASSWORD);
/* createStatement() is used for create statement object that is used for 
            sending sql statements to the specified database. */
            PreparedStatement ps = connection.prepareStatement(q);
            // sql query to retrieve values from the secified table.
           for(int i=0;i<m.length;i++) ps.setString(i+1,m[i]);
            rs = ps.executeQuery();
       }
       catch(Exception ex)
        {
               return null;
        }
        
        return rs;
     }
     
     public ResultSet resultQuery(String q)
    {   
        ResultSet rs=null;  
       try
       {
           
           
           // Load JBBC driver "com.mysql.jdbc.Driver"
        Class.forName(DRIVER).newInstance();
        /* Create a connection by using getConnection() method that takes parameters 
        of string type connection url, user name and password to connect to database.*/
        connection = DriverManager.getConnection(CONNECTIONURL,USER , PASSWORD);
/* createStatement() is used for create statement object that is used for 
            sending sql statements to the specified database. */
            statement = connection.createStatement();
            // sql query to retrieve values from the secified table.
            rs = statement.executeQuery(q);
       }
       catch(Exception ex)
        {
               return null;
        }
        
        return rs;
    }
     
     public void close()
     { 
         try {
          statement.close();
            connection.close();
            statement=null;
            connection=null;
        }
       catch(Exception ex)
        {
              
        }
     
     }
     
}
