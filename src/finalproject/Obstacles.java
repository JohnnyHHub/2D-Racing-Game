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

//Abstract Obstacles class for subclasses to inherit and modify.
//all subclasses is Obstacles class and can be called using the methods below.
public abstract class Obstacles 
{
    public abstract void makeObstacles(Graphics g);
    public abstract int down();
    public abstract void setX(int newX);
    public abstract Rectangle getRec();
}