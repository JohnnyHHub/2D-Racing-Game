/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.ButtonGroup.*;

/*
Author: Johnny Hoang
*/
public class FinalProject extends JFrame{
 private JTextField enterName1;
 private JTextField enterName2;
 private boolean singleMode;
 private boolean multiMode;

    // main constructor
    public FinalProject()
    {
     JFrame mainScreen = new JFrame("Johnny_FinalProject");
     mainScreen.setBounds(460,250,1000,600);
     mainScreen.setLayout(new BorderLayout(10,20));
     mainScreen.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));

     //game label, increased font size, to be put in NORTH
     JLabel north = new JLabel("Formulae 1 Simulator", SwingConstants.CENTER);
     north.setFont(new Font("Georgia", Font.PLAIN, 60));
     north.setBorder(BorderFactory.createLineBorder(Color.black));

     //panel for mode selection called modeMenu, to be put in another panel named center (not BorderLayout.Center)
     JPanel modeMenu = new JPanel();
     modeMenu.setSize(50,50);
     //set layout of this panel to be FlowLayout
     modeMenu.setLayout(new FlowLayout());
     //create radio buttons, player can only select 1 button. 
     //gives radio buttons names, increase font size, gives border, and background color
     //single player mode, color: GREEN
     JRadioButton single = new JRadioButton("SinglePlayer");
     single.setFont(new Font("Georgia", Font.PLAIN, 40));
     single.setBackground(Color.GREEN);
     //multiplayer mode, color: BLUE
     JRadioButton multi = new JRadioButton("MultiPlayer");
     multi.setFont(new Font("Georgia", Font.PLAIN, 35));
     multi.setBackground(Color.BLUE);
     ButtonGroup modesGroup = new ButtonGroup();
     modesGroup.add(single);
     modesGroup.add(multi);
     modeMenu.add(single);
     modeMenu.add(multi);
//         modeMenu.add(multi);
//         modeMenu.add(endless);

     //create JTextField for user input with default string inside and length of 20. 
     //Also increase font size
     enterName1 = new JTextField("Enter player 1's name",25);
     enterName1.setFont(new Font("Monospaced", Font.PLAIN, 20));
     enterName2 = new JTextField("Enter player 2's name",25);
     enterName2.setFont(new Font("Monospaced", Font.PLAIN, 20));
     //panel for player's inputs called playerMenu, to be put in another panel named center
     //set layout of this panel to also be FlowLayout, add JTextFields
     JPanel playerMenu = new JPanel();
     playerMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 20,0));
     playerMenu.add(enterName1);
     playerMenu.add(enterName2);

     //create center JPanel
     //add previous panels: modeMenu, playerMenu; and JComboBoxes: player1Color, and player2Color.
     //set this panel layout to be FlowLayout, set alighment to CENTER, set horizontal gap between components to 200, vertial gap to 40.
     JPanel center = new JPanel();
     center.setLayout(new FlowLayout(FlowLayout.CENTER, 190,40));
     center.add(modeMenu);
     center.add(playerMenu);

     //create south panel to contain "start" JButton, otherwise JButton will take up whole SOUTH layout
     JPanel south = new JPanel();
     JButton start = new JButton("START");
     start.setFont(new Font("Georgia", Font.PLAIN, 40));
     south.add(start);

     //add north panel, containing game's name
     //add center panel, containing: modeMenu, playerMenu, and player1Color, player2Color.
     //add south panel, containing "start" JButton.
     mainScreen.add(north, BorderLayout.NORTH);
     mainScreen.add(center, BorderLayout.CENTER);
     mainScreen.add(south, BorderLayout.SOUTH);
     mainScreen.setVisible(true);
     mainScreen.setDefaultCloseOperation(mainScreen.EXIT_ON_CLOSE);   

     //add EventListener
     EventListener event = new EventListener();
     single.addActionListener(event);
     multi.addActionListener(event);
     start.addActionListener(event);     
    }

    private class EventListener implements ActionListener{  
    @Override
        //check if user select singleplayer or multiplayer. Change singleMode and multiMode variables for use as conditions later. 
        public void actionPerformed(ActionEvent event){
            if (event.getActionCommand().equals("SinglePlayer")){
             singleMode = true;
             multiMode = false;
            }
            if (event.getActionCommand().equals("MultiPlayer")){
             singleMode = false;
             multiMode = true;
            }

            //conditions and declarations when start button is clicked.
            if (event.getActionCommand().equals("START")){
             /////misc declarations/////
             //get texts JTextFields
             String text = new String(enterName1.getText());
             String text2 = new String(enterName2.getText());
             //create 3 JLabels and a JFrame for use as error PopUp
             JLabel failed0 = new JLabel("You must select a game mode");
             JLabel failed1 = new JLabel("You must enter a name for player 1");
             JLabel failed2 = new JLabel("Both players must have a name");  
             JFrame popUp = new JFrame("Error");
             popUp.setBounds(600,500,400,200);
             popUp.setDefaultCloseOperation(popUp.DISPOSE_ON_CLOSE);
             //////gameWindow declaration//////
             FinalProject_GameWindow game = new FinalProject_GameWindow(false, text,text2);
             FinalProject_GameWindow gameMulti = new FinalProject_GameWindow(true,text,text2);
             JFrame gameWindow = new JFrame();
             gameWindow.setBounds(460,50,1000,1000);
             gameWindow.setDefaultCloseOperation(gameWindow.DISPOSE_ON_CLOSE);
             //////conditions///////
                if (singleMode == true){
                    //check if JTextField has been changed or is not empty.
                    //if true, show error PopUp
                    if (text.equals("Enter player 1's name")||text.length() == 0){
                     popUp.add(failed1);
                     popUp.setVisible(true);
                    }
                    //if false, show gameWindow.
                    else{
                     gameWindow.add(game);
                     gameWindow.setVisible(true);
                    }
                }
                //same as conditions for singleMode but check for both JTextFields
                else if (multiMode == true){
                    if (text.equals("Enter player 1's name")||text.length() == 0||text2.equals("Enter player 2's name")||text2.length() == 0){
                     popUp.add(failed2);
                     popUp.setVisible(true);
                    }
                    else{
                     gameWindow.add(gameMulti);
                     gameWindow.setVisible(true);
                    }
                }
                //if all false then no mode has been selected. Show Error PopUp. 
                else{
                 popUp.add(failed0);
                 popUp.setVisible(true);
                }  
            }
        } 
    }

 // main method
 public static void main(String[] args) {
     FinalProject FinalTest = new FinalProject();
     }
}

