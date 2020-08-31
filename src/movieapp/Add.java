/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ 
package movieapp; 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; 
/** * * @author macbookpro */


public class Add extends JDialog implements ActionListener,FocusListener{
    
    JLabel name,length,ranted,Datares,ranfor,Dateran,Dataret,note,space,type,space1;
    JTextField F1,F2,F3,F4,F5,F6,F7;
    JComboBox com;
    String a[] = {"action", "Family" , "Drama", "Horror" ,"documentary", "Si FI", "romance", "mystery","etc..."};
    JButton Ok,cancel,Clear;
    
    
    
    public Add(JFrame F , boolean boo){
        
        
        super(F); 
        setTitle("Add a new video"); 
        setModal(true);
        this.getContentPane().setBackground(Color.getHSBColor(315, 16, 64));
       
       // JPanel west = new JPanel();
       
        
        note =  new JLabel(">>>>>>>>>You Must fill all information<<<<<<<<<<");
        
        add(note,BorderLayout.NORTH);
        
        setLayout (new FlowLayout());
        space = new JLabel("                                                                 ");
        space1 = new JLabel("                                                                                                                 ");
        add(space);
        name = new JLabel("      Movie Name ----->                    ");
        length = new JLabel("      length ------>                            ");
        ranted = new JLabel("       Rated------->                         ");
        Datares = new JLabel("     Date of released---->                 ");
        ranfor = new JLabel("     Ranted for------->                   ");
        Dateran = new JLabel("      Date of rent------->                ");
        Dataret = new JLabel("  Date of return---->                     ");
        type = new JLabel("please Choose the Type of Movie ---->");
        com = new JComboBox(a);
        Ok = new JButton("Add");
        cancel = new JButton("cancel");
        Clear= new JButton("Clear");
      
        F1 = new JTextField(10);
        F2 = new JTextField(10);
        F3 = new JTextField(10);
        F4 = new JTextField(10);
        F5 = new JTextField(10);
        F6 = new JTextField(10);
        F7 = new JTextField(10);
        
         add(name);
         add(F1);
         add(length);
         add(F2);
         add(ranted);
         add(F3);
         add(Datares);
         add(F4);
         add(ranfor);
         add(F5);
         add(Dateran);
         add(F6);
         add(Dataret);
         add(F7);
         add(type);
         add(com);
         
         add(space1);
         add(Ok);
         add(Clear);
         add(cancel);
         
         
         
         // Design id Endedd
         
         Clear.addActionListener(this);
         cancel.addActionListener(this);
         Ok.addActionListener(this);
         F3.addFocusListener(this);
        
        
        
        
        
        
        
        
        setResizable(false); 
        setBounds(600,300,500,400); 
        setVisible(true); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Clear)
        {
            F1.setText(null);
            F2.setText(null);
            F3.setText(null);
            F4.setText(null);
            F5.setText(null);
            F6.setText(null);
            F7.setText(null);
        }
        
        else if(e.getSource() == cancel)
        {
            dispose();
        }
        
        else if (e.getSource() == Ok)
        {
            
            try {
                redayNow Add = new redayNow();
                String n = F1.getText();
                String l = F2.getText();
                String r = F3.getText();
                String Dres = F4.getText();
                String RF = F5.getText();
                String Dren = F6.getText();
                String Drt = F7.getText();
                String c = (String) com.getSelectedItem();
                
                if(!n.isEmpty()&&!l.isEmpty()&&!r.isEmpty()&&!Dres.isEmpty()&&!Dren.isEmpty()&&!Drt.isEmpty()&&!c.isEmpty())
                {
                PreparedStatement pre = Add.Con.prepareStatement("insert into Movie1 values(?,?,?,?,?,?,?,?)");
                pre.setString(1, n);
                pre.setString(2, l);
                pre.setString(3, r);
                pre.setString(4, Dres);
                pre.setString(5, RF);
                pre.setString(6, Dren);
                pre.setString(7, Drt);
                pre.setString(8, c);
                
                pre.executeUpdate();
                
                note.setText(">>>>>>>>>The Process was Done Successfully. <<<<<<<<<<");
                note.setForeground(Color.BLUE);
                Clear.doClick();
                
                
               
                }
                else
                {
                    note.setText(">>>>>>>>>an requred Filled was ignored <<<<<<<<<<");
                    note.setForeground(Color.BLUE);
                    
                }

              
                        
                        } catch (Exception ex) {
                System.out.println("There is an Erorr..");
            }
           
        }
       
            

        
    }

    @Override
    public void focusGained(FocusEvent e) {
        ranted.setText("true and false just allowed");
        ranted.setForeground(Color.BLUE);
    }

    @Override
    public void focusLost(FocusEvent e) {
       ranted.setText("       Rated------->                         ");
       ranted.setForeground(Color.BLACK);
    }
}