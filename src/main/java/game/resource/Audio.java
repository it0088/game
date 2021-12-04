package game.resource;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Audio  {
    AudioInputStream ais;
    Clip clip;
    private InputStream in;

    public Audio(InputStream in) {

        this.in = in;
        try {
            ais = AudioSystem.getAudioInputStream(in);
            clip = AudioSystem.getClip();
             clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playSound(int time){

        clip.setFramePosition(time);
        clip.start();
    }
     public void close(){
         try {
             this.ais.close();
             this.clip.close();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
     public void stop(){
        this.clip.stop();
     }

     public void start(){
        this.clip.start();
     }

    public boolean isActive(){
        return this.clip.isActive();
         }


}
