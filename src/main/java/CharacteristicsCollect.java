//package CalorieBuddy;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public class CharacteristicsCollect implements ActionListener {
	JPanel panel = new JPanel();
	JLabel Weight = new JLabel("Weight(Kg): ");
	JLabel Height = new JLabel("Height(Cm): ");
	JLabel Age = new JLabel("Age(yr): ");
	JLabel BMR_User1 = new JLabel("Please fill in The information to find your Basel Metabolic Rate.");
	JLabel BMR_User2 = new JLabel("The body burns calories at a Base Metabolic Rate while it is at rest.");
	JLabel BMR_User3 = new JLabel("Now, please choose and confirm your current lifestyle.");
	JLabel BMR_User4 = new JLabel("This Value is your RMR or Resting Metabolic Rate");
	JLabel BMR_User5 = new JLabel("RMR Is the Number of Calories your body burns while Existing");

	JLabel RMR_Output = new JLabel("Your RMR is: ");
	JLabel BMR_Output = new JLabel("Your BMR Is: ");
	JLabel DCG_Output = new JLabel("Your Daily Caloric Goal Is: ");

	
	JLabel W_Chosen = new JLabel("Women");
	JLabel M_Chosen = new JLabel("Man");

	JTextField Weight_Inp = new JTextField();
	JTextField Height_Inp = new JTextField();
	JTextField Age_Inp = new JTextField();
	
	JButton LS_confirm = new JButton("Confirm");
	JButton BMR = new JButton("Calculate BMR");
	JToggleButton Sex = new JToggleButton("Your Sex Is: ");
	JButton UG_confirm = new JButton("Confirm");
    final Choice c = new Choice();  
    double Calc_BMR;
    double Calc_RMR;
    double Goal_Value;
    
    final Choice g = new Choice();  
    
    
    JLabel BMR_Result = new JLabel();
    JLabel RMR_Result = new JLabel();
    JLabel Caloric_Goal = new JLabel();
    

	JFrame frame = new JFrame();

	
   
	
	CharacteristicsCollect(){
		//call method 
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();

		
	}
	
	
	public void setLocationAndSize() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Weight.setBounds(520, 110, 100,20);
		Height.setBounds(520, 135, 100,20);
		Age.setBounds(545, 160, 100,20);

		panel.setBounds(500, 70, 400, 600);
		
		Weight_Inp.setBounds(600, 110, 100,20);
		Height_Inp.setBounds(600, 135, 100,20);
		Age_Inp.setBounds(600, 160, 100,20);

		BMR.setBounds(725, 110, 150, 25);
		
		Weight.setFont(new Font("Courier", Font.PLAIN, 14)); 
		Height.setFont(new Font("Courier", Font.PLAIN, 14)); 
		Age.setFont(new Font("Courier", Font.PLAIN, 14)); 
		
		BMR_User1.setBounds(520, 170, 400, 50);
		BMR_User2.setBounds(520, 185, 400, 50);
		BMR_User3.setBounds(520, 200, 400, 50);
		
		BMR_User4.setBounds(510, 450, 400,50);
		BMR_User5.setBounds(510, 465, 400, 50);
		
		BMR_User4.setVisible(false);
		BMR_User5.setVisible(false);

		RMR_Output.setBounds(510, 450, 100, 20);
		BMR_Output.setBounds(710, 160, 100,20);
		DCG_Output.setBounds(510, 600, 160,20);
		
		Sex.setBounds(520, 80, 110, 20);
		
		//JLabel W_Chosen = new JLabel("Women");
		//JLabel M_Chosen = new JLabel("Man");
		W_Chosen.setBounds(640, 70, 80, 40);
		M_Chosen.setBounds(640, 70, 80, 40);
		
        M_Chosen.setVisible(false);
		Sex.addItemListener(itemListener);

		c.setBounds(520, 245, 275, 20);
	    c.add("Sedentary (little or no exercise)");
	    c.add("Lightly active (exercise 1 to 3 days/week)");
	    c.add("Moderately active (exercise 3 to 5 days/week)");
	    c.add("Active (exercise 6 to 7 days/week)");
	    c.add("Very active (hard exercise 6 to 7 days/week)");
	    
	    g.setBounds(520, 500, 275,20);
	    g.add("Gain Weight (RMR + 500)");
	    g.add("Maintain Current Weight");
	    g.add("Lose Weight (RMR - 500)");
	    
	    UG_confirm.setBounds(800, 500, 80, 20);
	    LS_confirm.setBounds(800, 245, 80, 20);
	    
	    BMR_Result.setBounds(800, 160, 60, 20);
	    RMR_Result.setBounds(595,450,80,20);
	    
	    Caloric_Goal.setBounds(660, 600, 120, 20);
	}
	
	public void addComponentsToFrame() {
		//frame.add();
		frame.add(Caloric_Goal);
		frame.add(DCG_Output);
		frame.add(BMR_Result);
		frame.add(RMR_Result);
		frame.add(UG_confirm);
		frame.add(LS_confirm);
		frame.add(c);
		frame.add(g);
		frame.add(W_Chosen);
		frame.add(M_Chosen);
		frame.add(Sex);
		frame.add(BMR);
		frame.add(BMR_Output);
		frame.add(BMR_User1);
		frame.add(BMR_User2);
		frame.add(BMR_User3);
		frame.add(BMR_User4);
		frame.add(BMR_User5);
		frame.add(RMR_Output);
		frame.add(Weight);
		frame.add(Height);
		frame.add(Age);
		frame.add(panel);
		frame.add(Weight_Inp);
		frame.add(Height_Inp);
		frame.add(Age_Inp);
	
	}
	
	//create user defined method
	public void createWindow() {
		//Setting properties of JFrame

		frame.setTitle("CharacteristicsCollect");
		frame.setBounds(40,40,380,600);
		//frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setBackground(Color.getHSBColor(257,71,100));

		frame.setLayout(null);
		
		frame.setVisible(true);
        frame.setBounds(0,0, 1366, 1050);
		frame.setResizable(false);
		
		

	}
	
    ItemListener itemListener = new ItemListener() {

	
		public void itemStateChanged(ItemEvent itemEvent)
	    {
	
	        // event is generated in button
	        int state = itemEvent.getStateChange();
	
	        // if selected print selected in console
	        if (state == ItemEvent.SELECTED) {
	            W_Chosen.setVisible(false);
	            M_Chosen.setVisible(true);
	        }
	        else {
	
	        	M_Chosen.setVisible(false);
	            W_Chosen.setVisible(true);
	        }
	    }
    };
	
	public void actionEvent() {
		//Adding action listener buttons
		BMR.addActionListener(this);
		LS_confirm.addActionListener(this);
		UG_confirm.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BMR)
		{
			
			//int();
			String W = Weight_Inp.getText();
			int Weight_Int = Integer.valueOf(W);
			
			String H = Height_Inp.getText();
			int Height_Int = Integer.valueOf(H);
			
			String A = Age_Inp.getText();
			int Age_Int = Integer.valueOf(A);
			//c.getItem(c.getSelectedIndex());
			
			//c.add("Sedentary (little or no exercise)");
		    //c.add("Lightly active (exercise 1 to 3 days/week)");
		    //c.add("Moderately active (exercise 3 to 5 days/week)");
		    //c.add("Active (exercise 6 to 7 days/week)");
		    //c.add("Very active (hard exercise 6 to 7 days/week)");
			if((Weight_Int >0 && Height_Int > 0 && Age_Int > 0)&&(W != "" && H != "" && A != ""))
			{				
				if(W_Chosen.isVisible())//If User is Women
				{//Female: (447.6 + 9.25 x weight in kilograms) + (3.10 x height in centimeters) – (4.33 x age)
					
					Calc_BMR = ((447.6 + 9.25 * Weight_Int)+(3.10 * Height_Int) - (4.33 * Age_Int));
					String b = Double.toString(Calc_BMR);
				    BMR_Result.setText(b);
				}
				else//If User is Man
				{//Male: (88.4 + 13.4 x weight in kilograms) + (4.8 x height in centimeters) – (5.68 x age)

					Calc_BMR = ((88.4 + 13.4 * Weight_Int) + (4.8 * Height_Int) - (5.68 * Age_Int));
					String b = Double.toString(Calc_BMR);
				    BMR_Result.setText(b);		
				}
			}
			else if (W == "")
			{
				JOptionPane.showMessageDialog(null, "Weight Has No Input");
			}
			else if (H == "")
			{
				JOptionPane.showMessageDialog(null, "Height Has No Input");

			}
			else if(A == "")
			{
				JOptionPane.showMessageDialog(null, "Age Has No Input");

			}
			
			
			
		}
		if(e.getSource() == LS_confirm && Calc_BMR != 0)
		{
			Calc_RMR = Calc_BMR;
			if (c.getItem(c.getSelectedIndex()) == "Sedentary (little or no exercise)")
			{
				Calc_RMR *= 1.2;
			}
			else if (c.getItem(c.getSelectedIndex()) == "Lightly active (exercise 1 to 3 days/week)")
			{
				Calc_RMR *= 1.375;

			}
			else if (c.getItem(c.getSelectedIndex()) == "Moderately active (exercise 3 to 5 days/week)")
			{
				Calc_RMR *= 1.55;

			}
			else if (c.getItem(c.getSelectedIndex()) == "Active (exercise 6 to 7 days/week)")
			{
				Calc_RMR *= 1.725;

			}
			else if (c.getItem(c.getSelectedIndex()) == "Very active (hard exercise 6 to 7 days/week)")
			{
				Calc_RMR *= 1.9;

			}
			BMR_User4.setVisible(true);
			BMR_User5.setVisible(true);
		    String r = Double.toString(Calc_RMR);

		    RMR_Result.setText(r);
		}
		if (e.getSource() == UG_confirm && Calc_RMR != 0 && Calc_BMR != 0)
		{
			//g.add("Gain Weight (RMR + 500)");
		    //g.add("Maintain Curret Weight");
		    //g.add("Lose Weight (RMR - 500)");
			Goal_Value = Calc_RMR;
			if(g.getItem(g.getSelectedIndex()) == "Gain Weight (RMR + 500)")
			{
				Goal_Value +=500;
			}
			else if(g.getItem(g.getSelectedIndex()) == "Lose Weight (RMR - 500)")
			{
				Goal_Value -=500;
			}
		    String CG = Double.toString(Calc_RMR);
 
			Caloric_Goal.setText(CG);
			
			
		}

	}
	
}



