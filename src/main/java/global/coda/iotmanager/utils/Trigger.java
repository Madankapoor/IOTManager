/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.coda.iotmanager.utils;
import java.sql.*;
import javax.naming.InitialContext;
/**
 *
 * @author DELL
 */
public class Trigger {
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
   
        public void CreateTrigger(String trigger)
        {
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;

                try
                {
                        // Load the Mysql JDBC driver
                        Class.forName(DRIVER);

                      
                        connection = DriverManager.getConnection(CONNECTIONURL, USER, PASSWORD );
                        statement = connection.createStatement();

                        String query = trigger;
                        System.out.println(query);
                        statement.execute( query );
                }
                catch (SQLException e)
                {
                       // System.err.println("Caught SQL Exception - " + e.getMessage());
                      //  e.printStackTrace();
                }
                catch (ClassNotFoundException e)
                {
                       // System.err.println("Caught Class not found Exception - " + e.getMessage());
                       // e.printStackTrace();
                }
                catch (Exception e)
                {
                      //  System.err.println("Caught Other Exception - " + e.getMessage());
                      //  e.printStackTrace();
                }

                finally
                {
                        if (resultSet != null)
                        try
                        {
                                        resultSet.close();
                        }
                        catch (SQLException e)
                        {
                              //  e.printStackTrace();
                        }
                        
                        if (statement != null)
                        try
                        {
                                        statement.close();
                        }
                        catch (SQLException e)
                        {
                             //   e.printStackTrace();
                        }
                        
                        if (connection != null)
                        try
                        {
                                        connection.close();
                        }
                        catch (SQLException e)
                        {
                               // e.printStackTrace();
                        }
                }
        }
}
