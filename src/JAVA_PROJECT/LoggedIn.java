package JAVA_PROJECT;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.awt.*;

public class LoggedIn extends JFrame{
	String mailid="";
	LoggedIn()
	{
		setVisible(false);
		setSize(1000,1000);
		Container content=getContentPane();
		JTabbedPane tb=new JTabbedPane();
		content.add(tb);
		HomePage home=new HomePage();
		OrganAvailability oavail=new OrganAvailability();
		AboutUs abt=new AboutUs();
		//String uname=this.getTitle();
		Donor donor=new Donor(this);
		contact_us cu=new contact_us();
		tb.add("Home",home);
		tb.add("About Us",abt);
		tb.add("Donate Organ",donor);
		tb.add("Organ Availability",oavail);
		tb.add("Contact Us",cu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
	}

