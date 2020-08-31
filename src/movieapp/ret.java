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
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.*;
import static javax.swing.JOptionPane.showInputDialog;

/**
 *
 * @author macbookpro
 */
public class ret extends JDialog implements ActionListener {
    
    JLabel name,Note,info,info1,name2;
    JTextField F1,F2;
    JButton retu,Cancel,cr;
    
    public ret(JFrame F , boolean boo)
    {
        super(F);
        setTitle("return Videos From here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        
        name = new JLabel("Movie Name --->");
        name2 = new JLabel("Your Name --->");
        F1 = new JTextField(10);
        F2 = new JTextField(10);
        info = new JLabel();
        info1 = new JLabel();
        retu = new JButton("Return Video");
        Cancel = new JButton("Cancel");
        cr = new JButton("Clear");
        F2.setVisible(false);
        name2.setVisible(false);
        
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.add(name);
        north.add(F1);
        north.setBackground(Color.getHSBColor(315, 16, 64));
        
        
       JPanel south = new JPanel();
       add(south,BorderLayout.SOUTH);
      south.add(retu);
      south.add(cr);
      south.add(Cancel);
      
      south.setBackground(Color.getHSBColor(315, 16, 64));
      
      
      JPanel CN = new JPanel();
      add(CN,BorderLayout.CENTER);
      CN.add(info);
      CN.add(name2);
      CN.add(F2);
      CN.setBackground(Color.getHSBColor(315, 16, 64));
      
       // End Design 
      
      
      retu.addActionListener(this);
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
            
            name2.setVisible(false);
           F2.setVisible(false);
                  
                   
        }
        else if(e.getSource() == Cancel)
        {
            dispose();
        }
        
        else if(e.getSource() == retu)
        {
             try {
                 redayNow r1 = new redayNow();
                 String n = F1.getText();
                 
                 if(!n.isEmpty())
                {
                   PreparedStatement pre = r1.Con.prepareStatement("select * from Movie1 where name = ?");
                   pre.setString(1, n);
                   java.sql.Statement stmt=r1.Con.createStatement();
                   r1.rs=pre.executeQuery();
                   if(r1.rs.next())
                 {

                  String idontKnow = r1.rs.getString(5);
                  if(!idontKnow.isEmpty())
                  {
                      String s = showInputDialog("Please enter Your name To Verfiy");
                      
                      if(s.equals(idontKnow))
                      {
                          PreparedStatement pre1 = r1.Con.prepareStatement("update Movie1 set ranfor = '' where name = ?");
                           pre1.setString(1, n);
                           java.sql.Statement stmt1=r1.Con.createStatement();
                          pre1.executeUpdate();
                          info.setText("The Process was Done Successfylly.. Thank You ");
                          info.setForeground(Color.BLUE);
                          name2.setVisible(false);
                          F2.setVisible(false);

              
                      }
                      else
                      {
                          info.setText("please cheeck the Name ");
                          info.setForeground(Color.red);
                      }
                  }
                  else
                  {
                      info.setText("The Video You Search is alreday avilable");
                      info.setForeground(Color.BLUE);

                  }
                  
                    
                 }
                   else
                   {
                       info.setText("The Video You Search Does not exist");
                       info.setForeground(Color.BLUE);
                   }
                    
                    
                    
                }
                 
                 
                 else
                {
                    info.setText("Please Enter a Movie Name that you want to Return !");
                    info.setForeground(Color.BLUE);
                
                }
                

                 
                 
                 
                 
                 
                 
                 
                 
             } catch (Exception ex) {
                 System.out.println("an Erorr was Apper ---->" + ex.getMessage());
             }

            
        }
         
        
    }
}
    

