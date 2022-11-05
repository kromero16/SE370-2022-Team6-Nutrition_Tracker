package CalorieBuddy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;

public class RegistrationForm implements ActionListener {
	//Create object of JFrame class 
	JFrame frame;
	
	//creating objects
	JLabel nameLabel = new JLabel("NAME");
	JLabel userNameLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
	JTextField nameTextField = new JTextField();
	JTextField userNameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JButton registerButton = new JButton("REGISTER");
	JButton resetButton = new JButton("RESET");
	
	
	//create constructor
	RegistrationForm(){
		//call method 
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	
	public void setLocationAndSize() {
		//Setting Location and Size of each component
		nameLabel.setBounds(20,20,40,70);
		passwordLabel.setBounds(20,170,100,70);
		confirmPasswordLabel.setBounds(20,220,140,70);
		userNameLabel.setBounds(20,64,140,70);
		nameTextField.setBounds(180,43,165,23);
		userNameField.setBounds(180,85,165,23);
		passwordField.setBounds(180,193,165,23);
		confirmPasswordField.setBounds(180,243,165,23);
		registerButton.setBounds(70,400,100,35);
		resetButton.setBounds(220,400,100,35);
	}
	
	public void addComponentsToFrame() {
		//Adding components to JFrame
		frame.add(nameLabel);
		frame.add(userNameLabel);
		frame.add(passwordLabel);
		frame.add(userNameField);
		frame.add(userNameLabel);
		frame.add(confirmPasswordLabel);
		frame.add(nameTextField);
		frame.add(passwordField);
		frame.add(confirmPasswordField);
		frame.add(registerButton);
		frame.add(resetButton);
		
	}
	
	//create user defined method
	public void createWindow() {
		//Setting properties of JFrame
		frame = new JFrame();
		frame.setTitle("Registration Form");
		frame.setBounds(40,40,380,600);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void actionEvent() {
		//Adding action listener buttons
		registerButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//create database variables
		String databaseURL = "jdbc:mysql://database-1.cojsra38kk1x.us-west-2.rds.amazonaws.com";
        String user = "root";
        String password = "iVAY65ivErrpcXTr6J9g";
        Connection connection = null;
        
		if(e.getSource() == registerButton) {
			try {    
				//Create Connection Object
		        Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("databaseURL, user, password");
				
				if (connection != null) {
	                System.out.println("Connected to the database");
	            }
				
				/*//Prepared Statement
				PreparedStatement Pstatement = connection.prepareStatement("insert into Users values (?,?,?,?)");
				
				//Specifying parameter values
				Pstatement.setString(1, nameTextField.getText());
				Pstatement.setString(2, userNameField.getText());
				Pstatement.setString(3, passwordField.getText());
				Pstatement.setString(4, confirmPasswordField.getText());
				
				//check if passwords match
				if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())) {
					//Execute query
					Pstatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Registered Successfully");
				}else {
					JOptionPane.showMessageDialog(null, "Password did not match");
				}*/
				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			catch (ClassNotFoundException ex) {
	            System.out.println("Could not find database driver class");
	            ex.printStackTrace();
	        }
			finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
			
		}
		if(e.getSource() == resetButton) {
			//Clear fields if user clicks reset button
			nameTextField.setText("");
			userNameField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");
		}
	}
}
