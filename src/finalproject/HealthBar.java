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
public class HealthBar {
 private int y;
 private Color c = Color.MAGENTA;

    //method to make HealthBar. Same as making vehicle in Objects class.
    public void makeHealthBar(Graphics g){
     g.setColor(c);
     g.fillRect(910,y,50,25);
    }

    //method to set color of HealthBar.
    public void setColor(Color newC){
    c = newC;    
    }

    //method to set HealthBar Y-coordinate
    public void setY(int newY){
     this.y = newY;
    }
}
