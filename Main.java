import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField fahrenheitText;
  JTextField celsiusText;

  JButton firstButton;
  JButton secondButton;

  JPanel mainPanel;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
     
     // initialize the main panel
     mainPanel = new JPanel();
     // turn on the manual layouts 
     mainPanel.setLayout(null);

    // initialize the first label  
    firstLabel = new JLabel("Degrees Fahrenheit");
   // set bounds for the first label 
   firstLabel.setBounds(200,200,300,40);
    secondLabel = new JLabel("Degrees Celsius");
    // set bounds for the second label 
    secondLabel.setBounds(200,250,300,40);

   // initialize the buttons 
   firstButton = new JButton("F -> C");
   //set bounds for the first button 
   firstButton.setBounds(450,210,80,20);
   
   secondButton = new JButton("C -> F");
   secondButton.setBounds(450,260,80,20);
      
   // initialize the first text field
   fahrenheitText = new JTextField();
   // set bounds for the first text field
   fahrenheitText.setBounds(350,210,60,20);
   celsiusText = new JTextField();
   // set bounds for the first text field 
   celsiusText.setBounds(350,260,60,20);

   // set the action command so we know which button was pressed 
   firstButton.setActionCommand("F -> C");
   secondButton.setActionCommand("F -> C");

   // add the action ActionListener
   firstButton.addActionListener(this);
   secondButton.addActionListener(this);

   // add the labels to the main panel
   mainPanel.add(firstLabel);
   mainPanel.add(secondLabel);

   // add the buttons to the main panel 
   mainPanel.add(firstButton);
   mainPanel.add(secondButton);

   // add the text fields to the main panel 
   mainPanel.add(fahrenheitText);
   mainPanel.add(celsiusText);

   
   // add the main panel to the frame screen
    frame.add(mainPanel);


  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  // get the numbers that the user entered to use 
     String fahrenheitFirst = fahrenheitText.getText();
     String celsiusSecond = celsiusText.getText();
     // convert the strings into integers
     double fahrenheitNum = Integer.parseInt(fahrenheitFirst);
     double celsiusNum = Integer.parseInt(celsiusSecond);
     
     
     if (command.equals("F -> C")){
       // fahrenheit to celsius button was pressed 
       
       celsiusNum =  (fahrenheitNum - 32 ) * 5/9;
       
       celsiusText.setText( "" + celsiusNum);

     }else if(command.equals("C -> F")){
       // celsius to fahrenheit button was pressed
       
       fahrenheitNum = (celsiusNum * 9)/ 5 + 32;
    
      fahrenheitText.setText( "" + fahrenheitNum);
     }
     
     

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
