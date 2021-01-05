package com.codewithkapil.Play;

import org.newdawn.slick.SlickException;

import javax.swing.*;
import java.awt.*;


public class ProgressBar {
    public static JLabel l;
    public  static JProgressBar p;
    public static JFrame f;
    public ProgressBar(){


        f = new JFrame("Progress");
        f.setResizable(false);
        f.setSize(400,300);
        f.setBounds(0,0,400,300);
        f.setVisible(true);
        f.setLayout(null);

        l = new JLabel();
        l.setBounds(f.getWidth()/3,80,200,30);
        l.setForeground(Color.red);
        l.setFont(new Font("times",Font.BOLD,20));
        f.add(l);



        p = new JProgressBar();
        p.setValue(0);

        p.setStringPainted(true);
        p.setSize(300,30);
        p.setBackground(Color.CYAN);
        p.setForeground(Color.blue);



        p.setBounds(20,200,350,30);
        f.add(p);

        try {
            fill();
        } catch (SlickException slickException) {
            slickException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }




    }

    public static void fill() throws SlickException, InterruptedException {
        int i =0;
        while (i <= 100) {
            if (i > 30 && i < 70) {
                p.setString("Configuring Loading");
                l.setText("Loading....");
            }
            if (i > 70) {
                l.setText("Almost Loaded");
                p.setString("Configure Successfully");
            } if(i>80){
                l.setText("Loading Successful");
                p.setString("Loading...");
            }
            p.setValue(i + 10);
            Thread.sleep(3000);
            i += 20;
        }

    }

    public static void main(String[] args) {
        new ProgressBar();
    }




}
