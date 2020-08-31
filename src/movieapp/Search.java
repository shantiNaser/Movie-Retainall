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
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author macbookpro
 */
public class Search extends JDialog implements ActionListener{
    
    JLabel name,Note,info,info1;
    JTextField F1;
    JButton ss,Cancel,cr;
    JTextArea area;
    
    
    public Search(JFrame F , boolean boo)
    {
        super(F);
        setTitle("Search Videos From here");
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
        
        name = new JLabel("Movie Name --->");
        F1 = new JTextField(10);
        info = new JLabel();
        info1 = new JLabel();
        ss = new JButton("Search");
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
      south.add(ss);
      south.add(cr);
      south.add(Cancel);
      
      south.setBackground(Color.getHSBColor(315, 16, 64));
      
      
      JPanel CN = new JPanel();
      add(CN,BorderLayout.CENTER);
      CN.add(info);
      CN.add(area);
      CN.setBackground(Color.getHSBColor(315, 16, 64));
      
       // End Design 
      
      
      ss.addActionListener(this);
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
            area.setText(null);
            area.setVisible(false);
        }
        else if(e.getSource() == Cancel)
        {
            dispose();
        }
        
        
        
        
        else if(e.getSource() == ss)
        {
           
            try { 
                
                redayNow s = new redayNow();
                String n = F1.getText();
                if(!n.isEmpty())
                {
                
                PreparedStatement pre = s.Con.prepareStatement("select * from Movie1 where name = ?");
                pre.setString(1, n);
                java.sql.Statement stmt=s.Con.createStatement();
                s.rs=pre.executeQuery();
                if(s.rs.next())
                 {
                   info.setText("the video You Search for is Founded and has an inofrmation ----->");
                  
                   area.setVisible(true);
                   
                   area.append("name : " + s.rs.getString(1) + "\nthe length of video is : " + s.rs.getString(2)+"\nIs a Video Rated : " + s.rs.getString(3)+"\nThe Date of Relsed the video is : "+
                           s.rs.getString(4)+"\nThe Video is Ranted for : " + s.rs.getString(5)+"\nThe Date of Rented the video is : "+s.rs.getString(6)+"\nThe Date of Returned the video is : "+s.rs.getString(7)+
                           "\nThe Type of Movie is " + s.rs.getString(8) );
                 }
                else
                    info.setText("The Video You Search for does not exist please be Sure another Time..");
           
                }
                else
                {
                    info.setText("Please Enter a Movie Name that you want to Search !");
                    info.setForeground(Color.BLUE);
                
                }
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
                
             
                
              

}
       
    }
}
