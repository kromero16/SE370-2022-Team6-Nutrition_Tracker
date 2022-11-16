
//package CalorieBuddy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MenuFrame implements ActionListener{
	//Container container = getContentPane();

		//JFrame frame = new JFrame();
		//Container container = new Container();
		//JPanel Reg_panel = new JPanel();
		JFrame frame = new JFrame();
		
		//creating objects

		JTextField Ingredients_Field = new JTextField();
		JButton RecipeButton = new JButton("Create Recipe");
	    JPanel box = new JPanel();
	    JPanel Recipe_Back = new JPanel();
		JScrollBar Recipe_SW = new JScrollBar();
		JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      
		//create constructor
	    MenuFrame(){
			//call method 
			createWindow();
			setLocationAndSize();
			addComponentsToFrame();
			actionEvent();

			
		}
		
		
		public void setLocationAndSize() {
			box.setBounds(480, 315, 400, 290);
	        box.setBackground(Color.WHITE);

			
			Ingredients_Field.setBounds(525, 125, 350,200);
			
			
			RecipeButton.setBounds(525, 340, 250, 30);
			
			box.setBounds(500, 100, 400, 290);
			box.setBorder(new LineBorder(Color.black, 5));
	        box.setBackground(Color.WHITE);
	        
	        //Recipe_SW.setBounds(900, 390, 20, 100);
	        
	        Recipe_Back.setBounds(425, 475, 525, 150);
			Recipe_Back.setBackground(Color.CYAN);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pane.setBounds(1250, 100, 100, 1000);
			
			//Recipe_Back.add(Recipe_SW);
	        //JScrollPane scroller = new JScrollPane(panel);
	        //this.getContentPane().add(scroller, BorderLayout.CENTER);
			


		}
		
		public void addComponentsToFrame() {
			
		    
			frame.add(pane);

			//Adding components to JFrame
			frame.add(Ingredients_Field);
			frame.add(RecipeButton);
			frame.add(Recipe_SW);
			frame.add(box);
			frame.add(Recipe_Back);
			
			
	        
			//frame.add(Recipe_SW);
		}
		
		//create user defined method
		public void createWindow() {
			//Setting properties of JFrame
			frame = new JFrame();

			frame.setTitle("MenuFrame");
			frame.setBounds(40,40,380,600);
			//frame.getContentPane().setBackground(Color.pink);
	        frame.getContentPane().setBackground(Color.getHSBColor(257,71,100));

			frame.setLayout(null);
			
			frame.setVisible(true);
	        frame.setBounds(0,0, 1366, 1050);
			frame.setResizable(false);
			
			

		}
		
	
		public void actionEvent() {
			//Adding action listener buttons
			RecipeButton.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			String Ing;
            Ing = Ingredients_Field.getText();
            if(e.getSource() == RecipeButton)
            {
            	if(Ing.equals(""))
            	{
					JOptionPane.showMessageDialog(null, "Nothing Has Been Entered");
            	}
            	else
            	{
            		frame.dispose();
            		//Meal a = new Meal();
            		
            	}
            	
            	
            }
    
		}
		
}


/*package CalorieBuddy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MenuFrame implements ActionListener{
	//Container container = getContentPane();

		//JFrame frame = new JFrame();
		//Container container = new Container();
		//JPanel Reg_panel = new JPanel();
		JFrame frame = new JFrame();
		
		//creating objects

		JTextField Ingredients_Field = new JTextField();
		JButton RecipeButton = new JButton("Create Recipe");
	    JPanel box = new JPanel();
	    JPanel Recipe_Back = new JPanel();
		JScrollBar Recipe_SW = new JScrollBar();
		JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      
		//create constructor
	    MenuFrame(){
			//call method 
			createWindow();
			setLocationAndSize();
			addComponentsToFrame();
			actionEvent();

			
		}
		
		
		public void setLocationAndSize() {
			box.setBounds(480, 315, 400, 290);
	        box.setBackground(Color.WHITE);

			
			Ingredients_Field.setBounds(525, 125, 350,200);
			
			
			RecipeButton.setBounds(525, 340, 250, 30);
			
			box.setBounds(500, 100, 400, 290);
			box.setBorder(new LineBorder(Color.black, 5));
	        box.setBackground(Color.WHITE);
	        
	        //Recipe_SW.setBounds(900, 390, 20, 100);
	        
	        Recipe_Back.setBounds(425, 475, 525, 150);
			Recipe_Back.setBackground(Color.CYAN);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pane.setBounds(1250, 100, 100, 1000);
			
			//Recipe_Back.add(Recipe_SW);
	        //JScrollPane scroller = new JScrollPane(panel);
	        //this.getContentPane().add(scroller, BorderLayout.CENTER);
			


		}
		
		public void addComponentsToFrame() {
			
		    
			frame.add(pane);

			//Adding components to JFrame
			frame.add(Ingredients_Field);
			frame.add(RecipeButton);
			frame.add(Recipe_SW);
			frame.add(box);
			frame.add(Recipe_Back);
			
			
	        
			//frame.add(Recipe_SW);
		}
		
		//create user defined method
		public void createWindow() {
			//Setting properties of JFrame
			frame = new JFrame();

			frame.setTitle("MenuFrame");
			frame.setBounds(40,40,380,600);
			//frame.getContentPane().setBackground(Color.pink);
	        frame.getContentPane().setBackground(Color.getHSBColor(257,71,100));

			frame.setLayout(null);
			
			frame.setVisible(true);
	        frame.setBounds(0,0, 1366, 1050);
			frame.setResizable(false);
			
			

		}
		
	
		public void actionEvent() {
			//Adding action listener buttons
			RecipeButton.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			String Ing;
            Ing = Ingredients_Field.getText();
            if(e.getSource() == RecipeButton)
            {
            	if(Ing.equals(""))
            	{
					JOptionPane.showMessageDialog(null, "Nothing Has Been Entered");
            	}
            	else
            	{
            		frame.dispose();
            		//Meal a = new Meal();
            		
            	}
            	
            	
            }
    
		}
		
}
*/