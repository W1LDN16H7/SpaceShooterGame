package com.codewithkapil.Display;
/*@author codewithkapil
* https://github.com/codewithkapil*/


import com.codewithkapil.Play.PlayGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Player extends PlayGame {
    private List<Bullet> shotList = new ArrayList<Bullet>();

    public boolean got_hit;

    protected Player() throws SlickException {
        super(null, (SpaceGame.bg_image.getWidth()/2), 400, null);

        got_hit = false;	//flat wich indicates, that the player got hit by an enemy

        /* Image and Hitbox will be created after calling super-constructor,
         * because creating the hitbox, needs further computing
         */
        this.img = new Image("src/com/codewithkapil/resource/fighter.png");


        this.hitbox = new Rectangle(this.pos_x - this.img.getWidth() / 2,
                this.pos_y - this.img.getHeight() / 2,
                this.img.getWidth(),
                this.img.getHeight());
    }


    /**
     * Update-Routine. This has to be called once per frame.
     * @throws SlickException
     */
    public void update() throws SlickException{
        move(7);
        shot_out_of_view_check();
    }

    /**
     * Handle all Player actions - move and shoot.
     *
     * @throws SlickException
     */
    private void move(int speed) throws SlickException{

        if(SpaceGame.game_container.getInput().isKeyDown(Input.KEY_UP)){
            this.pos_y-=speed;
            this.hitbox.setY(this.hitbox.getY()-speed);
        }
        if(SpaceGame.game_container.getInput().isKeyDown(Input.KEY_DOWN)){
            this.pos_y+=speed;
            this.hitbox.setY(this.hitbox.getY()+speed);
        }
        if(SpaceGame.game_container.getInput().isKeyDown(Input.KEY_LEFT)){
            this.pos_x-=speed;
            this.hitbox.setX(this.hitbox.getX()-speed);
        }
        if(SpaceGame.game_container.getInput().isKeyDown(Input.KEY_RIGHT)){
            this.pos_x+=speed;
            this.hitbox.setX(this.hitbox.getX()+speed);
        }

        if(SpaceGame.game_container.getInput().isKeyDown(Input.KEY_SPACE)){
            this.shotList.add(new Bullet());
        }
    }

    /**
     * This method deletes shots from the shot-list {@link #shotList}, if they are out of view, which means,
     * the reached the top of the window.
     * The garbage collector will notice, that the element is not referenced anymore and will delete it.
     */
    private void shot_out_of_view_check(){

        for(int i=0; i < shotList.size(); i++){
            if(shotList.get(i).getHitbox().getCenterY() < 0){
                shotList.remove(i);
                if(i > 0) i -= 1;		/* i has to be decreased to avoid an IndexOutOfBounds Exception */

                /* return, if the shot-list has no more entry, to avoid an IndexOutOfBounds exception */
                if(shotList.size() == 0){
                    return;
                }
            }
        }
    }

    public List<Bullet> getShotList(){
        return shotList;
    }

    public Image getImage(){
        return this.img;
    }
}
