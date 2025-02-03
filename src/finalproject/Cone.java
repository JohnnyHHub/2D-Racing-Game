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
public class Cone extends Obstacles {
 private int x = 0;
 private int y = 0;

    //make cone using drawPolygon.
    //drawPolygon(int[] x, int[]y,int #)
    //initialX is random to appears random on game screen. Randomize is done in FinalProject_GameWindow class.
    //first int array is for x coodinates, second array for y coordinates; last int how many coordinates in an array.
@Override
    public void makeObstacles(Graphics g){
     g.setColor(Color.ORANGE);
     g.fillPolygon(new int[] {x, x +10, x +20},new int[] {y 
        +20, y, y +20},3);
    }

    //methods can be called using Obstacles's abstract methods. Same as other subclasses.
    public void setX(int newX){
     this.x = newX;
    }
    public int down(){
     return y = y +5;
    }  
    public Rectangle getRec(){
     return (new Rectangle(x,y,20,20));
    }
}