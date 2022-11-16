
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {
    /**
	 * 
	 */

	/**
	 * 
	 */
	Container container = getContentPane();
  //JPanel Login_panel = new JPanel();
    
    int WindowContain = 0;

    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton registerButton = new JButton("CREATE ACCOUNT");

    JCheckBox showPassword = new JCheckBox("Show Password");

    JPanel box = new JPanel();
    JPanel boxBackground = new JPanel();

    
    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
    public void setLocationAndSize() {
        userLabel.setBounds(550, 350, 100, 30);//was 550, 400
        passwordLabel.setBounds(550, 390, 100, 30);//was 50, 220

        userTextField.setBounds(650, 350, 150, 30);
        passwordField.setBounds(650, 390, 150, 30);//was 650, 420

        showPassword.setBounds(650, 420, 150, 30);//650, 450

        loginButton.setBounds(550, 450, 250, 30);//was 550, 500
        resetButton.setBounds(550, 485, 250, 30);//was 700, 500
        registerButton.setBounds(550, 520, 250, 30);//was 750, 500

        box.setBounds(480, 300, 400, 290);
        box.setBackground(Color.WHITE);

        boxBackground.setBounds(480, 300, 410, 300);

        showPassword.setBackground(Color.WHITE);

    }
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(registerButton);
        container.add(box);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        registerButton.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
    	//create database variables
        String databaseURL = "jdbc:mysql://database-1.cojsra38kk1x.us-west-2.rds.amazonaws.com:3306/mydb";
    	String user = "root";
    	String password = "iVAY65ivErrpcXTr6J9g";
    	Connection connection = null;
    	
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
        	String userName = userTextField.getText();
        	String pass = passwordField.getText();
        	
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(databaseURL, user, password);
			
				if (connection != null) {
					System.out.println("Connected to the database login");
				}
			
				//Prepared Statement
				PreparedStatement Pstatement = connection.prepareStatement("Select USERNAME, PASSWRD from Users where USERNAME=? and PASSWRD=?");
				Pstatement.setString(1, userName);
				Pstatement.setString(2, pass);
				
				ResultSet rs = Pstatement.executeQuery();
				if(rs.next()) {
					dispose();
					//create main home page here
					JButton btn = new JButton("TEST");
					JOptionPane.showMessageDialog(btn, "Successfully Logged in");
					MenuFrame a = new MenuFrame();
					//show main menu
				}else {
					JButton btn = new JButton("TEST");
					JOptionPane.showMessageDialog(btn, "Wrong username & password");
				}
				
        	}catch (SQLException sqlException) {
        		sqlException.printStackTrace();
        	}
        	catch(ClassNotFoundException ex) {
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
            
            //container.setVisible(false);
            //LoginAssurance.Assure = true;
            
        
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        if(e.getSource() == registerButton)
        {
            RegistrationForm a = new RegistrationForm();           
        	//package_name.Registration.java
        }
    }
    


}

