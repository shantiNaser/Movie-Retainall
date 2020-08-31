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
import java.io.File;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author macbookpro
 */
public class Exp extends JDialog implements ActionListener{
    
    JLabel name;
    JTextField d;
    JButton O,C;
    
    public Exp(JFrame F , boolean boo)
    {
        super(F);
        setTitle("Export Videos From here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        name = new JLabel("Choose the File That Contain information for Movie To Export");
        //d = new JTextField(30);
        O = new JButton("Export");
        C = new JButton("Cancel");
        
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.add(name);
        //north.add(d);
        north.setBackground(Color.getHSBColor(315, 16, 64));
       
        
        
        
        JPanel south = new JPanel();
        add(south,BorderLayout.SOUTH);
        south.add(O);
        south.add(C);
        south.setBackground(Color.getHSBColor(315, 16, 64));
       
        
        O.addActionListener(this);
        C.addActionListener(this);
        
        
       
       
       
        
        
        
        
        
        setResizable(false);
        setBounds(600,300,700,200);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == C)
        {
           dispose();
        }
        else if(e.getSource() == O)
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
          String sql = "delete from Movie1 where name = ?";
         ps = a.Con.prepareStatement(sql);
           
               ps.setString(1,in.next());
            
               ps.execute();
               
               JOptionPane.showMessageDialog(null, "Congratulation the Movie is Deleted Successfulyy ");
              
           
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

