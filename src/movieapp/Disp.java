/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author macbookpro
 */
public class Disp extends JDialog implements ActionListener{
    
    JButton Start;
    JTextArea area;
    JLabel l;
    
    public Disp(JFrame F , boolean boo)
    {
        super(F);
        setTitle("Display all information");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
       Start = new JButton("Start");
       area  = new JTextArea(40,50);
       l = new JLabel("Here is Gooo ---->");
       
       
       add(Start,BorderLayout.SOUTH);
       
       add(area,BorderLayout.CENTER);
       
       add(l,BorderLayout.NORTH);
       
       Start.addActionListener(this);
        
        
        
        
        
        
        setResizable(false);
        setBounds(600,300,1000,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
      if(e.getSource() == Start)
      {
          try {
              redayNow r1 = new redayNow();                                                                                                     
              area.append("Name\tLength\tIs-Rated\t   Date Relesed\t     Ranted-For\t      Date-rated\t           Date-return\t                 Type\n");
              area.append("-----------------------------------------------------------------------------------------------------------\n");
              
            java.sql.Statement stmt=r1.Con.createStatement();
            r1.rs=stmt.executeQuery("select * from Movie1"); 
            System.out.println("Im here done work");
            while(r1.rs.next())
            {
            area.append(r1.rs.getString(1)+"\t"+r1.rs.getString(2)+"\t"+r1.rs.getString(3)+ "\t   " + r1.rs.getString(4)+"\t     "+r1.rs.getString(5)+"\t      "+r1.rs.getString(6)+"\t     "+r1.rs.getString(7)+"\t       "+r1.rs.getString(8)+"\n");
            }
              
              
              
          } catch (Exception ex) {
               System.out.println("an Erorr was Apper ---->" + ex.getMessage());
          }
      }
    }
    
}
