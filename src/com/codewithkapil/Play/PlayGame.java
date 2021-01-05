package com.codewithkapil.Play;

import com.codewithkapil.Display.SpaceGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class PlayGame {
    protected Image img;
    public int pos_x;
    public int pos_y;
    protected int speed_x;
    protected int speed_y;
    protected Shape hitbox;

    /*@param Constructor for playing game*/

    public PlayGame(Image img, int pos_x, int pos_y, Shape hitbox) {
        this.img = img;
        this.pos_x = pos_x;
        this.pos_y = pos_y;

        this.hitbox = hitbox;
    }
    public void render(boolean draw_hitbox){
        if (this.img != null)
        {
            this.img.drawCentered(this.pos_x, this.pos_y);
        }
        if(draw_hitbox == true && this.hitbox != null){
            SpaceGame.game_container.getGraphics().setColor(Color.pink);
            SpaceGame.game_container.getGraphics().draw(this.hitbox);
        }
    }


    public Shape getHitbox(){
        return this.hitbox;
    }


}
