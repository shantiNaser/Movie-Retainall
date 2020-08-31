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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 *
 * @author macbookpro
 */
public class ren extends JDialog implements ActionListener {
    
    JLabel name,Note,info,info1,name2;
    JTextField F1,F2;
    JButton renttt,Cancel,cr;
    JTextArea area;
    
    
    public ren(JFrame F , boolean boo)
    {
        super(F);
        setTitle("rent Videos From here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        
        name = new JLabel("Movie Name --->");
        name2 = new JLabel("Your Name --->");
        F1 = new JTextField(10);
        F2 = new JTextField(10);
        info = new JLabel();
        info1 = new JLabel();
        renttt = new JButton("Rent Now");
        Cancel = new JButton("Cancel");
        cr = new JButton("Clear");
        F2.setVisible(false);
        name2.setVisible(false);
        area = new JTextArea(30,30);
        area.setVisible(false);
        
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.add(name);
        north.add(F1);
        north.setBackground(Color.getHSBColor(315, 16, 64));
        
        
       JPanel south = new JPanel();
       add(south,BorderLayout.SOUTH);
      south.add(renttt);
      south.add(cr);
      south.add(Cancel);
      
      south.setBackground(Color.getHSBColor(315, 16, 64));
      
      
      JPanel CN = new JPanel();
      add(CN,BorderLayout.CENTER);
      CN.add(info);
      CN.add(area);
      CN.add(name2);
      CN.add(F2);
      CN.setBackground(Color.getHSBColor(315, 16, 64));
      
       // End Design 
      
      
      renttt.addActionListener(this);
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
           area.setText(null);
            area.setVisible(false);
                  
                   
        }
        else if(e.getSource() == Cancel)
        {
            dispose();
        }
        
        
        else if (e.getSource() == renttt)
        {
            int ans = showConfirmDialog(null, "Are you Sure You want To Rent This Movie ?", "confirmation Msg",YES_NO_OPTION);
            
            if(ans==YES_OPTION)
            {
                 try { 
                
                redayNow rr = new redayNow();
                String n = F1.getText();
                if(!n.isEmpty())
                {
                
                PreparedStatement pre = rr.Con.prepareStatement("select * from Movie1 where name = ?");
                pre.setString(1, n);
                java.sql.Statement stmt=rr.Con.createStatement();
                rr.rs=pre.executeQuery();
                if(rr.rs.next())
                 {
                     String idontKnow = rr.rs.getString(5);
                    
                     if(idontKnow.isEmpty())
                     {
                   info.setText("Please Enter Your name To Complete Process..                          ");
                   name2.setVisible(true);
                  
                   F2.setVisible(true);
                   
                   String g=F2.getText();
                   if(!g.isEmpty())
                   {
                       PreparedStatement pre1 = rr.Con.prepareStatement("update Movie1 set ranfor = ? where name = ?");
                       pre1.setString(1, g);
                       pre1.setString(2, n);
                       java.sql.Statement stmt1=rr.Con.createStatement();
                       pre1.executeUpdate();
                       info.setText("The Video --> " + n +   "<-- You are Requsted is Ranted to You Now ");
                       name2.setVisible(false);
                       F2.setVisible(false);
                   }
                   else
                            info.setText("Plese You Must Enter Your name To Complete The Process                ");
                   
                   
                   
                     }
                     else
                     {
                         info.setText("You cant ranted this Movie Now Because SomeOne is Ranted ");
                         area.setVisible(true);
                         area.append("You can Choose any Video From here ");
                         java.sql.Statement stmt2=rr.Con.createStatement();
                         rr.rs=stmt.executeQuery("select * from Movie1 where ranfor = '' "); 
            
                         while(rr.rs.next())
                         {
                             area.append("\nName is ----->"+rr.rs.getString(1));
                         }
           
                         
                         
                     }
                 }
                else
                {
                    info.setText("The Video You Search for does not exist");
                    area.setVisible(true);
                         area.append("You can Choose any Video From here ");
                         java.sql.Statement stmt2=rr.Con.createStatement();
                         rr.rs=stmt.executeQuery("select * from Movie1 where ranfor = '' "); 
            
                         while(rr.rs.next())
                         {
                             area.append("\nName is ----->"+rr.rs.getString(1));
                         }
                    
                }
           
                }
                else
                {
                    info.setText("Please Enter a Movie Name that you want to Search !");
                    info.setForeground(Color.BLUE);
                
                }
                
                
                    
                    
                    
                } catch (Exception ex) {
                    System.out.println("an Erorr was Apper ---->" + ex.getMessage());
                }
            }
            
        }
    }
        }
        
        
    

