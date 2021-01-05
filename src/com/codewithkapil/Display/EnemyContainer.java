package com.codewithkapil.Display;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyContainer {
    private static List<int[]> spawnpoints;

    private static Random randomizer;
    private static List<Enemy> enemies;

    private static long timestamp;


    public EnemyContainer(){
        enemies = new ArrayList<Enemy>();
        randomizer = new Random();
        timestamp = SpaceGame.game_container.getTime();
        compute_spawnpoints();
    }

    /**
     * Compute spawnpoints regarding the width of the background.
     */
    private static void compute_spawnpoints(){
        spawnpoints = new ArrayList<int[]>();
        int[] spawnpoint;

        for(int i = 60; i <= SpaceGame.bg_image.getWidth()-60; i+= 60){
            spawnpoint = new int[2];
            spawnpoint[0] = i;
            spawnpoint[1] = 0;
            spawnpoints.add(spawnpoint);
        }
    }

    /**
     * Adds enemy to the list of enemies.
     * The spawnpoint will be selected randomly from the array of spawnpoints {@link #spawnpoints}.
     */
    public static void addEnemy(){
        int[] spawnpoint = spawnpoints.get(randomizer.nextInt(spawnpoints.size()-1));
        try {
            enemies.add(new Enemy(spawnpoint[0], spawnpoint[1]));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Render-routine. This has to be called once per frame.
     */
    public void render(boolean draw_hitbox){
        for(Enemy i : enemies){
            i.render(draw_hitbox);
        }
    }

    /**
     * Update-routine. This has to be called once per frame.
     * @throws SlickException
     */
    public void update() throws SlickException {
        long new_timestamp = SpaceGame.game_container.getTime();

        if(new_timestamp - timestamp >= 1000){
            addEnemy();
            timestamp = new_timestamp;
        }

        collision_check();
        enemy_out_of_view_check();
    }

    /**
     * Collision check for enemy-objects with shots.
     * If an {@link Enemy}-object collides with a {@link Bullet}-object, the enemy gets destroyed.
     *
     * @throws SlickException
     */

    Sound s;
    private void collision_check() throws SlickException{

        for(int i=0; i < enemies.size(); i++){
            enemies.get(i).update();

            for(int j=0; j < SpaceGame.player.getShotList().size(); j++){

                /* Check Collision, Delete corresponding enemy and shot and increase the score */
                if (enemies.get(i).getHitbox().intersects(


                        SpaceGame.player.getShotList().get(j).getHitbox())){

                    enemies.remove(i);
                    SpaceGame.player.getShotList().remove(j);
                    SpaceGame.score++;
                    // sound for shooting bullet








                    if(i>0) i -= 1;			/* In case of collision, i and j have to be decreased 	*/
                    if(j>0) j -= 1;			/* to avoid IndexOutOfBounds exceptions, since the 		*/
                    /* size of the corresponding lists decreases as well 	*/
                    /* when elements are deleted
                    *
                    * 							*/
                    try{
                        s = new Sound("com/codewithkapil/resource/bulletshoot.wav");
                        s.playAt(100.0f,100.0f,40.0f);


                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Music File not Found");
                    }
                    /* return, if the enemies-list has no more entry, to avoid an IndexOutOfBounds exception */
                    if(enemies.size() == 0 || SpaceGame.player.getShotList().size() == 0){
                        return;
                    }
                }
            }
        }
    }

    /**
     * This method deletes enemies from the enemy-list {@link #enemies}, if they are out of view, which means,
     * the reached the end of the window.
     * The garbage collector will notice, that the element is not referenced anymore and will delete it.
     */
    private void enemy_out_of_view_check(){

        for(int i=0; i < enemies.size(); i++){
            if(enemies.get(i).getHitbox().getCenterY() > SpaceGame.bg_image.getHeight()){
                enemies.remove(i);
                if(i > 0) i -= 1;		/* i has to be decreased to avoid an IndexOutOfBounds Exception */

                /* return, if the enemies-list has no more entry, to avoid an IndexOutOfBounds exception */
                if(enemies.size() == 0){
                    return;
                }
            }
        }
    }

}
