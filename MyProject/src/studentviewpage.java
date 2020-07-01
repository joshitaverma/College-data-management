import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class studentviewpage extends DBCON implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	JButton b1,b2,b3,b4;
	studentviewpage()
	{
		f1=new JFrame("Student View Page");
		p1=new JPanel();
		l1=new JLabel("Select Student ID");	
		l2=new JLabel("Student Name");
		l3=new JLabel("Father Name");
		l4=new JLabel("DOB");
		l5=new JLabel("Gender");
		l6=new JLabel("Address");
		l7=new JLabel("Contact No.");
		l8=new JLabel("Password");
		l9=new JLabel("Course");
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField();
		tf8=new JTextField();
		tf9=new JTextField();
		b1=new JButton("View");
		b2=new JButton("Delete");
		b3=new JButton("Back");
                b4=new JButton("Update");

		f1.add(p1);
		f1.setSize(450,625);
		f1.setVisible(true);
		f1.setLocationRelativeTo(null);
		p1.setLayout(null);
		f1.setResizable(false);

		p1.add(l1);p1.add(l2);p1.add(l3);p1.add(l4);
		p1.add(l5);p1.add(l6);p1.add(l7);p1.add(l8);p1.add(l9);
		p1.add(tf1);p1.add(tf2);p1.add(tf3);p1.add(tf4);
		p1.add(tf5);p1.add(tf6);p1.add(tf7);p1.add(tf8);p1.add(tf9);
		p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);

		l1.setBounds(50,50,150,25);
		l2.setBounds(50,100,150,25);
		l3.setBounds(50,150,150,25);
		l4.setBounds(50,200,150,25);
		l5.setBounds(50,250,150,25);
		l6.setBounds(50,300,150,25);
		l7.setBounds(50,350,150,25);
		l8.setBounds(50,400,150,25);
		l9.setBounds(50,450,150,25);

		tf1.setBounds(250,50,150,25);
		tf2.setBounds(250,100,150,25);
		tf3.setBounds(250,150,150,25);
		tf4.setBounds(250,200,150,25);
		tf5.setBounds(250,250,150,25);
		tf6.setBounds(250,300,150,25);
		tf7.setBounds(250,350,150,25);
		tf8.setBounds(250,400,150,25);
		tf9.setBounds(250,450,150,25);
                
		b1.setBounds(20,525,80,25);
		b2.setBounds(130,525,80,25);
		b3.setBounds(240,525,80,25);
                b4.setBounds(350,525,80,25);
   
		b1.addActionListener(this);	
		b2.addActionListener(this); 
		b3.addActionListener(this);
                b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			//JOptionPane.showMessageDialog(f1,"b1 working");
                        try
                        {   
                            int id=Integer.parseInt(tf1.getText());
                            //String viewquery="select * from studentreg";
                            String viewquery="select * from studentreg where sid="+id;
                                                     
                            Statement stmt=con.createStatement();
                            ResultSet rs=stmt.executeQuery(viewquery);
                            while(rs.next())
                            {
                            /*System.out.print(" "+rs.getInt(1));
                            System.out.print(" "+rs.getString(2));
                            System.out.print(" "+rs.getString(3));
                            System.out.print(" "+rs.getString(4));
                            System.out.print(" "+rs.getString(5));
                            System.out.print(" "+rs.getString(6));
                            System.out.print(" "+rs.getString(7));
                            System.out.print(" "+rs.getString(8));
                            System.out.print(" "+rs.getString(9));
                            System.out.print(" "+rs.getString(10));
                            System.out.print("\n");*/  
                            
                            tf1.setText(Integer.toString(rs.getInt(1)));
                            tf2.setText(rs.getString(2));
                            tf3.setText(rs.getString(3));
                            tf4.setText(rs.getString(4));
                            tf5.setText(rs.getString(5));
                            tf6.setText(rs.getString(6));
                            tf7.setText(rs.getString(7));
                            tf8.setText(rs.getString(8));
                            tf9.setText(rs.getString(10));
                            }
                            
                            
                        }
                        catch(Exception e)
                        {
                            System.out.println("Data not found"+e);
                        }
                }
		if(ae.getSource()==b2)
		{
			//JOptionPane.showMessageDialog(f1, "button working");	
                        try
                        {
                            
                            int id=Integer.parseInt(tf1.getText());
                            String delquery="delete from studentreg where sid="+id;
                            
                            PreparedStatement pst2=con.prepareStatement(delquery);
                            pst2.executeUpdate();
                            
                            JOptionPane.showMessageDialog(f1,"Data deleted...");
                        }
                        catch(Exception e)
                        {
                            System.out.println("Data not deleted"+e);
                            JOptionPane.showMessageDialog(f1,"Data not deleted..."+e);
                        }
                }
		if(ae.getSource()==b3)
		{
			//JOptionPane.showMessageDialog(f1, "button working");	
                        new home();
                }
                if(ae.getSource()==b4)
		{
			//JOptionPane.showMessageDialog(f1, "button working");
                        try
                        {
                            int sid=Integer.parseInt(tf1.getText());
                            String sname=tf2.getText();
                            String fname=tf3.getText();
                            String dob=tf4.getText();
                            String gender=tf5.getText();
                            String address=tf6.getText();
                            String contactno=tf7.getText();
                            String pw=tf8.getText();
                            String course=tf9.getText();                 
                            String updquery="UPDATE studentreg SET sname='"+sname+"',fname='"+fname+"',dob='"+dob+"',gender='"+gender+"',address='"+address+"',contactno='"+contactno+"',pw='"+pw+"',course='"+course+"'WHERE sid="+sid; 
                            PreparedStatement pst3=con.prepareStatement(updquery);
                            
                            pst3.executeUpdate();
                            JOptionPane.showMessageDialog(f1,"Data updated...");
                        }
                        catch(Exception e)
                        {
                            
                            System.out.println("error in updating"+e);
                        }
                }
	}
	public static void main(String a[])
	{
		new studentviewpage();
	}
}