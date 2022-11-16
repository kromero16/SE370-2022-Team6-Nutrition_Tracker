
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Meal extends MenuFrame{
	JPanel panel = new JPanel();
	JLabel Recipe_Name= new JLabel("Recipe Name: ");
	JLabel Recipe_Calorie= new JLabel("Calories: ");
	JLabel Recipe_Protien= new JLabel("Protien: ");
	JLabel Recipe_Macros= new JLabel("Macros: ");
	JLabel Recipe_Carbo= new JLabel("Carbohydrates: ");
	Meal(){
		//call method 
		PanelsetLocationAndSize();
		PaneladdComponentsToFrame();
	}
	public void PanelsetLocationAndSize() {
		panel.setBounds(0, 0, 100, 100);
		panel.setBackground(Color.RED);
	}
	
	public void PaneladdComponentsToFrame() {
		//Adding components to JFrame
		frame.add(panel);
		
	}
	
}
