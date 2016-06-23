package JAVA_PROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class OrganAvailability extends JPanel implements ActionListener{

	JButton kidney,liver,lung,heart;
	JButton b1,b2,b3,b4;
	ImageIcon ikidney=new ImageIcon("kidney.jpg");
	ImageIcon iliver=new ImageIcon("liver.jpg");
	ImageIcon ilung=new ImageIcon("lung.jpg");
	ImageIcon iheart=new ImageIcon("heart.jpg");
		OrganAvailability()
		{
			setLayout(null);
			kidney=new JButton(ikidney);
			liver=new JButton(iliver);
			lung=new JButton(ilung);
			heart=new JButton(iheart);
			kidney.setBounds(05,20 ,250 ,250 );
			liver.setBounds(255,20 ,250 ,250);
			lung.setBounds(505,20 ,250 ,250 );
			heart.setBounds(750,20 ,250 ,250 );
		    add(kidney);
	        add(liver);
	        add(lung);
	        add(heart);
	        b1=new JButton("Kidney Availability");
	        b2=new JButton("Liver Availability");
	        b3=new JButton("Lung Availability");
	        b4=new JButton("Heart Availability");
	        b1.setBounds(15,280,200,25);
	        b2.setBounds(275,280,200,25);
	        b3.setBounds(535,280,200,25);
	        b4.setBounds(775,280,200,25);
	        add(b1);
	        add(b2);
	        add(b3);
	        add(b4);
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        b4.addActionListener(this);
	        kidney.addActionListener(this);
	        liver.addActionListener(this);
	        lung.addActionListener(this);
	        heart.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
	    {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/OrganRegistry","root","");
			Statement st=conn.createStatement();
			if(conn==null)
				System.exit(1);
			ResultSet rs;
			int size=0;
			rs=st.executeQuery("select count(name) as count from Hospital");
	        if(rs.next())
	        	size=rs.getInt("count");
	        JPanel temp=new JPanel();
	    	JLabel bg,hosp,lb;
	    	bg=new JLabel("Blood Group");
	    	hosp=new JLabel("Hospital");
	    	String bgroup[]={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
	    	JComboBox bgt=new JComboBox(bgroup);
	    	JComboBox hp=new JComboBox();
    	        int i=0;
	        rs=st.executeQuery("select name from Hospital");
	        while(rs.next())
	        {
	        	hp.addItem(rs.getString("name"));
	        }
	        temp.setLayout(new GridLayout(3,0));
	        temp.add(bg);
	        temp.add(bgt);
	        temp.add(hosp);
	        temp.add(hp);
	        lb=new JLabel("Click 'next' for Organ Information");
	        temp.add(lb);
	        
	    	if(ae.getSource()==b1 || ae.getSource()==kidney)
	    	{
	    		rs=st.executeQuery("SELECT sum(count) as total FROM Organ where kind='kidney';");
	    		String str="";
	    		if(rs.next())
	    		{
	    			int tot=rs.getInt("total");
	    			str="Total number of kidney's available :"+" "+tot;
	    		}
	    		String options[]={"next","cancel"};
	    		int response=JOptionPane.showOptionDialog(null, str, "Kidney Availability", 0, 0, ikidney, options, "next");
	    	    if(response==0)
	    	    {
	    	        int resp2=JOptionPane.showOptionDialog(this, temp, "Kidney Availability", 0,0,ikidney, options, "next");
	    	        if(resp2==0)
	    	        {rs=st.executeQuery("select sum(count) as total from Organ, Hospital where Organ.hid=Hospital.hid and kind='kidney' and bgroup='"+bgt.getSelectedItem()+"' and name='"+hp.getSelectedItem()+"'");
	    	        if(rs.next())
	    	        {
	    	        	int no;
	    	        	if((no=rs.getInt("total"))>0)
	    	        	str="Kidney for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is available";
	    	        	else
	    	        		str="Kidney for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is unavailable";
	    	         
	    	        JOptionPane.showMessageDialog(this, str);
	    	        }}
	    	    }
	    	    System.out.println(bgt.getSelectedItem()+" "+hp.getSelectedItem());
	    	}
	    	else if(ae.getSource()==b2 || ae.getSource()==liver)
	    	{
	    		rs=st.executeQuery("SELECT sum(count) as total FROM Organ where kind='liver'");
	    		String str="";
	    		if(rs.next())
	    		{
	    			int tot=rs.getInt("total");
	    			str="Total number of liver's available :"+" "+tot;
	    		}
	    		String options[]={"next","cancel"};
	    		int response=JOptionPane.showOptionDialog(null, str, "Liver Availability", 0, 0,iliver, options, "next");
	    	    if(response==0)
	    	    {
	    	    	int resp2=JOptionPane.showOptionDialog(this, temp, "Liver Availability", 0,0,iliver, options, "next");
	    	    	if(resp2==0){
	    	    	rs=st.executeQuery("select sum(count) as total from Organ, Hospital where Organ.hid=Hospital.hid and kind='liver' and bgroup='"+bgt.getSelectedItem()+"' and name='"+hp.getSelectedItem()+"'");
	    	        if(rs.next())
	    	        {
	    	        	int no;
	    	        	if((no=rs.getInt("total"))>0)
	    	        	str="Liver for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is available";
	    	        	else
	    	        		str="Liver for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is unavailable";
	    	         
	    	        JOptionPane.showMessageDialog(this, str);
	    	        }}
	    	    }
	    	}
	    	else if(ae.getSource()==b3 || ae.getSource()==lung)
	    	{
	    		rs=st.executeQuery("SELECT sum(count) as total FROM Organ where kind='Lungs'");
	    		String str="";
	    		if(rs.next())
	    		{
	    			int tot=rs.getInt("total");
	    			str="Total number of lung's available :"+" "+tot;
	    		}
	    		String options[]={"next","cancel"};
	    		int response=JOptionPane.showOptionDialog(null, str, "Lungs Availability", 0, 0, ilung, options, "next");
	    	    if(response==0)
	    	    {
	    	    	int resp2=JOptionPane.showOptionDialog(this, temp, "Lungs Availability", 0,0,ilung, options, "next");
	    	    	if(resp2==0){
	    	    	rs=st.executeQuery("select sum(count) as total from Organ, Hospital where Organ.hid=Hospital.hid and kind='Lungs' and bgroup='"+bgt.getSelectedItem()+"' and name='"+hp.getSelectedItem()+"'");
	    	        if(rs.next())
	    	        {
	    	        	int no;
	    	        	if((no=rs.getInt("total"))>0)
	    	        	str="Lungs for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is available";
	    	        	else
	    	        		str="Lungs for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is unavailable";
	    	         
	    	        JOptionPane.showMessageDialog(this, str);
	    	        }}
	    	    }
	    	}
	    	else if(ae.getSource()==b4 || ae.getSource()==heart)
	    	{
	    		rs=st.executeQuery("SELECT sum(count) as total FROM Organ where kind='heart'");
	    		String str="";
	    		if(rs.next())
	    		{
	    			int tot=rs.getInt("total");
	    			str="Total number of heart's available :"+" "+tot;
	    		}
	    		String options[]={"next","cancel"};
	    		int response=JOptionPane.showOptionDialog(null, str, "Heart Availability", 0, 0, iheart, options, "next");
	    	    if(response==0)
	    	    {
	    	    	int resp2=JOptionPane.showOptionDialog(this, temp, "Heart Availability", 0,0,iheart, options, "next");
	    	        if(resp2==0)
	    	    	{rs=st.executeQuery("select sum(count) as total from Organ, Hospital where Organ.hid=Hospital.hid and kind='heart' and bgroup='"+bgt.getSelectedItem()+"' and name='"+hp.getSelectedItem()+"'");
	    	        if(rs.next())
	    	        {
	    	        	int no;
	    	        	if((no=rs.getInt("total"))>0)
	    	        	str="Heart for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is available";
	    	        	else
	    	        		str="Heart for blood group: "+bgt.getSelectedItem()+" \nin hosiptal: "+hp.getSelectedItem()+" is unavailable";
	    	         
	    	        JOptionPane.showMessageDialog(this, str);
	    	        }}
	    	    }
	    	}
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
	    }
}
