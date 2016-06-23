package JAVA_PROJECT;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.awt.Container;

public class HomePage extends JPanel{
	
    HomePage()
    {
    	ImageIcon indeximg=new ImageIcon("index1.jpg");
        add(new JLabel(indeximg));
    }
}