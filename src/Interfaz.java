/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author cande
 */
public class Interfaz extends JFrame {
    
    Arbol tree;
    int diametro = 100;
    
    Interfaz(Arbol tree){
        super("canvas");
        this.tree = tree;
        Canvas c = new Canvas(){
            public void paint(Graphics g){
                g.setColor(Color.BLACK);
                g.setFont(new Font("Bold",1,12));
                g.drawString("ADIVINANZA CLIMATICA", 10,30);
                var g2D = (Graphics2D) g;
                dibujarArbol(tree.getRaiz(), g2D, getWidth()/2-10, 60, 0);
                
            }
        };
        
        c.setBackground(Color.white);
        add(c);
        setSize(1920,1080);
        setVisible(true);
        
    }
    
    //int x y y, son la posicion de la raiz
    public void dibujarArbol(Nodo n, Graphics2D g2D, int x, int y, int index){
        
        
        if(n.getIzq() != null){
            int newx = (int) ((int) (x - 450) + ( index * 180) );
            int newy = y+140;
            g2D.setPaint(Color.red);
            g2D.drawLine (x+diametro/2, y, newx, newy);
            dibujarArbol(n.getIzq(), g2D,newx , newy, index +1);
            
        }
        
        if(n.getDer() != null){
            int newx = (int) ((int) (x + 450) - (index * 180));
            int newy = y+140;
            g2D.setPaint(Color.green);
            g2D.drawLine (x+diametro/2, y, newx, newy);
            dibujarArbol(n.getDer(), g2D, newx, newy, index +1);
        }
        
        g2D.setStroke(new BasicStroke(2f));
        g2D.setPaint(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
        g2D.drawOval(x,y,diametro,diametro);
        g2D.drawString(n.getNombre(),x+3,(y+diametro/2)+7);
        
    }
}
