package flappybird;

import graphics_manager.AFrameOnImage;
import graphics_manager.GameScreen;
import graphics_manager.Menu;
import media_manager.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.awt.event.MouseEvent.MOUSE_CLICKED;

public class FlappyBird extends GameScreen {
    private boolean isPaused = false;
    private BufferedImage birdSprite;
    private Animation birdAnimation;
    AFrameOnImage f;
    private BirdObject playerBird;
    // public static float gravity = 0.18f;
    private Ground ground;
    private ChimneyGroup chimneyGroup;

    private int point = 0;

    private int BEGIN_SCREEN = 0;
    private int GAMEPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    private Menu menu;

    private int CurrentScreen = BEGIN_SCREEN;

    public FlappyBird() {
        super(800, 600);
        enableMouseListener();
        menu = new Menu();
        menu.setVisible(false);
        try {
            birdSprite = ImageIO.read(getClass().getResourceAsStream("/Assets/bird_sprite.png"));

        } catch (IOException e) {
        }
        birdAnimation = new Animation(70);
        AFrameOnImage f;
        f = new AFrameOnImage(0, 0, 60, 60);
        birdAnimation.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        birdAnimation.AddFrame(f);
        f = new AFrameOnImage(120, 0, 60, 60);
        birdAnimation.AddFrame(f);
        f = new AFrameOnImage(0, 0, 60, 60);
        birdAnimation.AddFrame(f);

        playerBird = new BirdObject(350, 250, 50, 50);
        ground = new Ground();
        chimneyGroup = new ChimneyGroup();
        BeginGame();
    }

    private void enableMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MOUSE_ACTION(e, MOUSE_CLICKED);
            }
        });
    }

    public static void main(String[] args) {
        new FlappyBird();
    }

    private void resetGame() {
        playerBird.setPos(350, 250);
        playerBird.setFallSpeed(0);
        playerBird.setLive(true);
        point = 0;
        chimneyGroup.resetChimney();

    }

    @Override
    public void GAME_UPDATE(long deltaTime) {
        if (!isPaused) {
            if (CurrentScreen == BEGIN_SCREEN) {
                resetGame();
            } else if (CurrentScreen == GAMEPLAY_SCREEN) {
                if (playerBird.getLive())
                    birdAnimation.Update_Me(deltaTime);
                playerBird.updateState(deltaTime);
                ground.update();
                chimneyGroup.update();

                for (int i = 0; i < chimneyGroup.SIZE; i++) {
                    if (playerBird.getRect().intersects(chimneyGroup.getChimney(i).getRect())) {
                        if (playerBird.getLive())
                            playerBird.fallSound.play();
                        playerBird.setLive(false);

                    }
                    // Phát âm thanh khi chim va chạm vào mặt đất
                    if ((playerBird.getPosY() + playerBird.getH()) > ground.getYGround()) {
                        if (playerBird.getLive()) {
                            playerBird.fallSound.play();
                        }
                        CurrentScreen = GAMEOVER_SCREEN;
                    }
                }

                for (int i = 0; i < chimneyGroup.SIZE; i++) {
                    if (playerBird.getPosX() > chimneyGroup.getChimney(i).getPosX()
                            && !chimneyGroup.getChimney(i).getBehindBird()
                            && i % 2 == 0) {
                        point++;
                        playerBird.getPointSound.play();
                        chimneyGroup.getChimney(i).setIsBehindBird(true);
                    }
                }
                if (!playerBird.getLive()) {
                    playerBird.setFallSpeed(10); // Đặt tốc độ rơi
                    playerBird.updateState(deltaTime); // Cập nhật vị trí rơi
                    if (playerBird.getPosY() > ground.getYGround()) {
                        CurrentScreen = GAMEOVER_SCREEN;
                    }
                }
                // if((playerBird.getPosY() + playerBird.getH()) > ground.getYGround()){
                // CurrentScreen = GAMEOVER_SCREEN;
                // }
            } else {

            }

        }
    }

    @Override
    public void GAME_PAINT(Graphics2D g2) {
        // g2.setColor(Color.decode("#b8daef"));
        // g2.fillRect(0, 0, MASTER_WIDTH, MASTER_HEIGHT);

        // Vẽ background mỗi khi phương thức được gọi
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/Assets/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2.drawImage(backgroundImage, 0, 0, null);

        chimneyGroup.paint(g2);
        ground.paint(g2);
        // Tạo một đối tượng Font mới với font chữ "Roboto" và kích thước
        Font robotoFont = new Font("Roboto", Font.PLAIN, 30);

        // Đặt font chữ cho đối tượng Graphics2D
        g2.setFont(robotoFont);
        if (playerBird.getIsFlying()) {
            birdAnimation.PaintAnims((int) playerBird.getPosX(), (int) playerBird.getPosY(), birdSprite, g2, 0, -1);
        } else {
            birdAnimation.PaintAnims((int) playerBird.getPosX(), (int) playerBird.getPosY(), birdSprite, g2, 0, 0);
        }

        if (CurrentScreen == BEGIN_SCREEN) {
            g2.setColor(Color.white);
            g2.drawString("Press space to play game", 200, 250);

        }
        if (CurrentScreen == GAMEOVER_SCREEN) {
            g2.setColor(Color.darkGray);
            g2.drawString("Game Over!", 350, 250);
            g2.drawString("Press space turn back begin screen", 200, 300);
        }
        g2.setColor(Color.YELLOW);
        g2.drawString("Point: " + point, 20, 50);
        // Khi tất cả mọi thứ đã được vẽ lên bộ nhớ đệm, vẽ bộ nhớ đệm lên cảnh

    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if (Event == KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                togglePause();
            } else {
                if (CurrentScreen == BEGIN_SCREEN) {
                    CurrentScreen = GAMEPLAY_SCREEN;
                } else if (CurrentScreen == GAMEPLAY_SCREEN) {
                    if (playerBird.getLive())
                        playerBird.birdFly();
                } else if (CurrentScreen == GAMEOVER_SCREEN) {
                    CurrentScreen = BEGIN_SCREEN;
                }
            }
        }
    }

    public void togglePause() {
        isPaused = !isPaused;
    }

    public void MOUSE_ACTION(MouseEvent e, int Event) {
        if (Event == MOUSE_CLICKED) {
            if (CurrentScreen == BEGIN_SCREEN) {
                CurrentScreen = GAMEPLAY_SCREEN;
            } else if (CurrentScreen == GAMEPLAY_SCREEN) {
                if (playerBird.getLive())
                    playerBird.birdFly();
            } else if (CurrentScreen == GAMEOVER_SCREEN) {
                CurrentScreen = BEGIN_SCREEN;
            }
        }
    }
}
