/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils.view;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author test
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;
    private int bwidth= 100;
    private int bheight= 25;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
            
            createButtons();
        
        frame.add(canvas);
        frame.pack();
    }
    
    private void createButtons(){
         JButton b = new JButton("Disable middle button");
         b.setBounds(50, 50, bwidth, bheight);
         frame.add(b);
    }
    
    private void loginDisplay(){
    
    }
    
    private void dataDisplay(){
        
    }

    public Canvas getCanvas(){
        return canvas;
    } 
}

