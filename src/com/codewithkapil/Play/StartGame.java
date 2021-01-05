package com.codewithkapil.Play;

import com.codewithkapil.Display.SpaceGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartGame  {


    public JFrame f;
    public JPanel p1,p2;
    Font font;
    Border border;


    public StartGame() throws SlickException {
    }


    private  void paly() throws SlickException {

        f = new JFrame("Space Invader");

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(600,600));
        p1.setBounds(0,0,600,600);
        p1.setLocation(0,0);

        p1.setAlignmentY(Component.CENTER_ALIGNMENT);
        p1.setMaximumSize(new Dimension(600,600));

        font = new Font("times",Font.BOLD,20);
        border =BorderFactory.createLineBorder(Color.black,6,true);

        p1.setBorder(BorderFactory.createTitledBorder(border,"CWK GAME INDUSTRY", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,Color.red));



        p1.setBackground(Color.darkGray);
//        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.setLayout(null);
        f.add(p1);

        JLabel l = new JLabel("Copyright (c) CodeWithKapil");
        l.setForeground(Color.green);
        l.setFont(new Font("times",Font.BOLD,15));
        l.setBounds(200,560,300,30);
        p1.add(l);



        // 2st panel


        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(400,400));
        p2.setBounds(100,100,400,400);
        p2.setLocation(100,100);

        p2.setAlignmentY(Component.CENTER_ALIGNMENT);
        p2.setMaximumSize(new Dimension(400,400));

        font = new Font("times",Font.BOLD,20);
        border =BorderFactory.createLineBorder(Color.blue,6,true);

        p2.setBorder(BorderFactory.createTitledBorder(border,"Main Menu", TitledBorder.RIGHT,TitledBorder.DEFAULT_POSITION,font,Color.magenta));



        p2.setBackground(Color.black);
//        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.setLayout(null);
        p1.add(p2);

        JButton b1 = new JButton("PLAY");
        b1.setFocusPainted(false);
        border =BorderFactory.createLineBorder(Color.blue,2,true);
        b1.setBorder(border);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(p2.getWidth()/4,120,200,30);
        p2.add(b1);
        p2.setLayout(null);
        b1.setFont(new Font("times",Font.BOLD,20));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();








                try{



//                    f.dispose();
                    AppGameContainer app = new AppGameContainer(new SpaceGame());
                    app.setDisplayMode(800,600,false);
                    app.setTargetFrameRate(60);
                    app.setVSync(true);
                    app.setAlwaysRender(true);
                    app.setShowFPS(false);
                    app.start();
                    new SpaceGame();




                }
                catch (Exception ex){

                }








            }
        });
        b1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b1.setBackground(Color.RED);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setBackground(Color.BLUE);


            }
        });


        JButton b2 = new JButton("QUIT");
        b2.setFocusPainted(false);
        border =BorderFactory.createLineBorder(Color.blue,2,true);
        b2.setBorder(border);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(p2.getWidth()/4,180,200,30);
        p2.add(b2);
        p2.setLayout(null);
        b2.setFont(new Font("times",Font.BOLD,20));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b2.setBackground(Color.RED);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b2.setBackground(Color.BLUE);


            }
        });

        JButton b4 = new JButton("SETTINGS");
        b4.setFocusPainted(false);
        border =BorderFactory.createLineBorder(Color.blue,2,true);
        b4.setBorder(border);
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);
        b4.setBounds(p2.getWidth()/4,240,200,30);
        p2.add(b4);
        p2.setLayout(null);
        b4.setFont(new Font("times",Font.BOLD,20));
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Currently not available ");
            }
        });
        b4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b4.setBackground(Color.RED);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b4.setBackground(Color.BLUE);


            }
        });

        JButton b5 = new JButton("Developer");
        b5.setFocusPainted(false);
        border =BorderFactory.createLineBorder(Color.blue,2,true);
        b5.setBorder(border);
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.WHITE);
        b5.setBounds(p2.getWidth()/4,300,200,30);
        p2.add(b5);
        p2.setLayout(null);
        b5.setFont(new Font("times",Font.BOLD,20));
        b5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b5.setBackground(Color.RED);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b5.setBackground(Color.BLUE);


            }
        });



        JButton b3 = new JButton("SPACE FIGHTER");
        b3.setFocusPainted(false);
        border =BorderFactory.createLineBorder(Color.blue,2,true);
        b3.setBorder(border);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.setBounds(p2.getWidth()/7,60,300,30);
        p2.add(b3);
        p2.setLayout(null);
        b3.setFont(new Font("times",Font.BOLD,20));
        b3.setAlignmentY(Component.TOP_ALIGNMENT);
        b3.setEnabled(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"hello");
            }
        });










        f.setLayout(null);
        f.setVisible(true);
        f.setSize(615,640);
        f.setResizable(false);


    }





    public static void main(String[] args) throws SlickException {
        StartGame s = new StartGame();
        s.paly();



    }


}
