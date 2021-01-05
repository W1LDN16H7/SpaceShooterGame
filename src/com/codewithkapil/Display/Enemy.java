package com.codewithkapil.Display;

import com.codewithkapil.Play.PlayGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;

import javax.swing.*;

public class Enemy extends PlayGame {

    public Enemy(int pos_x, int pos_y) throws SlickException {
        super(null, pos_x, pos_y, null);

        /* Image and Hitbox will be created after calling super-constructor,
         * because creating the hitbox, needs further computing
         */
        try{
            this.img = new Image("src/com/codewithkapil/resource/enemys.png");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Enemy Image Not Found");
        }

        this.hitbox = new Rectangle(this.pos_x - this.img.getWidth() / 2,
                this.pos_y - this.img.getHeight() / 2,
                this.img.getWidth(),
                this.img.getHeight());
    }

    /**
     * Update-Routine. Has to be called once per frame.
     * @throws SlickException
     */
    public void update() throws SlickException{
        move(2);				//at the moment the speed is hard coded, but the game could be extended with
        //various speeds, or rising speed per time, to increase the difficulty.
        collision_check();


    }


    /**
     * Move of the enemy. All enemies will strictly move down, according to their specified speed.
     *
     * @param speed Speed of down-movement
     */
    private void move(int speed){
        this.pos_y+=speed;
        this.hitbox.setY(this.hitbox.getY()+speed);
    }

    /**
     * If an {link Enemy}-object collides with the {@link Player}-object, the game is over.
     */
    Sound s;
    private void collision_check(){

        if(this.hitbox.intersects(SpaceGame.player.getHitbox())){
            SpaceGame.player.got_hit = true;

        }
    }
}
