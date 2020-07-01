import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class payment extends DBCON implements ActionListener
{
    JFrame f1,f2;
    JPanel p1,p2;
    JTextField tf0,tf1,tf2;
    JTextField tf21,tf22,tf23,tf24;
    
    JLabel l0,l1,l2;
    JLabel l20,l21,l22,l23,l24;
    
    JButton b1,b2;
    payment()
    {
            f1=new JFrame("Payment");
            p1=new JPanel();
            
            l1=new JLabel("Student id");
            l2=new JLabel("Amount paid");
               
            l0=new JLabel("Fee payment");
            
            tf1=new JTextField();
            tf2=new JTextField();
                        
            
            b1=new JButton("Save");
            b2=new JButton("Back");
            
            
            l1.setBounds(50,100,150,25);
            l2.setBounds(50,150,150,25);
          
                         
            l0.setBounds(170,30,150,25);
            
            tf1.setBounds(250,100,150,25);
            tf2.setBounds(250,150,150,25);
                       
            b1.setBounds(110,250,80,25);
            b2.setBounds(250,250,80,25);
          
            
            p1.add(l0);                   
            p1.add(l1);
            p1.add(l2);
                                   
            p1.add(tf1);
            p1.add(tf2);
                                  
            p1.add(b1);
            p1.add(b2);
            
            
            f1.add(p1);
            p1.setLayout(null);
            f1.setSize(450,330);
            f1.setVisible(true);
            f1.setLocationRelativeTo(null);
            f1.setResizable(false);
            
            b1.addActionListener(this);	
            b2.addActionListener(this); 
     
            
    }         
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            //JOptionPane.showMessageDialog(f1,"b1 is working");
           
                        String str1=tf1.getText();
                        String str2=tf2.getText();
                       
            try
            {
                String insertquery="insert into payment value(?,?);";
                PreparedStatement pst=con.prepareStatement(insertquery);
                pst.setInt(1,Integer.parseInt(str1));
                pst.setInt(2,Integer.parseInt(str2));
             
                pst.executeUpdate();
                System.out.println("Data inserted...");
                JOptionPane.showMessageDialog(f1,"Data Inserted");
                
                f2=new JFrame();
                p2=new JPanel();
                
                
                tf21=new JTextField();
                tf22=new JTextField();
                tf23=new JTextField();
                tf24=new JTextField();
                
                l20=new JLabel("Payment Receipt");
                l21=new JLabel("Student Id");
                l22=new JLabel("Amout paid");
                l23=new JLabel("Total amount paid");
                l24=new JLabel("Due balance");
                
                tf21.setBounds(250,100,150,25);
                tf22.setBounds(250,150,150,25);
                tf23.setBounds(250,200,150,25);
                tf24.setBounds(250,250,150,25);                
                
                l20.setBounds(170,30,150,25);
                l21.setBounds(50,100,150,25);
                l22.setBounds(50,150,150,25);
                l23.setBounds(50,200,150,25);
                l24.setBounds(50,250,150,25);
                
               
                f2.add(p2);
                f2.setVisible(true);
                f2.setSize(450,400);
                p2.setLayout(null);
                f2.setLocationRelativeTo(null);
                f2.setResizable(false);
                
                p2.add(l20);
                p2.add(l21);                   
                p2.add(l22);
                p2.add(l23);                                   
                p2.add(l24);
                
                p2.add(tf21);                
                p2.add(tf22);
                p2.add(tf23);
                p2.add(tf24);
                
                String str21=tf1.getText();
                tf21.setText(str21);
                
                String str22=tf2.getText();
                tf22.setText(str22);
                
                int id=Integer.parseInt(tf1.getText());
                String viewquery="select sum(paid) from payment where sid="+id;
                PreparedStatement stmt=con.prepareStatement(viewquery);            
                ResultSet rs=stmt.executeQuery();
                rs.next();
                String sum=rs.getString(1);
                System.out.println(sum);
                tf23.setText(sum);        
                String duequery="select 100000-sum(paid) from payment where sid="+id;
                PreparedStatement stmt1=con.prepareStatement(duequery);
                ResultSet rs1=stmt1.executeQuery();
                rs1.next();
                String due=rs1.getString(1);
                System.out.println(due);
                tf24.setText(due);
            }
            catch(Exception e)
            {
                System.out.println("Data not inserted "+e);
            }
            
        }
        if(ae.getSource()==b2)
        {
            //JOptionPane.showMessageDialog(f1,"b2 is working");
            new home();
        }
      
    }
    public static void main(String args[])
    {
        payment pay=new payment();
    }
}