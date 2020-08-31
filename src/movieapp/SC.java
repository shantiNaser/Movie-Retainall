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
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author macbookpro
 */
public class SC extends JDialog implements ActionListener {
    
    JLabel name,Note,info,info1;
    JTextField F1;
    JButton SCCC,Cancel,cr;
    JTextArea area;
    
    public SC(JFrame F , boolean boo)
    {
        super(F);
        setTitle("Search for a Customer from Here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        
       
        name = new JLabel("Your Name --->");
        F1 = new JTextField(10);
        
        info = new JLabel();
        info1 = new JLabel();
        SCCC = new JButton("Search");
        Cancel = new JButton("Cancel");
        cr = new JButton("Clear");
        area = new JTextArea(30,30);
        area.setVisible(false);
        
        
        
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.add(name);
        north.add(F1);
        north.setBackground(Color.getHSBColor(315, 16, 64));
        
        
       JPanel south = new JPanel();
       add(south,BorderLayout.SOUTH);
      south.add(SCCC);
      south.add(cr);
      south.add(Cancel);
      
      south.setBackground(Color.getHSBColor(315, 16, 64));
      
      
      JPanel CN = new JPanel();
      add(CN,BorderLayout.CENTER);
      CN.add(info);
      CN.add(info1);
      CN.add(area);
      CN.setBackground(Color.getHSBColor(315, 16, 64));
      
       // End Design 
      
      
      SCCC.addActionListener(this);
      Cancel.addActionListener(this);
      cr.addActionListener(this);
      
        
        
        
        
        
        
        setResizable(false);
        setBounds(600,300,500,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == cr)
        {
            F1.setText(null);
            info.setText(null);
            info1.setText(null);
            area.setVisible(false);
         
        }
        else if(e.getSource() == Cancel)
        {
            dispose();
        }
         
         
        else if(e.getSource() == SCCC)
        {
           
             try {
                 redayNow r1 = new redayNow();
                 String n = F1.getText();
                 
                 if(!n.isEmpty())
                {
                   PreparedStatement pre = r1.Con.prepareStatement("select name from Movie1 where ranfor = ?");
                   pre.setString(1, n);
                   java.sql.Statement stmt=r1.Con.createStatement();
                   r1.rs=pre.executeQuery();
                   if(r1.rs.next())
                 {
                     info.setText("Hello -----> " + n + " You are a Customer in our Application");
                     info1.setText("Videos You are Ranted ---->");
                     area.setVisible(true);
                     r1.rs.beforeFirst();
                     int i=1;
                    
                     while(r1.rs.next())
                     {
                         area.append("The Movie ( " + i + " ) is :" + r1.rs.getString(1)+ "\n");
                         i++;
                     }
                    

                 }
                   else
                   {
                        info.setText("Sorry the Customer You Search Does Not Exist                             ");
                        info1.setText("We will be very happy if you join us --- Welcome");
                        info1.setForeground(Color.BLUE);
                        
                   }
                   
                   
                   
                }
                  else
                {
                    info.setText("an Important Filed was Missing !");
                    info.setForeground(Color.BLUE);
                
                }
                         
                         
                         
             } catch (Exception ex) {
                  System.out.println("an Erorr was Apper ---->" + ex.getMessage());
             }
        }
        
    }
    
}
