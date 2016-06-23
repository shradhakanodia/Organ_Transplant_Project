package JAVA_PROJECT;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.awt.*;

public class Organ_Main extends JFrame{
	Organ_Main(LoggedIn f2)
	{
		super("Index Page");
		Container con=getContentPane();
        JTabbedPane tb=new JTabbedPane();
        HomePage home=new HomePage();
        AboutUs abt=new AboutUs();
        Login login=new Login(this,f2);
	    contact_us cu=new contact_us();
        con.add(tb);
        tb.add("Home",home);
        tb.add("About Us",abt); 
	    tb.add("Login",login);
        tb.add("Contact Us",cu);
	    setSize(1000,1000);
        setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String []args)
    {
        
        LoggedIn loggedpg=new LoggedIn();
        Organ_Main indexpg=new Organ_Main(loggedpg);
		
    }

	}

