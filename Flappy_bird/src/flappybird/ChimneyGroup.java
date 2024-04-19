package flappybird;

import game_controller.QueueList;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ChimneyGroup {
    private QueueList<Chimney> chimneyGroup;

    private BufferedImage chimeyImage;
    private BufferedImage chimeyImage2;

    public static int SIZE = 6;

    private int topChimneyY = -350;
    private int botomChimneyY = 190;

    public Chimney getChimney(int i){
        return chimneyGroup.get(i);
    }

    public int getRandomY(){
        Random random = new Random();
        int a;
        a = random.nextInt(10);
        return a*30;
    }

    public ChimneyGroup(){

        try{
            chimeyImage = ImageIO.read(getClass().getResourceAsStream("/Assets/chimney.png"));
            chimeyImage2 = ImageIO.read(getClass().getResourceAsStream("/Assets/chimney_.png"));

        }catch(IOException e){
        }
        chimneyGroup = new QueueList<>();

        Chimney chimney;

        for(int i = 0; i<SIZE/2; i++){
            int deltaY = getRandomY();
            chimney = new Chimney(830+ i * 300, botomChimneyY + deltaY, 74, 400 );
            chimneyGroup.push(chimney);
            chimney = new Chimney(830 + i * 300, topChimneyY  + deltaY, 74, 400);
            chimneyGroup.push(chimney);
        }
    }

    public void resetChimney(){
        chimneyGroup = new QueueList<>();

        Chimney chimney;

        for(int i = 0; i<SIZE/2; i++){
            int deltaY = getRandomY();
            chimney = new Chimney(830+ i * 300, botomChimneyY + deltaY, 74, 400 );
            chimneyGroup.push(chimney);
            chimney = new Chimney(830 + i * 300, topChimneyY  + deltaY, 74, 400);
            chimneyGroup.push(chimney);
        }
    }

    public void update(){
        for(int i = 0; i< SIZE; i++){
            chimneyGroup.get(i).update();
        }

            if(chimneyGroup.get(0).getPosX()< -74){

                int deltaY = getRandomY();

                Chimney cn;
                cn = chimneyGroup.pop();
                cn.setPosX(chimneyGroup.get(4).getPosX() +300);
                cn.setPosY(botomChimneyY + deltaY);
                cn.setIsBehindBird(false);
                chimneyGroup.push(cn);

                cn =chimneyGroup.pop();
                cn.setPosX(chimneyGroup.get(4).getPosX());
                cn.setPosY(topChimneyY + deltaY);
                chimneyGroup.push(cn);
            }
    }

    public void paint(Graphics2D g2){
        for(int i = 0; i< 6; i++){
            if(i % 2 == 0)
            g2.drawImage(chimeyImage, (int)chimneyGroup.get(i).getPosX(),(int) chimneyGroup.get(i).getPosY(), null );
            else g2.drawImage(chimeyImage2, (int)chimneyGroup.get(i).getPosX(),(int) chimneyGroup.get(i).getPosY(), null );

        }
    }
}
