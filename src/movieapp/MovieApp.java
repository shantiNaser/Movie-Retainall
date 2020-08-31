/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.*;


class myApp extends JFrame implements ActionListener
{
    
    JMenu F,O;
    JMenuItem I,E,Ex,A,D,S,R,RT,Sc,Dii;
    
    
    
    
    public myApp()  // --> Constructer
    {
        
        
        super("Welcome to My Website Movie...");
     //   setIconImage(new ImageIcon("Icons/calculator.png").getImage());
        
       Img panel = new Img(
        new ImageIcon("Intro7.jpg").getImage());
       getContentPane().add(panel);
       pack();
       setVisible(true);
       
       
       
        
        
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        
        F  = new JMenu("File");
        O  = new JMenu("Operations");
        I  = new JMenuItem("import");
        E  = new JMenuItem("export");
        Ex = new JMenuItem("exit");
        A  = new JMenuItem("Add a new video");
        D  = new JMenuItem("Delete a video");
        S  = new JMenuItem("Search for a video");
        R  = new JMenuItem("rent a video");
        RT = new JMenuItem("return a video.");
        Sc = new JMenuItem("search for a customer "); 
        Dii = new JMenuItem("Display All"); 
        
        bar.add(F);
        bar.add(O);
        
        F.add(I);
        I.setIcon(new ImageIcon(""));
        F.add(E);
        E.setIcon(new ImageIcon());
        F.add(Ex);
        Ex.setIcon(new ImageIcon("Icons/logout.png"));
        O.add(A);
        O.add(D);
        O.add(S);
        O.add(R);
        O.add(RT);
        O.add(Sc);
        O.add(Dii);
        
   
        
        Ex.addActionListener(this);
        I.addActionListener(this);
        E.addActionListener(this);
        A.addActionListener(this);
        D.addActionListener(this);
        S.addActionListener(this);
        R.addActionListener(this);
        RT.addActionListener(this);
        Sc.addActionListener(this);
        Dii.addActionListener(this);
        
    
        
        
        
           setBounds(400,100,800,490);
          
           setVisible(true);
           setResizable(false);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()== Ex)
            dispose();
       
       else if(e.getSource() == I)
       {
           new Imp(this,true);
       }
       
       else if(e.getSource() == E)
       {
           new Exp(this,true);
       }
       
       else if (e.getSource() == A)
       {
           new Add(this,true);
       }
       
       else if (e.getSource() == D)
       {
           new Delete(this,true);
       }
       
       else if (e.getSource() == S)
       {
           new Search(this,true);
       }
       else if (e.getSource() == R)
       {
           new ren(this,true);
       }
       
       else if (e.getSource() == RT)
       {
           new ret(this,true);
       }
     
       else if (e.getSource() == Sc)
       {
           new SC(this,true);
       }
       
       else if (e.getSource() == Dii)
       {
           new Disp(this,true);
       }
           
        
    }
    
    
    
}



public class MovieApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            new redayNow();
        } catch (Exception ex) {
            System.out.println("Im in main");
        }
      new myApp();
      
    }
    
}
