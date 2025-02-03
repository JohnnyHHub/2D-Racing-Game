/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
/**
 *
 * @author hoang
 */
public class PotHole extends Obstacles{
 private int x;
 private int y;

    //method to make pothole.
    //fillOval(int a, int b, x,y);
    //a is width, b is height. x,y is coordinates; x is randomized to appear randomly.
@Override
    //method is named makeObstacles because it is inherited from Obstacles abstract class.
    //when an object of PotHole class calls the method, it will call this method.  
    public void makeObstacles(Graphics g){
     g.setColor(Color.DARK_GRAY);
     g.fillOval(x,y,25,25);
    }

    //methods to: SetX with number generated randomly in FinalProject_GameWindow class.
    //            Move obstacle down by increasing y value by 5. 
    //            Create rectangle using obstacle's coordinates. For use in CollisionDamage() method.
    //Same as with other subclasses of Obstacles.
    public void setX(int newX){
     this.x = newX;
    }
    public int down(){
     return y = y +5;
    }   
    public Rectangle getRec(){
     return (new Rectangle(x,y,25,25));
    }
}