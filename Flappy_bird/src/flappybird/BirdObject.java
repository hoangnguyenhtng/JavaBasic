package flappybird;

import game_controller.Objects;
import media_manager.SoundPlayer;

import java.awt.*;

public class BirdObject extends Objects {
    private float fallSpeed = 0;

    private boolean isFlying = false;

    private Rectangle rect;

    private boolean isLive = true;

    public static float gravity = 0.18f;

    public SoundPlayer flapSound, fallSound, getPointSound;

    public void setLive(boolean b ){
        isLive = b;

    }

    public boolean getLive(){
        return isLive;
    }
    public Rectangle getRect(){
        return  rect;
    }
    public BirdObject(int x, int y, int w, int h){
        super(x, y, w, h);
        rect = new Rectangle(x, y, w, h);
        flapSound = new SoundPlayer("/Assets/fap.wav");
        fallSound = new SoundPlayer("/Assets/fall.wav");
        getPointSound = new SoundPlayer("/Assets/getpoint.wav");

    }

    public void setFallSpeed(float fallSpeed){
        this.fallSpeed = fallSpeed;
    }
    public void updateState(long deltaTime){
        fallSpeed += gravity;
        this.setPosY(this.getPosY() + fallSpeed);
        this.rect.setLocation((int)this.getPosX(), (int)this.getPosY());
        if (fallSpeed<0) isFlying = true;
        else isFlying = false;
    }

    public void birdFly(){
        fallSpeed = - 5;
        flapSound.play();
    }

    public boolean getIsFlying(){
        return isFlying;
    }
}