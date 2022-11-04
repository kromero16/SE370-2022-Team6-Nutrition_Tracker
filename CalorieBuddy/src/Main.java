import java.sql.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("test123");

        //testing database  connection
        String databaseURL = "jdbc:mysql://localhost";
        String user = "root";
        String password = "admin";
        Connection conn = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
/*
(*jjo

        +import java.awt.event.ActionListener;
        +
        +public class LoginFrame extends JFrame implements ActionListener {
+
        +    Container container = getContentPane();
+    JLabel userLabel = new JLabel("USERNAME");
+    JLabel passwordLabel = new JLabel("PASSWORD");
+    JTextField userTextField = new JTextField();
+    JPasswordField passwordField = new JPasswordField();
+    JButton loginButton = new JButton("LOGIN");
+    JButton resetButton = new JButton("RESET");
+    JCheckBox showPassword = new JCheckBox("Show Password");
+
        +    JPanel box = new JPanel();
+
        +    JPanel boxBackground = new JPanel();
+
        +
        +
        +    LoginFrame() {
        +        setLayoutManager();
        +        setLocationAndSize();
        +        addComponentsToContainer();
        +        addActionEvent();
        +
                +    }
+
        +    public void setLayoutManager() {
        +        container.setLayout(null);
        +    }
+
        +    public void setLocationAndSize() {
        +        userLabel.setBounds(550, 350, 100, 30);//was 550, 400
        +        passwordLabel.setBounds(550, 420, 100, 30);//was 50, 220
        +        userTextField.setBounds(650, 350, 150, 30);
        +        passwordField.setBounds(650, 420, 150, 30);
        +        showPassword.setBounds(650, 450, 150, 30);
        +        loginButton.setBounds(550, 500, 100, 30);
        +        resetButton.setBounds(700, 500, 100, 30);
        +
                +        box.setBounds(480, 300, 400, 290);
        +        box.setBackground(Color.WHITE);
        +
                +        boxBackground.setBounds(480, 300, 410, 300);
        +
                +
                        +        showPassword.setBackground(Color.WHITE);
        +
                +
                        +    }
+
        +    public void addComponentsToContainer() {
        +        container.add(userLabel);
        +        container.add(passwordLabel);
        +        container.add(userTextField);
        +        container.add(passwordField);
        +        container.add(showPassword);
        +        container.add(loginButton);
        +        container.add(resetButton);
        +        container.add(box);
        +
                +    }
+
        +    public void addActionEvent() {
        +        loginButton.addActionListener(this);
        +        resetButton.addActionListener(this);
        +        showPassword.addActionListener(this);
        +    }
+
        +
        +    @Override
+    public void actionPerformed(ActionEvent e) {
        +        //Coding Part of LOGIN button
                +        if (e.getSource() == loginButton) {
            +            String userText;
            +            String pwdText;
            +            userText = userTextField.getText();
            +            pwdText = passwordField.getText();
            +            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
                +                JOptionPane.showMessageDialog(this, "Login Successful");
                +            } else {
                +                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                +            }
            +
                    +        }
        +        //Coding Part of RESET button
                +        if (e.getSource() == resetButton) {
            +            userTextField.setText("");
            +            passwordField.setText("");
            +        }
        +        //Coding Part of showPassword JCheckBox
                +        if (e.getSource() == showPassword) {
            +            if (showPassword.isSelected()) {
                +                passwordField.setEchoChar((char) 0);
                +            } else {
                +                passwordField.setEchoChar('*');
                +            }
            +
                    +
                            +        }
        +    }
+
        +}
Index: CalorieBuddy/src/Registration.java
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
<+>UTF-8
        ===================================================================
        diff --git a/CalorieBuddy/src/Registration.java b/CalorieBuddy/src/Registration.java
        new file mode 100644
        --- /dev/null	(date 1667516884769)
        +++ b/CalorieBuddy/src/Registration.java	(date 1667516884769)
@@ -0,0 +1,87 @@
+import java.util.Scanner;
        +
        +public class Registration {
+
        +    static Register register = new Register();
+
        +    public static void main(String[] args) {
        +
                +        try (Scanner scanner = new Scanner(System.in)) {
            +            System.out.print(" Enter firstName => ");
            +            String firstName = scanner.nextLine();
            +            register.setFirstName(firstName);
            +
                    +            System.out.print(" Enter lastName => ");
            +            String lastName = scanner.nextLine();
            +            register.setLastName(lastName);
            +
                    +            System.out.print(" Enter userName => ");
            +            String userName = scanner.nextLine();
            +            register.setUserName(userName);
            +
                    +            System.out.print(" Enter password => ");
            +            String password = scanner.nextLine();
            +            register.setPassword(password);
            +
                    +            System.out.print(" Enter emailId => ");
            +            String emailId = scanner.nextLine();
            +            register.setEmailId(emailId);
            +
                    +            System.out.print(" Enter phoneNo => ");
            +            long phoneNo = scanner.nextLong();
            +            register.setPhoneNo(phoneNo);
            +
                    +            System.out.println(register.toString());
            +        }
        +    }
+}
+
        +class Register {
+    private String firstName;
+    private String lastName;
+    private String userName;
+    private String password;
+    private String emailId;
+    private long phoneNo;
+    public String getFirstName() {
        +        return firstName;
        +    }
+    public void setFirstName(String firstName) {
        +        this.firstName = firstName;
        +    }
+    public String getLastName() {
        +        return lastName;
        +    }
+    public void setLastName(String lastName) {
        +        this.lastName = lastName;
        +    }
+    public String getUserName() {
        +        return userName;
        +    }
+    public void setUserName(String userName) {
        +        this.userName = userName;
        +    }
+    public String getPassword() {
        +        return password;
        +    }
+    public void setPassword(String password) {
        +        this.password = password;
        +    }
+    public String getEmailId() {
        +        return emailId;
        +    }
+    public void setEmailId(String emailId) {
        +        this.emailId = emailId;
        +    }
+    public long getPhoneNo() {
        +        return phoneNo;
        +    }
+    public void setPhoneNo(long phoneNo) {
        +        this.phoneNo = phoneNo;
        +    }
+    @Override
+    public String toString() {
        +        return "Register [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" +
                +                password + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
        +    }
+}
\ No newline at end of file
        Index: LoginFormDemo.java/src/Main.java
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
<+>UTF-8
        ===================================================================
        diff --git a/LoginFormDemo.java/src/Main.java b/LoginFormDemo.java/src/Main.java
        new file mode 100644
        --- /dev/null	(date 1667431896031)
        +++ b/LoginFormDemo.java/src/Main.java	(date 1667431896031)
@@ -0,0 +1,5 @@
+public class Main {
+    public static void main(String[] args) {
        +        System.out.println("Hello world!");
        +    }
+}
\ No newline at end of file
        Index: LoginFormDemo.java/LoginFormDemo.java.iml
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
<+>UTF-8
        ===================================================================
        diff --git a/LoginFormDemo.java/LoginFormDemo.java.iml b/LoginFormDemo.java/LoginFormDemo.java.iml
        new file mode 100644
        --- /dev/null	(date 1667432563189)
        +++ b/LoginFormDemo.java/LoginFormDemo.java.iml	(date 1667432563189)
@@ -0,0 +1,11 @@
+<?xml version="1.0" encoding="UTF-8"?>
        +<module type="JAVA_MODULE" version="4">
        +  <component name="NewModuleRootManager" inherit-compiler-output="true">
        +    <exclude-output />
        +    <content url="file://$MODULE_DIR$">
        +      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
        +    </content>
        +    <orderEntry type="inheritedJdk" />
        +    <orderEntry type="sourceFolder" forTests="false" />
        +  </component>
        +</module>
        \ No newline at end of file
        Index: CalorieBuddy/src/Login.java
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
        <+>UTF-8
        ===================================================================
        diff --git a/CalorieBuddy/src/Login.java b/CalorieBuddy/src/Login.java
        new file mode 100644
        --- /dev/null	(date 1667538744743)
        +++ b/CalorieBuddy/src/Login.java	(date 1667538744743)
        @@ -0,0 +1,18 @@
        +import javax.swing.*;
        +import java.awt.*;
        +import java.awt.event.ActionEvent;
        +import java.awt.event.ActionListener;
        +
        +public class Login {
        +    public static void main(String[] a) {
        +        LoginFrame frame = new LoginFrame();
        +        frame.setTitle("Login Form");
        +        frame.getContentPane().setBackground(Color.getHSBColor(9,100,66));
        +        frame.setVisible(true);
        +        frame.setBounds(0,0, 1366, 1050);
        +        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        +        frame.setResizable(false);
        +
        +    }
        +
        +}
        \ No newline at end of file
        Index: .idea/modules.xml
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.BaseRevisionTextPatchEP
        <+><?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<project version=\"4\">\r\n  <component name=\"ProjectModuleManager\">\r\n    <modules>\r\n      <module fileurl=\"file://$PROJECT_DIR$/SE370-2022-Team6-Nutrition_Tracker.iml\" filepath=\"$PROJECT_DIR$/SE370-2022-Team6-Nutrition_Tracker.iml\" />\r\n    </modules>\r\n  </component>\r\n</project>
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
        <+>UTF-8
        ===================================================================
        diff --git a/.idea/modules.xml b/.idea/modules.xml
        --- a/.idea/modules.xml	(revision 9adbbb0afc774c58c782f1b171e171ec671cede9)
        +++ b/.idea/modules.xml	(date 1667432563237)
        @@ -2,6 +2,7 @@
        <project version="4">
        <component name="ProjectModuleManager">
        <modules>
        +      <module fileurl="file://$PROJECT_DIR$/LoginFormDemo.java/LoginFormDemo.java.iml" filepath="$PROJECT_DIR$/LoginFormDemo.java/LoginFormDemo.java.iml" />
        <module fileurl="file://$PROJECT_DIR$/SE370-2022-Team6-Nutrition_Tracker.iml" filepath="$PROJECT_DIR$/SE370-2022-Team6-Nutrition_Tracker.iml" />
        </modules>
        </component>
        Index: .idea/misc.xml
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.BaseRevisionTextPatchEP
        <+><?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<project version=\"4\">\r\n  <component name=\"ProjectRootManager\" version=\"2\" project-jdk-name=\"openjdk-19 (2)\" project-jdk-type=\"JavaSDK\">\r\n    <output url=\"file://$PROJECT_DIR$/out\" />\r\n  </component>\r\n</project>
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
        <+>UTF-8
        ===================================================================
        diff --git a/.idea/misc.xml b/.idea/misc.xml
        --- a/.idea/misc.xml	(revision 9adbbb0afc774c58c782f1b171e171ec671cede9)
        +++ b/.idea/misc.xml	(date 1667432563284)
        @@ -1,6 +1,6 @@
        <?xml version="1.0" encoding="UTF-8"?>
        <project version="4">
        -  <component name="ProjectRootManager" version="2" project-jdk-name="openjdk-19 (2)" project-jdk-type="JavaSDK">
        +  <component name="ProjectRootManager" version="2" languageLevel="JDK_19" default="true" project-jdk-name="openjdk-19 (2)" project-jdk-type="JavaSDK">
        <output url="file://$PROJECT_DIR$/out" />
        </component>
        </project>
        \ No newline at end of file
        Index: CalorieBuddy/src/SignUp.java
        IDEA additional info:
        Subsystem: com.intellij.openapi.diff.impl.patch.CharsetEP
        <+>UTF-8
        ===================================================================
        diff --git a/CalorieBuddy/src/SignUp.java b/CalorieBuddy/src/SignUp.java
        new file mode 100644
        --- /dev/null	(date 1667517955091)
        +++ b/CalorieBuddy/src/SignUp.java	(date 1667517955091)
        @@ -0,0 +1,15 @@
        +import javax.swing.*;
        +import java.awt.*;
        +
        +//create NewPage class to create a new page on which user will navigate
        +class NewPage extends JFrame
        +{
        +    //constructor
        +    NewPage()
        +    {
        +        setDefaultCloseOperation(javax.swing.
        +                WindowConstants.DISPOSE_ON_CLOSE);
        +        setTitle("Welcome");
        +        setSize(400, 200);
        +    }
        +}
        \ No newline at end of file

        *)
        */
