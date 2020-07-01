import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class aboutcol
{   JFrame f1;
    JPanel p1;
    JLabel l1;
    Font fon;
    aboutcol()
    {
        f1=new JFrame("About page");
        p1=new JPanel();
        l1=new JLabel("<html><body>Indira Gandhi Delhi Technical University for Women (IGDTUW) has been upgraded from Indira Gandhi<br>Institute of Technology in May 2013 vide Delhi State Legislature Act 9, 2012, as a non-affiliating teaching and<br> research University at Delhi to facilitate and promote studies, research, technology, innovation, incubation and<br>extension work in emerging areas of professional education among women, with focus on engineering,<br> technology, applied sciences, management and its allied areas with the objective to achieve excellence in<br> these and related fields.<br><br>Erstwhile Indira Gandhi Institute of Technology (IGIT) was established in 1998 by Directorate of Training and<br>Technical Education, Govt of N.C.T of Delhi as the first engineering college for women only. From 2002- 2013,<br> the college remained the first and only constituent college of Guru Gobind Singh Indraprastha University.<br> <br>The upgradation of IGIT, already a prestigious college of north India, to University has enabled it to function<br>even more efficiently as a teaching and research centre in various branches of engineering, promoting<br> advancement and dissemination of knowledge and learning among women of the country and to meet the<br>requirement of technically skilled women workforce. The objective of the University is to foster industry<br>relevant research and innovations  and empower the women of our country through value based higher<br>education making them employable, self reliant, responsible citizen of the country with concern for<br>environment and society.</body></html>");
        f1.add(p1);
        f1.setVisible(true);
        f1.setSize(1500,800);
        f1.setLocationRelativeTo(null);
        Font fon=new Font("",Font.BOLD,22);
        p1.add(l1);
        l1.setFont(fon);
        l1.setBounds(150,00,1200,700);
        p1.setLayout(null);
    }
    public static void main(String args[])
    {
        aboutcol ab=new aboutcol();
    }
}