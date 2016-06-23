package JAVA_PROJECT;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

	public class AboutUs extends JPanel {
	  
		 
		AboutUs()
       {    
          
           JLabel li=new JLabel("GIFT OF LIFE");
           li.setFont(new Font("Serif", Font.BOLD,40));
           li.setBounds(500,0,10,10);
           li.setForeground(Color.blue);
           final String LONG_TEXT="Gift of life is meant to convey the duality and positivity\n"
                   +"of organ and tissue donation.Through donation, recipients and\n"
                   +"donors live on. Donors live on via a legacy made\n"
                   +"stronger as a result of their donation, and they gift life to others\n";
            JLabel l2=new JLabel("ABOUT ORGAN DONATION");
            l2.setFont(new Font("Serif", Font.ITALIC,28));
            l2.setForeground(Color.green);
            String organ_text="Organ donation is the donation of organs of the human body\n "
            		+"or biological tissue from a living or dead person to a living recipient in need of a transplantation.\n"
            		+"Transplantable organs and tissues are removed in a surgical procedure following\n"
            		+"a determination based on the donor’s medical and social history\n"
            		+"to know which organs are suitable for transplantation.\n";
            JLabel l3=new JLabel("WHAT CAN BE TRANSPLANTED");
            l3.setFont(new Font("Serif", Font.ITALIC,28));
            l3.setForeground(Color.green);
            String what_trans="Different organs such as heart, liver, kidneys and tissues such as corneas and \n"
            		+"bone marrow can now be successfully transplanted into patients, who can then expect to survive\n "
            		+"for years or even decades. It is the treatment of choice for many diseases\n,"
            		+"but all too often, a suitable organ is not available to meet\n "
            		+"the ever-increasing demand for transplantation.\n";
           JTextArea textarea=new JTextArea(LONG_TEXT,6,100);
           textarea.setFont(new Font("Serif", Font.ITALIC, 20));
           textarea.setLineWrap(true);
           textarea.setWrapStyleWord(true);
           textarea.setEditable(false);
           textarea.setOpaque(false);
           textarea.setBorder(new EmptyBorder(2,810,2,2));
           JTextArea textarea2=new JTextArea(organ_text,6,100);
           textarea2.setFont(new Font("Serif", Font.ITALIC, 20));
           textarea2.setLineWrap(true);
           textarea2.setWrapStyleWord(true);
           textarea2.setEditable(false);
           textarea2.setOpaque(false);
           textarea2.setBorder(new EmptyBorder(2,810,2,2));
           JTextArea textarea3=new JTextArea(what_trans,6,100);
           textarea3.setFont(new Font("Serif", Font.ITALIC, 20));
           textarea3.setLineWrap(true);
           textarea3.setWrapStyleWord(true);
           textarea3.setEditable(false);
           textarea3.setOpaque(false);
           textarea3.setBorder(new EmptyBorder(2,810,2,2));
           add(li);
           add(textarea);
           add(l2);
           add(textarea2);
           add(l3);
           add(textarea3);
       }	    
	
	}