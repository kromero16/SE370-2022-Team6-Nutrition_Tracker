
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


import com.mashape.unirest.http.exceptions.UnirestException;

public class MenuFrame implements ActionListener{
	
	
	
	//Container container = getContentPane();

		//JFrame frame = new JFrame();
		//Container container = new Container();
		//JPanel Reg_panel = new JPanel();
		JFrame frame = new JFrame();
		
		//creating objects

		int Meal_Counter = 0;
		
		JButton LogOut = new JButton("LOGOUT");
	    
		final Choice R_Search = new Choice();  

		JButton Confirm = new JButton("Confirm");
		JPanel box = new JPanel();
	    
	    JPanel Border = new JPanel();
	    
	    
	    //INT_CG is the initial calorie from the database for the user
	  //create database variables
	    public double getCalorieGoalFromDB(){
	    	String databaseURL = "jdbc:mysql://database-1.cojsra38kk1x.us-west-2.rds.amazonaws.com:3306/mydb";
	    	String user = "root";
	    	String password = "iVAY65ivErrpcXTr6J9g";
	    	Connection connection = null;
	    	double calGoal=0.0;
	    	
	    	try {
				
		    	
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(databaseURL, user, password);
				if (connection != null) {
					System.out.println("Connected to the database MenuFrame");
				}
				//convert goalValue from double to String for DB statement
				
				//create new prepared statement
				PreparedStatement Pstatement = connection.prepareStatement("SELECT GoalValue from mydb.Users WHERE USERNAME=?");
				Pstatement.setString(1, User.userName);
				
				ResultSet res = Pstatement.executeQuery();
				
				if(res.next()) {
					calGoal = res.getDouble(1);

				}
				
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
			catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			finally {
				if(connection != null) {
					try {
						connection.close();
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
	    	
	    	return calGoal;
	    }
        
	    double INT_CG = getCalorieGoalFromDB();
	    
	    //convert to String
	    String CG = (" "+INT_CG);
    	
	    JLabel Int_CG = new JLabel(CG);
		JLabel New_CG = new JLabel(" NEW_CG");
	    JLabel P_Int = new JLabel("Initial Caloric Goal:  ");
	    JLabel P_New = new JLabel("Current Goal: ");
	  
	    
	    
	    String[] Recipe = {"Spicy Tuna Tartare", "Baked Apples in White Wine", "Curried Shrimp with Peanuts",
	    		"Grilled Lamb Chops with Peppercorns and Savory Mint Sauce", "Chocolate Silk Pie with Marshmallow Meringue",
	    		"Steak Salad", "Pecan Sweet Potato Bake", "Healthy Banana Oat Snack Bars", "Savory Sweet Pasta",
	    		"Gluten Free Double Chocolate Black Bean Brownies","Seared Sea Scallops With Mango-melon Salsa", 
	    		"20-minute Skillet Parmesan + Garlic Cauliflower"};
	   	    
	    
	    
	    JPanel Menu_Meals = new JPanel();
	    JPanel Meal_1 = new JPanel();
	    JLabel Meal_1C = new JLabel("Calorie: ");
	    JLabel Meal_1CA = new JLabel("0");
	    JLabel Meal_1T = new JLabel("Recipe Name: ");
	    JLabel Meal_1TA = new JLabel("N/A");
	    
	    JPanel Meal_2 = new JPanel();
	    JLabel Meal_2C = new JLabel("Calorie: ");
	    JLabel Meal_2CA = new JLabel("0");
	    JLabel Meal_2T = new JLabel("Recipe Name: ");
	    JLabel Meal_2TA = new JLabel("N/A");
	    
	    JPanel Meal_3 = new JPanel();
	    JLabel Meal_3C = new JLabel("Calorie: ");
	    JLabel Meal_3CA = new JLabel("0");
	    JLabel Meal_3T = new JLabel("Recipe Name: ");
	    JLabel Meal_3TA = new JLabel("N/A");
	    
	    JPanel Meal_4 = new JPanel();
	    JLabel Meal_4C = new JLabel("Calorie: ");
	    JLabel Meal_4CA = new JLabel("0");
	    JLabel Meal_4T = new JLabel("Recipe Name: ");
	    JLabel Meal_4TA = new JLabel("N/A");
	    
	    JPanel Meal_5 = new JPanel();
	    JLabel Meal_5C = new JLabel("Calorie: ");
	    JLabel Meal_5CA = new JLabel("0");
	    JLabel Meal_5T = new JLabel("Recipe Name: ");
	    JLabel Meal_5TA = new JLabel("N/A");
	    
	    JPanel Meal_6 = new JPanel();
	    JLabel Meal_6C = new JLabel("Calorie: ");
	    JLabel Meal_6CA = new JLabel("0");
	    JLabel Meal_6T = new JLabel("Recipe Name: ");
	    JLabel Meal_6TA = new JLabel("N/A");
	    
		double new_cg = INT_CG;

	    
	    //"C:\Users\Esmeralda\Downloads\cow.png"
	    
	    


	    
	    //JPanel Recipe_Back = new JPanel();
	      
		//create constructor
	    MenuFrame(){
			//call method 
			createWindow();
			setLocationAndSize();
			addComponentsToFrame();
			actionEvent();

			
		}

		
		public void setLocationAndSize() {
			//Ingredients_Field.setHorizontalAlignment(JTextField.);
			// Load the image file into a BufferedImage object
			
			//BufferedImage image = ImageIO.read(new File("/Users/kromero/eclipse-workspace/SE370_Project/src/main/java/pic.png"));
			
			Confirm.setBounds(325, 340, 150, 30);

			Border.setBounds(50, 75, 1250, 600);
			Border.setBackground(null);
			Border.setBorder(new LineBorder(Color.black, 5));

			
			box.setBounds(200, 200, 400, 190);
			box.setBorder(new LineBorder(Color.black, 5));
	        box.setBackground(Color.WHITE);
	        
	        
	        
	        
			R_Search.setBounds(225,225, 350, 20);
			R_Search.add(Recipe[0]);
			R_Search.add(Recipe[1]);
			R_Search.add(Recipe[2]);
			R_Search.add(Recipe[3]);
			R_Search.add(Recipe[4]);
			R_Search.add(Recipe[5]);
			R_Search.add(Recipe[6]);
			R_Search.add(Recipe[7]);
			R_Search.add(Recipe[8]);
			R_Search.add(Recipe[9]);
			R_Search.add(Recipe[10]);
			R_Search.add(Recipe[11]);

			
			LogOut.setBounds(65, 90, 100, 40);
			
			
			Int_CG.setBounds(410, 175, 100,20);
			New_CG.setBounds(900, 175, 100,20);
		    
		    P_Int.setBounds(285, 175, 150, 20);
		    P_New.setBounds(815, 175, 100, 20);

			//Recipe_Field.setAlignmentY(SwingConstants.TOP);
			//Recipe_Field.setAlignmentX(SwingConstants.LEFT);
			Menu_Meals.setBounds(650, 200, 510, 390);
			Menu_Meals.setBorder(new LineBorder(Color.black, 5));
	        Menu_Meals.setBackground(Color.WHITE);

	        Meal_1.setBounds(670, 215, 150, 175);
			Meal_1.setBorder(new LineBorder(Color.black, 5));
	        Meal_1.setBackground(Color.WHITE);
		    Meal_1C.setBounds(680, 220,150, 50);
		    Meal_1T.setBounds(680, 240, 150, 50);
		    Meal_1TA.setBounds(680, 260, 125, 50);//was 250 now 125
		    Meal_1CA.setBounds(730,  220, 150, 50);
		    
	        Meal_2.setBounds(830, 215, 150, 175);
			Meal_2.setBorder(new LineBorder(Color.black, 5));
	        Meal_2.setBackground(Color.WHITE);
	        Meal_2C.setBounds(840, 220,150, 50);
		    Meal_2T.setBounds(840, 240, 150, 50);
		    Meal_2TA.setBounds(840, 260, 125, 50);
		    Meal_2CA.setBounds(890,  220, 150, 50);
		    
	        Meal_3.setBounds(990, 215, 150, 175);
			Meal_3.setBorder(new LineBorder(Color.black, 5));
	        Meal_3.setBackground(Color.WHITE);
	        Meal_3C.setBounds(1000, 220,150, 50);
		    Meal_3T.setBounds(1000, 240, 150, 50);
		    Meal_3TA.setBounds(1000, 260, 125, 50);
		    Meal_3CA.setBounds(1050,  220, 150, 50);
	        
	        Meal_4.setBounds(670, 400, 150, 175);
			Meal_4.setBorder(new LineBorder(Color.black, 5));
	        Meal_4.setBackground(Color.WHITE);
	        Meal_4C.setBounds(680, 400,150, 50);
		    Meal_4T.setBounds(680, 420, 150, 50);
		    Meal_4TA.setBounds(680, 440, 125, 50);
		    Meal_4CA.setBounds(730,  400, 150, 50);
	        
	        Meal_5.setBounds(830, 400, 150, 175);
			Meal_5.setBorder(new LineBorder(Color.black, 5));
	        Meal_5.setBackground(Color.WHITE);
	        Meal_5C.setBounds(840, 400,150, 50);
		    Meal_5T.setBounds(840, 420, 150, 50);
		    Meal_5TA.setBounds(840, 440, 125, 50);
		    Meal_5CA.setBounds(890,  400, 150, 50);
		    
	        Meal_6.setBounds(990, 400, 150, 175);
			Meal_6.setBorder(new LineBorder(Color.black, 5));
	        Meal_6.setBackground(Color.WHITE);
	        Meal_6C.setBounds(1000, 400,150, 50);
		    Meal_6T.setBounds(1000, 420, 150, 50);
		    Meal_6TA.setBounds(1000, 440, 125, 50);
		    Meal_6CA.setBounds(1050,  400, 150, 50);
			/*
			JPanel Menu_Meals = new JPanel();
		    JPanel Meal_1 = new JPanel();
		    JPanel Meal_2 = new JPanel();
		    JPanel Meal_3 = new JPanel();
		    JPanel Meal_4 = new JPanel();
		    JPanel Meal_5 = new JPanel();
		    JPanel Meal_6 = new JPanel();
	       */
		    Meal_1TA.setVisible(false);
		    Meal_1CA.setVisible(false);
		    Meal_2TA.setVisible(false);
		    Meal_2CA.setVisible(false);
		    Meal_3TA.setVisible(false);
		    Meal_3CA.setVisible(false);
		    Meal_4TA.setVisible(false);
		    Meal_4CA.setVisible(false);
		    Meal_5TA.setVisible(false);
		    Meal_5CA.setVisible(false);
		    Meal_6TA.setVisible(false);
		    Meal_6CA.setVisible(false);
		    
	        //Recipe_Back.setBounds(425, 475, 525, 150);
			//Recipe_Back.setBackground(Color.RED);
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//pane.setBounds(1250, 100, 100, 1000);
			
			//Recipe_Back.add(Recipe_SW);
	        //JScrollPane scroller = new JScrollPane(panel);
	        //this.getContentPane().add(scroller, BorderLayout.CENTER);
			

			
		}
		
		public void addComponentsToFrame() {
			//Adding components to JFrame
			frame.add(Meal_1T);
			frame.add(Meal_1C);
			frame.add(Meal_1TA);
			frame.add(Meal_1CA);
			frame.add(Meal_1);
			
			frame.add(Meal_2T);
			frame.add(Meal_2C);
			frame.add(Meal_2TA);
			frame.add(Meal_2CA);
			frame.add(Meal_2);
			
			frame.add(Meal_3T);
			frame.add(Meal_3C);
			frame.add(Meal_3TA);
			frame.add(Meal_3CA);
			frame.add(Meal_3);
			
			frame.add(Meal_4T);
			frame.add(Meal_4C);
			frame.add(Meal_4TA);
			frame.add(Meal_4CA);
			frame.add(Meal_4);
			
			frame.add(Meal_5T);
			frame.add(Meal_5C);
			frame.add(Meal_5TA);
			frame.add(Meal_5CA);
			frame.add(Meal_5);
			
			frame.add(Meal_6T);
			frame.add(Meal_6C);
			frame.add(Meal_6TA);
			frame.add(Meal_6CA);
			frame.add(Meal_6);
			
			frame.add(New_CG);
			frame.add(Int_CG);
			frame.add(P_Int);
			frame.add(P_New);
			
			
			frame.add(Menu_Meals);
			frame.add(LogOut);
			//frame.add(Ingredients_Field);
			frame.add(Confirm);
			frame.add(R_Search);

			frame.add(box);

			frame.add(Border);


			
			//frame.add(Recipe_Back);
	        
			//frame.add(Recipe_SW);
			
		}
		
		//create user defined method
		public void createWindow() {
			//Setting properties of JFrame
			frame = new JFrame();

			frame.setTitle("Calories");
			frame.setBounds(40,40,380,600);
			//frame.getContentPane().setBackground(Color.pink);
	        frame.getContentPane().setBackground(Color.getHSBColor(300,290,100));

			frame.setLayout(null);
			
			frame.setVisible(true);
	        frame.setBounds(0,0, 1366, 1050);
			frame.setResizable(false);
			
			

		}
		
	
		public void actionEvent() {
			//Adding action listener buttons
			Confirm.addActionListener(this);
			LogOut.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			//declare calorie varibles to save calorie double value
			double calorie_1TA = 0.0;
			String calorieString_1TA="";
			
			double calorie_2TA = 0.0;
			String calorieString_2TA="";
			
			double calorie_3TA = 0.0;
			String calorieString_3TA="";
			
			double calorie_4TA = 0.0;
			String calorieString_4TA="";
			
			double calorie_5TA = 0.0;
			String calorieString_5TA="";
			
			double calorie_6TA = 0.0;
			String calorieString_6TA="";
			
			if(e.getSource() == LogOut)
			{
				frame.dispose();
			}
				
			if(e.getSource() == Confirm)
			{
				if(Meal_Counter < 5 || new_cg > 0)
				{
				//if (R_Search.getItem(R_Search.getSelectedIndex()) == Recipe[0])
					
					if(Meal_1TA.getText() == "N/A")
					{
						/*
						 
						 */
						Meal_1TA.setText(R_Search.getItem(R_Search.getSelectedIndex()));
						Meal_1TA.setVisible(true);
					    Meal_1CA.setVisible(true);
					    
					    try {
					    	//Create object to call API for nutrition info
					    	NutritionInfo a = new NutritionInfo();
					    	
					    	//Create string to save JSON string from API response
					    	String js = a.getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
					    	
					    	//save calorie from parsed JSON object
					    	calorie_1TA = a.getCalories(js);
					    	
					    	//convert to string to print to menuframe
					    	calorieString_1TA = (""+calorie_1TA);
					    	
							//new NutritionInfo().getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//Meal_1CA is the parameter for the Caloric number so your gonna set the text of this JLabel
						//to the Caloric Value in the API
//					    double INT_CG = getCalorieGoalFromDB();
						//New_CG'
					    new_cg -= calorie_1TA;
					    String Meal_1UG = (""+new_cg);
					    New_CG.setText(Meal_1UG);
					    
					    Meal_1CA.setText(calorieString_1TA);
					    
					}
					else if(Meal_2TA.getText() == "N/A")
					{
						Meal_2TA.setText(R_Search.getItem(R_Search.getSelectedIndex()));
						Meal_2TA.setVisible(true);
					    Meal_2CA.setVisible(true);
						
						try {
							NutritionInfo b = new NutritionInfo();
							String js = b.getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
							
							calorie_2TA = b.getCalories(js);
							
							calorieString_2TA = (""+calorie_2TA);
							
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//Meal_2CA is the parameter for the Caloric number so your gonna set the text of this JLabel
						//to the Caloric Value in the API
						
						new_cg -= calorie_2TA;
					    String Meal_2UG = (""+new_cg);
					    New_CG.setText(Meal_2UG);
						Meal_2CA.setText(calorieString_2TA);
					}
					else if(Meal_3TA.getText() == "N/A")
					{
						Meal_3TA.setText(R_Search.getItem(R_Search.getSelectedIndex()));
						Meal_3TA.setVisible(true);
					    Meal_3CA.setVisible(true);
						
						try {
							NutritionInfo c = new NutritionInfo();
							String js = c.getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
							
							calorie_3TA = c.getCalories(js);
							
							calorieString_3TA = (""+calorie_3TA);
							
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//Meal_3CA is the parameter for the Caloric number so your gonna set the text of this JLabel
						//to the Caloric Value in the API
						new_cg -= calorie_3TA;
					    String Meal_3UG = (""+new_cg);
					    New_CG.setText(Meal_3UG);
						
						Meal_3CA.setText(calorieString_3TA);
					}
					else if(Meal_4TA.getText() == "N/A")
					{
						Meal_4TA.setText(R_Search.getItem(R_Search.getSelectedIndex()));
						Meal_4TA.setVisible(true);
					    Meal_4CA.setVisible(true);
					    
						try {
							NutritionInfo d = new NutritionInfo();
							String js = d.getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
							calorie_4TA = d.getCalories(js);
							
							calorieString_4TA = (""+calorie_4TA);
							
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//Meal_4CA is the parameter for the Caloric number so your gonna set the text of this JLabel
						//to the Caloric Value in the API
						new_cg -= calorie_4TA;
					    String Meal_4UG = (""+new_cg);
					    New_CG.setText(Meal_4UG);
						
						Meal_4CA.setText(calorieString_4TA);
					}
					else if(Meal_5TA.getText() == "N/A")
					{
						Meal_5TA.setText(R_Search.getItem(R_Search.getSelectedIndex()));
						Meal_5TA.setVisible(true);
					    Meal_5CA.setVisible(true);
					    
					    
						try {
							NutritionInfo e_1 = new NutritionInfo();
							String js = e_1.getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
							
							calorie_5TA = e_1.getCalories(js);
							
							calorieString_5TA = (""+calorie_5TA);
							
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//Meal_5CA is the parameter for the Caloric number so your gonna set the text of this JLabel
						//to the Caloric Value in the API
						new_cg -= calorie_5TA;
					    String Meal_5UG = (""+new_cg);
					    New_CG.setText(Meal_5UG);
						
						Meal_5CA.setText(calorieString_5TA);
					}
					else if(Meal_6TA.getText() == "N/A")
					{
						Meal_6TA.setText(R_Search.getItem(R_Search.getSelectedIndex()));
						Meal_6TA.setVisible(true);
					    Meal_6CA.setVisible(true);
					    
					    
						try {
							NutritionInfo f = new NutritionInfo();
							String js = f.getNutrInfo(R_Search.getItem(R_Search.getSelectedIndex()));
							
							calorie_6TA = f.getCalories(js);
							
							calorieString_6TA = (""+calorie_6TA);
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//Meal_6CA is the parameter for the Caloric number so your gonna set the text of this JLabel
						//to the Caloric Value in the API
						Meal_6CA.setText(calorieString_6TA);
						new_cg -= calorie_6TA;
					    String Meal_6UG = (""+new_cg);
					    New_CG.setText(Meal_6UG);
					}
					
						
					//}
					Meal_Counter +=1;
					
					
					
				}
				else
				{
					JButton btn2 = new JButton("TEST");
					JOptionPane.showMessageDialog(btn2, "Caloric Goal Met");
				}
				
			}

		}
	
}
