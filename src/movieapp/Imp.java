/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author macbookpro
 */
public class Imp extends JDialog implements ActionListener {
    
    JLabel info,info1,info2;
    JButton Choose;
    
    public Imp(JFrame F , boolean boo)
    {
        super(F);
        setTitle("Import Videos From here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        info = new JLabel("plese select a file contain information about Movie to be add From here ------>");
        info2 = new JLabel("there is Test File in a local Project location called Test try it");
        info1 = new JLabel("");
        Choose = new JButton("Choose");
       
       // Choose.setPreferredSize(new Dimension(10, 10));
        
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.add(info);
        north.add(info2);
        north.add(Choose);
       
        north.setBackground(Color.getHSBColor(315, 16, 64));
        add(north);
        
       
        
        Choose.addActionListener(this);
        
        
        
        
           
     
    
        
        
        setResizable(false);
        setBounds(600,300,700,200);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == Choose)
        {
            JFileChooser f=new JFileChooser();
        f.showOpenDialog(null);
        String t=f.getSelectedFile().getPath();
        File Doo = f.getSelectedFile();
        
         try {
             if(Doo.exists()&&Doo.canRead()&&Doo.isFile())
             {
             redayNow a = new redayNow();
           Scanner in=new Scanner (new File(t));
             PreparedStatement ps;
          String sql = "insert into Movie1 values (?,?,?,?,?,?,?,?)";
         ps = a.Con.prepareStatement(sql);
           while(in.hasNext())
           {
               ps.setString(1,in.next());
               ps.setString(2,in.next());
               ps.setString(3,in.next());
               ps.setString(4,in.next());
               ps.setString(5,in.next());
               ps.setString(6,in.next());
               ps.setString(7,in.next());
               ps.setString(8,in.next());
               ps.execute();
               
               JOptionPane.showMessageDialog(null, "Congratulation the Movie is add Successfulyy ");
              
           }
           }
             else 
                 JOptionPane.showMessageDialog(null, "Please Cheek the file and be Sure the information stasfay the requbbment");
                 
             
         }
         catch(Exception ex)
         {
             System.out.println("Erorr is uperr"+ex.getMessage());
         }
       
        }
    }
}
       

