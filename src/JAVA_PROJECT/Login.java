package JAVA_PROJECT;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.Container;

public class Login extends JPanel{
	JLabel luser,lpassword,temp;
	JTextField username;
	JPasswordField password;
	JButton submit;
	Container content;
	JTable rform;
	String mailid="";
    Login(Organ_Main f1,LoggedIn f2)
    {
        JPanel pane2=new JPanel();
    	setLayout(null);
    	
        luser = new JLabel("UserId: ");
        username=new JTextField(20);
        luser.setBounds(10,20, 120, 25);
        username.setBounds(150,20,210,25);
        lpassword = new JLabel("Password: ");
        password=new JPasswordField(20);
        lpassword.setBounds(10,60, 120, 25);
        password.setBounds(150,60,210,25);
        password.setEchoChar('*');
        submit = new JButton("Submit");
        submit.setBounds(10,100, 120, 25);
      
        add(luser);
        add(username);
        add(lpassword);
        add(password);
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
        			String pass="";
        			for(int i=0; i<password.getPassword().length; i++)
        				pass=pass+password.getPassword()[i];
        			String query="select * from User where email='"+username.getText().trim()+"' and password='"+pass+"'";
        			
        			rs=st.executeQuery(query);
        			if(rs.next())
        			{
        				f1.setVisible(false);
        				f2.setVisible(true);
        				f2.setTitle("welcome "+username.getText());
        				f2.mailid=username.getText();
        			}
        			else
        			{
        				JOptionPane.showMessageDialog(null,"Invalid UserId or password!","Warning",JOptionPane.WARNING_MESSAGE);
        			}
            		
        		}
        		catch(Exception e)
        		{
        			System.out.println(e);
        		}
        	}
       	});
    }
}