/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbookpro
 */
public class redayNow  {
    
    Connection Con=null;
  
   Statement stmt;
    ResultSet rs=null;
    
   
    
    
    
    public redayNow() throws Exception
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12358378","sql12358378","afSvSH64w4");
        //print();
       
   

    
        }
     
        catch(Exception e )
        {
            System.out.println(e);
        }
     
  
    }
    
    public void print() throws SQLException
    {
        
           java.sql.Statement stmt=Con.createStatement();
           rs=stmt.executeQuery("select * from Movie1"); 
            System.out.println("Im here done work");
            while(rs.next())
            {
            System.out.println("Name is ----->"+rs.getString(1)+" length is ---->" + rs.getString(2) + "its Ranted -->"+rs.getBoolean(3) + " the Date of Relesed is " + rs.getString(4));
            }
        
    }
    
    
    public void Search(String n) throws SQLException
    {
       PreparedStatement pre = Con.prepareStatement("select * from Movie1 where name = ?");
        pre.setString(1, n);
        java.sql.Statement stmt=Con.createStatement();
        rs=pre.executeQuery();
        if(rs.next())
        {
            System.out.println("");
        }
        
        
    }
    
  
    }
    
    
    
  
    

