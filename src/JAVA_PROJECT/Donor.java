package JAVA_PROJECT;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class Donor extends JPanel{
    Donor(LoggedIn ld)
    {
        setLayout(null);     
           
        JLabel title1=new JLabel("<html><h1>Donor/Receiver Details:</h1></html>");
        add(title1);
        title1.setBounds(300,20,350,50);
        
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
        
       
        JLabel l5=new JLabel("Organs");
        l5.setBounds(300, 240, 126, 25);
        add(l5);
        JComboBox cb=new JComboBox();
        cb.addItem("Liver");
        cb.addItem("Heart");
        cb.addItem("Lungs");
        cb.addItem("Kidney");
        cb.setBounds(410, 240, 120, 25);
        add(cb);
 
        JLabel l6=new JLabel("Blood Group");
        String bgroup[]={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
    	JComboBox c1=new JComboBox(bgroup); 
    	l6.setBounds(300,280, 120,25);
        c1.setBounds(407,280,210,25);
        add(l6);
        add(c1);
       
        JLabel l7=new JLabel("Patient type");
        String group[]={"donate","receive"};
    	JComboBox c2=new JComboBox(group); 
    	l7.setBounds(300,320, 120,25);
        c2.setBounds(407,320,210,25);
        add(l7);
        add(c2);
        
        JButton submit=new JButton("submit");
        submit.setBounds(300,360,120,25);
        add(submit);
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)throws NumberFormatException
            {
                try{
                	int flag=0;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/OrganRegistry","root","");
                    if(conn==null)
                        System.exit(1);
                    //int did=1;
                    Statement st=conn.createStatement();
                    ResultSet rs;
              
                    String addr=t3.getText()+", "+t4.getText();
                    String query="select max(pid) as 'pid' from `donor/receiver`";
        			rs=st.executeQuery(query);
        			int pid=0;
        			if(rs.next())
        			pid=rs.getInt("pid");  			
        			pid++;
        			String bgrp=(String)c1.getSelectedItem();
        			String organ=(String)cb.getSelectedItem();
        			ResultSet rstemp=st.executeQuery("SELECT hid as 'hid' FROM Hospital, User where Hospital.uid=User.uid and email='"+ld.mailid+"'");
        			String hosp="";
       				if(rstemp.next())
        				hosp=rstemp.getString("hid");
       				rstemp=st.executeQuery("select count as 'count' from Organ where hid="+Integer.parseInt(hosp)+" and kind='"+organ+"' and bgroup='"+bgrp+"'");
       				int count=0;
       				if(rstemp.next())
       					count=rstemp.getInt("count");
       				
       				if(c2.getSelectedItem()=="receive")
        			{
       				if(count<=0)
       					{
       					flag=1;
       					JOptionPane.showMessageDialog(null,"organ not available in this hospital","Sorry!",JOptionPane.INFORMATION_MESSAGE);
       					}
                	}
       				
        			if(flag!=1)
        			{
        				st.executeUpdate("insert into `donor/receiver` values ("+pid+",'"+t1.getText().trim()+"','"+t2.getText().trim()+"','"+addr+"','"+c1.getSelectedItem()+"','"+cb.getSelectedItem()+"','"+c2.getSelectedItem()+"')");
        				if(c2.getSelectedItem()=="donate")
        					{
        							count++;
        							st.executeUpdate("update Organ set count="+count+" where kind='"+organ+"' and bgroup='"+bgrp+"' and hid="+Integer.parseInt(hosp)+"");
        					
        					}
        				else if(c2.getSelectedItem()=="receive")
        				{
        					count--;
        					st.executeUpdate("update Organ set count="+count+" where kind='"+organ+"' and bgroup='"+bgrp+"' and hid="+Integer.parseInt(hosp)+"");
        				}
        				
        				JOptionPane.showMessageDialog(null,"Successfull");
        			}
        			t1.setText("");
    				t2.setText("");
    				t3.setText("");
    				t4.setText("");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

            }
        });       
    }
}