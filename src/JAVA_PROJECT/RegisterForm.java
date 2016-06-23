package JAVA_PROJECT;
import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
public class RegisterForm extends JPanel{
    RegisterForm()
    {
        
    	setLayout(null);
  
    	JLabel title1=new JLabel("<html><h1>Hospital Details:</h1></html>");
        add(title1);
        title1.setBounds(300,20,300,50);
        
        JLabel l1=new JLabel("Name");
        JTextField t1=new JTextField(20);
        l1.setBounds(300,80, 120, 25);
        t1.setBounds(407,80,210,25);
        add(l1);
        add(t1);
        
        JLabel l2=new JLabel("Phone Number");
        JTextField t2=new JTextField(10);
        l2.setBounds(300,120, 120,25);
        t2.setBounds(407,120,210,25);
        add(l2);
        add(t2);
        
        JLabel l3=new JLabel("City");
        JTextField t3=new JTextField(20);
        l3.setBounds(300,160,120, 25);
        t3.setBounds(407,160,210,25);
        add(l3);
        add(t3);
        
        JLabel l4=new JLabel("State");
        JTextField t4=new JTextField(20);
        l4.setBounds(300, 200, 120, 25);
        t4.setBounds(407,200,210,25);
        add(l4);
        add(t4);
        
        JLabel title2=new JLabel("<html><h1>Administrator Details:</h1></html>");
        add(title2);
        title2.setBounds(300,260,300,60);
        
        JLabel l5=new JLabel("Name");
        JTextField t5=new JTextField(20);
        l5.setBounds(300,320, 120, 25);
        t5.setBounds(407,320,210,25);
        add(l5);
        add(t5);
        
        JLabel l6=new JLabel("Email Id");
        JTextField t6=new JTextField(20);
        l6.setBounds(300, 360, 120, 25);
        t6.setBounds(407,360,210,25);
        add(l6);
        add(t6);
        
        JLabel l7=new JLabel("Password");
        JPasswordField t7=new JPasswordField(20);
        l7.setBounds(300, 400, 120, 25);
        t7.setBounds(407,400,210,25);
        add(l7);
        add(t7);
        
        
        JButton submit=new JButton("submit");
        submit.setBounds(300,440,120,25);
        add(submit);
        
        submit.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent ae)
        	{
        		try{

        	       
        	        Class.forName("com.mysql.jdbc.Driver");
        		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/OrganRegistry","root","");
        		    if(conn==null)
        		        System.exit(1);
        			Statement st=conn.createStatement();
        			ResultSet rs;
        			int hid=0;
        			String query="select max(hid) as 'hid' from Hospital";
        			rs=st.executeQuery(query);
        			if(rs.next())
        			{	hid=rs.getInt("hid");}
        			
        			hid++;
        			query="select max(uid) as 'uid' from User";
        			rs=st.executeQuery(query);
        			int ud=0;
        			if(rs.next())
        			{	ud=rs.getInt("uid"); }
        			ud++;
        			String pass="";
        			for(int i=0; i<t7.getPassword().length; i++)
        				pass+=t7.getPassword()[i];
        			st.executeUpdate("insert into User values ("+ud+",'"+t5.getText()+"','"+t6.getText()+"','"+pass+"')");
        			String add=t3.getText()+", "+t4.getText();
        			st.executeUpdate("insert into Hospital values ("+hid+",'"+t1.getText()+"','"+t2.getText()+"','"+add+"',"+ud+")");
        			JOptionPane.showMessageDialog(null,"Successfully Registered");
        			t1.setText("");
        			t2.setText("");
        			t3.setText("");
        			t4.setText("");
        			t5.setText("");
        			t6.setText("");
        			t7.setText("");
        			
        		}
        		catch(Exception e)
        		{
        			System.out.println(e);
        		}
        	}
       	});
    }
}