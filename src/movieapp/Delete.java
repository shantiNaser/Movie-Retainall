/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author macbookpro
 */
public class Delete extends JDialog implements ActionListener {
    
    JLabel name,Note,info,info1;
    JTextField F1;
    JButton Delete,Cancel,cr;
    
    
    public Delete(JFrame F , boolean boo)
    {
        super(F);
        setTitle("Delete Videos From here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        name = new JLabel("Movie Name --->");
        F1 = new JTextField(10);
        info = new JLabel();
        info1 = new JLabel();
        Delete = new JButton("Delete");
        Cancel = new JButton("Cancel");
        cr = new JButton("Clear");
        
        
        
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.add(name);
        north.add(F1);
        north.setBackground(Color.getHSBColor(315, 16, 64));
        
        
       JPanel south = new JPanel();
       add(south,BorderLayout.SOUTH);
      south.add(Delete);
      south.add(cr);
      south.add(Cancel);
      
      south.setBackground(Color.getHSBColor(315, 16, 64));
      
      
      JPanel CN = new JPanel();
      add(CN,BorderLayout.CENTER);
      CN.add(info);
      CN.add(info1);
      CN.setBackground(Color.getHSBColor(315, 16, 64));
      
    //  add(info,BorderLayout.CENTER);
      
      
      // End Design 
      
      
      Delete.addActionListener(this);
      Cancel.addActionListener(this);
      cr.addActionListener(this);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setResizable(false);
        setBounds(600,300,500,200);
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
        }
        else if(e.getSource() == Cancel)
        {
            dispose();
        }
        
        else if(e.getSource() == Delete)
        {
          //JOptionPane.showMessageDialog(null, "Are you Sure You want To Delete This Movie ?", "Werning Msg", JOptionPane.WARNING_MESSAGE);
            
            int ans = showConfirmDialog(null, "Are you Sure You want To Delete This Movie ?", "Werning Msg",YES_NO_OPTION);
            
            if(ans==YES_OPTION)
            {
                try {
                    redayNow Del = new redayNow();
                    String n = F1.getText();
                    
                    
                    if(!n.isEmpty())
                    {
                      
                        PreparedStatement pre = Del.Con.prepareStatement("delete from Movie1 where name = ?");
                        pre.setString(1, n);
                        pre.executeUpdate();
                        
                      //  Del.print();
                        info.setText("The Process was Done Successfully....");
                        info1.setText("Thank You for using our Application");
                        info1.setForeground(Color.BLUE);
                        
                        
                    }
                    else
                    {
                        info.setText("Please Enter a Movie Name that you want to Delete !");
                        info.setForeground(Color.BLUE);
                    }

                   
                
                    
                    
                    
                } catch (Exception ex) {
                    System.out.println("an Erorr was Apper ---->" + ex.getMessage());
                }
            }
            
        }
    }
}
       
    

