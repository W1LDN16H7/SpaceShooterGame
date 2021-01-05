package com.codewithkapil.Display;



/*@Author : KAPIL KUMAR
 Date : 6/09/2020

 copyright  © CoAI All Right Reserved

 Insta -> @codewithkapil

 twitter -> https://twitter.com/codewithkapil
 GitHub - > https://github.com/codewithkapil

 Email - > kapilkumargautam3652@gmail.com

 for doing any change or any suggestions contact us at upar given details
*/


import com.codewithkapil.Play.SoundFinder;
import org.newdawn.slick.*;

import javax.swing.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

public class SpaceGame extends BasicGame{
    public static Image bg_image;
    public static Player player;
    public static GameContainer game_container;
    public static int score;
    private static EnemyContainer enemy_container;
    public static TrueTypeFont big_message_font,info_text_font,owner_name;
    public static  Music sound;
    public static URL url;
    


//    private EnemyContainer


    public SpaceGame() throws SlickException{
        super("Space Invader");

    }



    @Override
    public void init(GameContainer gameContainer) throws SlickException{
        bg_image = new Image("src/com/codewithkapil/resource/img2.png");
//        game.setDisplayMode(bg_image.getWidth(), bg_image.getHeight(), false);



        game_container = gameContainer;
        player = new Player();
        score = 0;
        enemy_container = new EnemyContainer();

        /*
         * Font for messages*/


//        Font font = new Font("Chalkduster", java.awt.Font.BOLD, 50);
//
        java.awt.Font font = new java.awt.Font("times",java.awt.Font.BOLD,50);
        big_message_font = new TrueTypeFont(font, true);
        font = new java.awt.Font("Chalkduster",java.awt.Font.BOLD, 20);
        info_text_font = new TrueTypeFont(font, true);

        font = new java.awt.Font("Chalkduster",java.awt.Font.BOLD, 15);
        owner_name = new TrueTypeFont(font, true);

        // music
        boolean isPlaying =false;

//        sound = new Sound("src/com/codewithkapil/resource/audio.ogg");

//

        try{
            sound = new Music("com/codewithkapil/resource/audio.ogg");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Music File Missing");
        }

        sound.play(1f,1f);
//        sound.play();
        sound.loop();

//        while (isPlaying){
//            try {
//
//                sound.loop();
//                sound.play();
//                Thread.sleep(240000);
//                sound.stop();
//                isPlaying = true;
//            }
//            catch (Exception e){
//
//            }
//
//
//        }


        System.out.println("works");





    }




    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if(!player.got_hit){						/* As long as the player doesn´t get hit, the normal
													   update-routine will run */
            player.update();
            enemy_container.update();

            for(Bullet i : player.getShotList()){
                i.update();
            }
        }



    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        bg_image.draw(0,0);

        /* Normal Game-flow */
        if(!player.got_hit){
            info_text_font.drawString(10, 10,"Score: "+score, Color.orange);
            player.render(false);
            enemy_container.render(false);

            for(Bullet i : player.getShotList()){
                i.render(false);
            }
        }
        /* Game Over Screen */
        else {
            big_message_font.drawString(bg_image.getWidth()/4, bg_image.getHeight()/3, "GAME OVER!", Color.red );
            info_text_font.drawString(bg_image.getWidth()/4, bg_image.getHeight()/2,"Press ENTER to Continue", Color.red);
            owner_name.drawString(300,580,"Owner CodeWithKapil",Color.magenta);


            if(game_container.getInput().isKeyPressed(Input.KEY_ENTER)){
                init(game_container);
            }
        }


    }




}