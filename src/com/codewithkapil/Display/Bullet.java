package com.codewithkapil.Display;

import com.codewithkapil.Play.PlayGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Bullet extends PlayGame {
    protected Bullet() throws SlickException {
        super(null, SpaceGame.player.pos_x, SpaceGame.player.pos_y-(SpaceGame.player.getImage().getHeight()/2), null);

        try{
            this.img = new Image("src/com/codewithkapil/resource/bullet.png");
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Image bullet not found");
        }


        this.hitbox = new Rectangle(this.pos_x - this.img.getWidth() / 2,
                this.pos_y - this.img.getHeight() / 2,
                this.img.getWidth(),
                this.img.getHeight());
    }

    public void update(){

        move(40);
    }
    Sound s;


    private void move(int speed)  {
        this.pos_y-=speed;
        this.hitbox.setY(this.hitbox.getY()-speed);
        try{
            s = new Sound("com/codewithkapil/resource/bulletout.wav");
            s.play();


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Music File not Found");
        }

    }


}
