/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author hoang
 */

public class DashLines{
 private int x = 487;
 private int y = 0;
    //methods to create dash lines and move down on JFrame. 
    //same with makeVehicle() in Objects.
    public void makeLines(Graphics g){
     g.setColor(Color.ORANGE);
     g.fillRect(x,y,25,50);
    }
    public int down(){
     return y = y +5;
    }
}