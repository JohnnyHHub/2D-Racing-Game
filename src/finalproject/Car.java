/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Rectangle;

public class Car extends Obstacles {
 private int x;
 private int y = 0;


    //method to make obstacle car.
@Override
    public void makeObstacles(Graphics g){
     g.setColor(Color.BLUE);
     g.fillRect(x,y,50,85);
    }

    //method to be called by Obstacles's abstract methods. Same with other subclasses.
    public void setX(int newX){
     this.x = newX;
    }
     public int down(){
     return y = y +5;
    }  
    public Rectangle getRec(){
     return (new Rectangle(x,y,50,85));
    }
}    