package JAVA_PROJECT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
public class contact_us extends JPanel{
	contact_us()
	{	setLayout(null);
		//JLabel li=new JLabel("CONTACT US");
        //li.setFont(new Font("Serif", Font.BOLD,40));
        //li.setBounds(500,0,40,40);
        //li.setForeground(Color.blue);
        //add(li);
		JLabel li=new JLabel();
		ImageIcon im=new ImageIcon("contactus.png");
		int height=im.getIconHeight();
		int width=im.getIconWidth();
		li.setIcon(im);
		li.setBounds(0+30,0,width,height);
		add(li);
		String phone="Phone No:  99000034565";
		String emailid="EmailId: giftoglife@gmail.com";
		JTextArea textarea=new JTextArea(phone,100,100);
         textarea.setFont(new Font("Serif", Font.BOLD, 40));
         textarea.setEditable(false);
         textarea.setOpaque(false);
         textarea.setBounds(230,300,800,100);
         textarea.setForeground(Color.blue);
         add(textarea);
         JTextArea textarea1=new JTextArea(emailid,100,100);
         textarea1.setFont(new Font("Serif", Font.BOLD, 40));
         textarea1.setEditable(false);
         textarea1.setOpaque(false);
         textarea1.setBounds(180,400,800,100);
         textarea1.setForeground(Color.blue);
         add(textarea1);
       
      	}
	
	}