package com.codewithkapil.Play;

import java.io.IOException;
import java.io.InputStream;

public class SoundFinder {
    public InputStream findSound(String path){
        InputStream in = getClass().getResourceAsStream(path);

        return in;




    }
}
