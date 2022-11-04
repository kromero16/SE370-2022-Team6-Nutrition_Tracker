import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
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
            passwordLabel.setBounds(550, 420, 100, 30);//was 50, 220
            userTextField.setBounds(650, 350, 150, 30);
            passwordField.setBounds(650, 420, 150, 30);
            showPassword.setBounds(650, 450, 150, 30);
            loginButton.setBounds(550, 500, 100, 30);
            resetButton.setBounds(700, 500, 100, 30);

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
            container.add(box);
        }

        public void addActionEvent() {
            loginButton.addActionListener(this);
            resetButton.addActionListener(this);
            showPassword.addActionListener(this);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
                //Coding Part of LOGIN button
            if (e.getSource() == loginButton) {
                String userText;
                String pwdText;
                userText = userTextField.getText();
                pwdText = passwordField.getText();
                if (userText.equalsIgnoreCase("MOO") && pwdText.equalsIgnoreCase("123")) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }

            }
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
        }

}