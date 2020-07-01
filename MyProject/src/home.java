import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class home implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JMenuBar mb;
	JMenu m1, m2, m3, m21;
	JMenuItem m11, m211, m212, m213, m31, m32, m33,m35,m36;
        JLabel l1,l2,l3;
        ImageIcon im1,im2;

	home()
	{
		f1 = new JFrame("Home");
		p1 = new JPanel();
		
		mb = new JMenuBar();

		m1 = new JMenu ("About");
		m2 = new JMenu ("Staff");
		m21 = new JMenu ("Instructor");
		m3 = new JMenu ("Student");
                
		m211 = new JMenuItem("Register");
		m212 = new JMenuItem("View");
		m213 = new JMenuItem("Delete");
		m31 = new JMenuItem("Register");
		m32 = new JMenuItem("View");
		m33 = new JMenuItem("Delete");
		//m34 = new JMenuItem("Attendance");
                m35=new JMenuItem("Payment");
                m36=new JMenuItem("Batch");
		m11 = new JMenuItem ("Details");
                
                im1=new ImageIcon("d:\\igdtuw.jpg");
                im2=new ImageIcon("d:\\logo.png");
                l1=new JLabel(im1);
                l2=new JLabel("Welcome to Indira Gandhi Delhi Technical University");
                l3=new JLabel(im2);
                Font fon=new Font("",Font.BOLD,32); 
                l2.setFont(fon);
              
                l1.setBounds(250,50,800,600);
                l2.setBounds(300,44,1200,40);
                l3.setBounds(90,27,300,100);
                p1.add(l3);
                p1.add(l1);
                p1.add(l2);
               
		f1.add(p1);
		f1.setJMenuBar(mb);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);

		m2.add(m21);
		m21.add(m211);
		m21.add(m212);
		m21.add(m213);
		m3.add(m31);
		m3.add(m32);
		m3.add(m33);
		//m3.add(m34);
                m3.add(m35);
                m3.add(m36);
		m1.add(m11);

		p1.setLayout(null);
		f1.setVisible(true);
		f1.setSize(1500, 800);
		f1.setLocationRelativeTo(null);

		m11.addActionListener(this);
		m211.addActionListener(this);
		m212.addActionListener(this);
		m213.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		m33.addActionListener(this);
		//m34.addActionListener(this);
                m35.addActionListener(this);
                m36.addActionListener(this);
	}

	public void actionPerformed (ActionEvent ae)
	{
		if(ae.getSource() == m11)
		{
			//JOptionPane.showMessageDialog(f1, "About page working");
			aboutcol ab=new aboutcol();
                        
		}

		else if(ae.getSource() == m211)
		{

			//JOptionPane.showMessageDialog(f1, "Instructor Register page working");
			new staffreg();
		}

		else if(ae.getSource() == m212)
		{

			//JOptionPane.showMessageDialog(f1, "Instructor View page working");
			new staffviewpage();
		}

		else if(ae.getSource() == m213)
		{

			//JOptionPane.showMessageDialog(f1, "Instructor Delete page working");
                        new staffviewpage();
                }

		else if(ae.getSource() == m31)
		{

			//JOptionPane.showMessageDialog(f1, "Student Register page working");
			new stdreg();
		}

		else if(ae.getSource() == m32)
		{
			//JOptionPane.showMessageDialog(f1, "Student View page working");
			new studentviewpage();
		}
		else if(ae.getSource() == m33)
		{
			//JOptionPane.showMessageDialog(f1, "Student Delete page working");
			new studentviewpage();
		}

                else if(ae.getSource() == m35)
                {
                        //JOptionPane.showMessageDialog(f1, "Student Payment page working");
                        new payment();
                }
                else if(ae.getSource() == m36)
                {
                        //JOptionPane.showMessageDialog(f1, "Student Batch page working");
                        new studentassignbatch();
                }
	}

	public static void main (String arg[])
	{
		new home();
	}
}