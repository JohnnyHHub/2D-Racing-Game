/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.*;
import javax.swing.*;
import java.util.Random;


public class Objects{
 private int x = 200;
 private int y = 800;
 private int x2 = 775;
 private int y2 = 800;


    //method to make player's vehicles
    public void makeVehicle1(Graphics g){
     //set color and use fillRect method to make rectangle.
     //parameter: (x-coordinate, y-coordiante, width, height)
     g.setColor(Color.RED);
     g.fillRect(x,y,50,85);
    }
    public void makeVehicle2(Graphics g){
     g.setColor(new Color(123,64,83));
     g.fillRect(x2,y2,50,85);
    }

    //same with makeVehicle but take up whole left/right sides of screen.
    public void makeLeftGrass(Graphics g){
     g.setColor(new Color(80,200,120));
     g.fillRect(0,0,100,1000);
    }
    public void makeRightGrass(Graphics g){
     g.setColor(new Color(80,200,120));
     g.fillRect(885,0,100,1000);
    }

    //method for object to call when key is pressed to move on screen by returning new x-coordinates..
    //method left()
    //move left by 10 pixel. If current x-coordinates is 100(leftGrass), stop moving.
    public int left(){
        if (x < 100)
         return x = 825;
     return x = x - 10;
    }
    //method right()
    //same as left(). Move right by 10. If x is 815(rightGrass), stop moving.
    public int right(){
        if (x > 825)
         return x =100;
     return x = x + 10;
    }
    //method to move up
    //y stop moving when at pixel 10. Otherwise vehicle object will be cut off from main screen.
    public int up(){
        if (y < 10)
         return y;
     return y = y -10;
    }
    //method to move down
    public int down(){
        if (y > 840)
         return y;
     return y = y +10;
    }

   
    //same set of method as player 1. Have to use 2 seperate sets because each vehicle use different coordinates.
   public int left2(){
        if (x2 < 100)
         return x = 815;
     return x2 = x2 -10;
    }
    public int right2(){
        if (x2 > 815)
         return x2 = 100;
     return x2 = x2 +10;
    }
    public int up2(){
        if (y2 < 10)
         return y2;
     return y2 = y2 -10;
    }
    public int down2(){
        if (y2 > 830)
         return y2;
     return y2 = y2 +10;
    }   
 
    //method to reset vehicle's coordinates after collision.
    public void setCoors(int newX, int newY){
     x = newX;
     y = newY;
    }
    public void setCoors2(int newX, int newY){
     x2 = newX;
     y2 = newY;
    }
    
    //method to retrieve vehicles' coordinates by creating a Rectangle using said coordinates. 
    //when called, return rectangle. Rectangle is then use for comparision for collision.
    public Rectangle getRec2(){
     return (new Rectangle (x2,y2,50,85));
    }
    public Rectangle getRec1(){
     return (new Rectangle (x,y,50,85));
    }
}