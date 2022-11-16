import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Random;

public class RegistrationForm implements ActionListener {


	
	
	//Container container = getContentPane();

	//JFrame frame = new JFrame();
	//Container container = new Container();
	//JPanel Reg_panel = new JPanel();
	JFrame frame = new JFrame();
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
    JPanel box = new JPanel();

	
	
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
		
		//userLabel.setBounds(550, 350, 100, 30);//was 550, 400
	    //passwordLabel.setBounds(550, 390, 100, 30);//was 50, 220
		
		nameLabel.setBounds(550, 350, 100, 30);
		passwordLabel.setBounds(550, 390, 100, 30);
		confirmPasswordLabel.setBounds(550, 430, 140, 30);
		userNameLabel.setBounds(550, 470, 100, 30);
		
		nameTextField.setBounds(680, 350, 120, 30);
		passwordField.setBounds(680, 390, 120, 30);
		confirmPasswordField.setBounds(680, 430, 120, 30);
		userNameField.setBounds(680, 470, 120, 30);
		
		registerButton.setBounds(550, 510, 250, 30);
		resetButton.setBounds(550,545,250,30);
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
		frame.add(box);
	}
	
	//create user defined method
	public void createWindow() {
		//Setting properties of JFrame
		frame = new JFrame();

		frame.setTitle("Registration Form");
		frame.setBounds(40,40,380,600);
		//frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setBackground(Color.getHSBColor(257,71,100));

		frame.setLayout(null);
		frame.setVisible(true);
        frame.setBounds(0,0, 1366, 1050);
		frame.setResizable(false);
		
		box.setBounds(480, 315, 400, 290);
        box.setBackground(Color.WHITE);

	}
	
	public void actionEvent() {
		//Adding action listener buttons
		registerButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//create database variables
		String databaseURL = "jdbc:mysql://database-1.cojsra38kk1x.us-west-2.rds.amazonaws.com:3306/mydb";
        String user = "root";
        String password = "iVAY65ivErrpcXTr6J9g";
        Connection connection = null;
        
		if(e.getSource() == registerButton) {
			String userText;
            String pwdText;
            String uname;
            String name;
            userText = confirmPasswordField.getText();
            pwdText = passwordField.getText();
            uname = userNameField.getText();
            name = nameTextField.getText();
            int rd = new Random().nextInt(9000) + 1000;
            String ID = ""+rd;
            
            
            if((userText.equals(pwdText)) && (uname.length() > 0) && (name.length() > 0) )
            {				
            	try {    
					//Create Connection Object
				
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(databaseURL, user, password);
				
					if (connection != null) {
						System.out.println("Connected to the database");
					}
				
					//Prepared Statement
					PreparedStatement Pstatement = connection.prepareStatement("insert into Users values (?,?,?,?,?)");
				
					//Specifying parameter values
					Pstatement.setString(1, ID);
					Pstatement.setString(2, nameTextField.getText());
					Pstatement.setString(3, userNameField.getText());
					Pstatement.setString(4, passwordField.getText());
					Pstatement.setString(5, confirmPasswordField.getText());
				
					//check if passwords match
					if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())) {
						//Execute query
						Pstatement.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Registered Successfully");
					}else {
						JOptionPane.showMessageDialog(null, "Password did not match");
					}
				
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
				frame.dispose();
            }
            else if((userText.equals(pwdText))==false)
            {
            	JOptionPane.showMessageDialog(null, "Passwords Do Not Match");
            }
            else if ((uname.length() <= 0))
            {
            	JOptionPane.showMessageDialog(null, "Input Username");
            }
            else if ((name.length() <= 0))
            {
            	JOptionPane.showMessageDialog(null, "Input your Name");
            }
			//frame.setVisible(false);
		}
		if(e.getSource() == resetButton) {
			//Clear fields if user clicks reset button
			nameTextField.setText("");
			userNameField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");
		}
	}
	/*
	public void RegistartionForm() {
		//  Auto-generated method stub
		
			//call method 
			createWindow();
			setLocationAndSize();
			addComponentsToPanel();
			actionEvent();
		
	}
	*/


	
}