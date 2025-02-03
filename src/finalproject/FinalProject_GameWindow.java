/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.Timer;


/**
 *
 * @author hoang
 */
public class FinalProject_GameWindow extends JPanel{
 //Declare instantces from Objects class
 //boolean multiplayer to toggle multiplayer mode(paint F2 and HealthArray2)
 private boolean multiplayer;
 private String player1Name, player2Name;
 private DashLines Lines = new DashLines();
 private Objects grass2 = new Objects();
 private Objects grass1 = new Objects();
 private Objects F1 = new Objects();
 private Objects F2 = new Objects();
 //ArrayList same as with normal Array[] but can change size.
 private ArrayList ObstaclesArray = new ArrayList();
 private ArrayList LinesArray = new ArrayList();
 private ArrayList HealthArray = new ArrayList();
 private ArrayList HealthArray2 = new ArrayList();
 //timer to check time.
 private Timer timer = new Timer();
 private boolean toggle;

    //parameter multi - enable multiplayer, name1 and name2 - from JTextFields
    public FinalProject_GameWindow(boolean multi, String name1, String name2) {
     this.setFocusable(true);
     KeyListen event = new KeyListen();
     this.addKeyListener(event);
     multiplayer = multi;
     player1Name = name1;
     player2Name = name2;
        //loop to add multiple HealthBar to HealthArray.
        //create rectangle healthbar objects at 200 and 400. Continue adding new objects spaced 30 pixels apart. 
        for (int i = 0, b = 200, c = 400; i < 5; i++, b=b+30, c=c+30){
         HealthBar health = new HealthBar();
         HealthBar health2 = new HealthBar();
         health.setY(b);
         HealthArray.add(health);
         health2.setY(c);
         health2.setColor(Color.PINK);
         HealthArray2.add(health2);
        }
    //timer's schedules
    //timer parameter (TimerTask - method for timer to run , Integer - number of ticks delayed before running method , Integer - number of ticks          //                  between repeat). 
     timer.scheduleAtFixedRate(new CreateObstacles(),0,1000);
     timer.scheduleAtFixedRate(new MoveObjects(),0,50);
     timer.scheduleAtFixedRate(new CreateLines(),0,900);                
    }
    


    //KeyListener class. Implements KeyListener to register which key is pressed.
    private class KeyListen implements KeyListener{
     boolean up,down,left,right;
     boolean up2,down2,left2,right2;
     @Override
        //method to run when key is pressed.
        public void keyPressed(KeyEvent event) {
            //if pressed key is 'up arrow', variable up is true; also check if left is true, if true, object move up and left. If right is true, move                right and up. Else only move up.
            if (event.getKeyCode() == KeyEvent.VK_W){
             up = true;
                if (left == true){
                 F1.up();
                 F1.left();
                }
                else if (right == true){
                 F1.up();
                 F1.right();
                }
            else 
             F1.up();
            }
            //same with up key but replace up with down.
            if (event.getKeyCode() == KeyEvent.VK_S){
             down = true;
                if (left == true){
                 F1.down();
                 F1.left();
                }
                else if (right == true){
                 F1.down();
                 F1.right();
                }
            else 
             F1.down();
            }
            //same with up/down but switch their places with left/right.
            if (event.getKeyCode() == KeyEvent.VK_A){
             left = true;
                if (up == true){
                 F1.left();
                 F1.up();
                }
                else if (down == true){
                 F1.left();
                 F1.down();
                }
            else 
             F1.left();
            }
            //same
            if (event.getKeyCode() == KeyEvent.VK_D){
             right = true;
                if (up == true){
                 F1.right();
                 F1.up();
                }
                else if (down == true){
                 F1.right();
                 F1.down();
                }
            else 
             F1.right();
            }
            /////conditions for player 2 control. Same as Player 1 but use ArrowKeys instead of WASD.
            if (event.getKeyCode() == KeyEvent.VK_UP){
             up2 = true;
                if (left2 == true){
                 F2.up2();
                 F2.left2();
                }
                else if (right2 == true){
                 F2.up2();
                 F2.right2();
                }
            else 
             F2.up2();
            }
            if (event.getKeyCode() == KeyEvent.VK_DOWN){
             down2 = true;
                if (left2 == true){
                 F2.down();
                 F2.left();
                }
                else if (right2 == true){
                 F2.down();
                 F2.right();
                }
            else 
             F2.down();
            }
            if (event.getKeyCode() == KeyEvent.VK_LEFT){
             left2 = true;
                if (up2 == true){
                 F2.left2();
                 F2.up2();
                }
                else if (down2 == true){
                 F2.left2();
                 F2.down2();
                }
            else 
             F2.left2();
            }
            if (event.getKeyCode() == KeyEvent.VK_RIGHT){
             right2 = true;
                if (up2 == true){
                 F2.right2();
                 F2.up2();
                }
                else if (down2 == true){
                 F2.right2();
                 F2.down2();
                }
            else 
             F2.right2();
            }
            if (event.getKeyCode() == KeyEvent.VK_P){
                if (toggle == false){
                 timerPause();
                 toggle = true;
                }
                else if (toggle == true){
                 timerResume();
                 toggle = false;
                } 
            }
        }        
        
    //method when pressed key is released. Chance up/down/left/right and W/A/S/D boolean variables to false
    //so that object will stop moving when key is released.
    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_W){
         up = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_S){
         down = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_A){
         left = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_D) {
         right = false;
        }

        if (event.getKeyCode() == KeyEvent.VK_UP){
         up2 = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN){
         down2 = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT){
         left2 = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
         right2 = false;
        }
    }
    
    public void keyTyped(KeyEvent e) { }
    }    

    //TimerTask. Create lines at the middle of the screen.
    public class CreateLines extends TimerTask{
     @Override
        public void run(){
         //create lines from Dashlines object and add them to ArrayList LinesArray.
         DashLines lines = new DashLines();
         LinesArray.add(lines);
        }
    }


    //TimerTask. "method" for timer to run.Create Obstacles.
    public class CreateObstacles extends TimerTask{
     //RNG will random a number from 0 to 3. Depend on number, create a sub-class object of Obstacle class, set object x to be random from 0 to 800                to be placed randomly on screen. Then add object to Obstacle class ArrayList(ObstaclesArray).   
     Random rng = new Random();
     @Override
        public void run(){
         int type = rng.nextInt(3);
         int initialX = rng.nextInt(800);
            if (type == 0){
             Car obstacleCar = new Car();
             obstacleCar.setX(initialX);
             ObstaclesArray.add(obstacleCar);
            }
            else if (type == 1){
             Cone obstacleCone = new Cone();
             obstacleCone.setX(initialX);
             ObstaclesArray.add(obstacleCone);
            }
            else{
             PotHole obstaclePotHole = new PotHole();
             obstaclePotHole.setX(initialX);
             ObstaclesArray.add(obstaclePotHole);
            }
        }
    }

    //TimerTask. Move obstacles and lines down the JFrame.
    public class MoveObjects extends TimerTask{
    @Override
        //loop through each elements of ObstaclesArray and assign each elements to an Object of Obstacles class. 
        //call method down() from Obstacle class and its subclasses.
        //call method collisionDamage() to check if obstacle hit player.
        public void run(){
            for (int i = 0; i < ObstaclesArray.size();i++){
             Obstacles paintObstacles = (Obstacles)(ObstaclesArray.get(i));
             paintObstacles.down();
             collisionDamage();
            }
            for (int i = 0; i < LinesArray.size(); i++){
             DashLines moveLines = (DashLines) (LinesArray.get(i));
             moveLines.down();
            }
        }
    }

    //method to check for collision.
    public void collisionDamage(){
     //create rectangles using player Objects' coordinates, calling getBounds() method to retrieve coordinates.
     Rectangle rec1 = F1.getRec1();
     Rectangle rec2 = F2.getRec2();
        //loop to create rectangle for every Obstacles in ObstaclesArray using their coordinates.
        for (int i = 0; i < ObstaclesArray.size(); i++){
//         Obstacles obstaclesH = (Obstacles) (ObstaclesArray.get(i));
         Rectangle obstacleRec = ((Obstacles) (ObstaclesArray.get(i))).getRec();
            //condition. Check if player's rectangle intersect with obstacles' retangles. If true then check if HealthArray for player 1 still have                     more than 1 HealthBar. If also true, pause timer, remove 1 HealthBar, reset player's coordinates then resume. 
            if (rec1.intersects(obstacleRec)){
                if (HealthArray.size() > 1){
                 timerPause();
                 HealthArray.remove(0);
                 F1.setCoors(200,800);
                 timerResume();
                }
                //if HealthArray only have 1 HealthBar left(only 1 element left), remove that HealthBar and call method EndGame to end game.
                else if (HealthArray.size() == 1){
                 HealthArray.remove(0);
                 EndGame("player2");                      
                }
            }
            //same as with rectangle for player 1 but for player 2 instead. Only check if game is multiplayer.
            if (multiplayer == true){
                if (rec2.intersects(obstacleRec)){
                    if (HealthArray2.size() > 1){
                     timerPause();
                     HealthArray2.remove(0);
                     F2.setCoors2(700,800);
                     timerResume();
                    }
                    else if (HealthArray2.size() == 1){
                     HealthArray2.remove(0);
                     EndGame("player1");                      
                    }
                }
            }              
        }    
    }

    //methods to pause and resume timer. Java timer cannot pause, only pernamently cancel. 
    //workaround is to create a new timer exactly the same.
    public void timerPause(){
     timer.cancel();
    }
    public void timerResume(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new CreateObstacles(),0,1000);
        timer.scheduleAtFixedRate(new MoveObjects(),0,50);
        timer.scheduleAtFixedRate(new CreateLines(),0,900);
    }

    //method to end the game. String parameter to determine which player won.
    public void EndGame(String player){
     //if paramater is player 1, assign player1Name to winner and create new JLabel with winner. Else, assign player 2 name to winner
     String winner;
     if (player == "player1")
      winner = player1Name;
     else
      winner = player2Name;
     //cancel timer  to stop creating or moving obstacles. SetFocusable to false to stop players from controlling vehicles.
     timer.cancel();
     setFocusable(false);
     JFrame gameOver = new JFrame();
     gameOver.setSize(500,100);
     gameOver.add(new JLabel(" Game's Over, " + winner + " has won. Return to Main Screen to play again."));
     gameOver.setVisible(true);
     gameOver.setDefaultCloseOperation(gameOver.EXIT_ON_CLOSE);
    }
    
    //paint the objects and repaint them.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //loop to paint all lines elements of LinesArray. Must use cast method as element is considered as ArrayList.
        //call method to make Lines from DashLines Class.
        for (int i = 0; i < LinesArray.size();i++){
         DashLines paintLines = (DashLines)(LinesArray.get(i));
         paintLines.makeLines(g);
        }
        //loop similiar with above loop. Get obstacles elements from ObstaclesArray, assign each to a new Obstacles object then paint them using                makeObstacles(Graphics) method from Obstacles class
        for (int i = 0; i < ObstaclesArray.size();i++){
         Obstacles paintObjects = (Obstacles)(ObstaclesArray.get(i));
         paintObjects.makeObstacles(g);
        }
        //create left and right side grasses. call method from Objects class.
        grass1.makeLeftGrass(g);
        grass2.makeRightGrass(g);

        //create player 1 vehicle using method from Objects class. For loop is used to make each HealthBar of HealthArray. 
        F1.makeVehicle1(g);
        for (int i = 0; i < HealthArray.size();i++){
         HealthBar paintHealth = (HealthBar)(HealthArray.get(i));
         paintHealth.makeHealthBar(g);
        }
        //same as player 1 but for player 2, instead.
        if (multiplayer == true){
            F2.makeVehicle2(g);
            for (int i = 0; i < HealthArray2.size();i++){
             HealthBar paintHealth2 = (HealthBar) (HealthArray2.get(i));
             paintHealth2.makeHealthBar(g);
            }
        }
        repaint();
    }      
}

