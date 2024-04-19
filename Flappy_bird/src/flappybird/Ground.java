package flappybird;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
    private BufferedImage groundImage;

    private int x1, y1, x2, y2;

    public Ground() {
        try {
            groundImage = ImageIO.read(getClass().getResourceAsStream("/Assets/ground.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }

        x1 = 0;
        x2 = x1 + groundImage.getWidth(); // Sử dụng chiều rộng của ảnh để tính toán x2
        y1 = y2 = 500; // Chỉ cần thiết lập một giá trị y cho cả hai đoạn đất
    }

    public void update() {
        x1 -= 2;
        x2 -= 2;

        // Kiểm tra nếu x1 hoặc x2 vượt ra ngoài khung hình, di chuyển chúng về phía bên phải của cửa sổ
        if (x1 + groundImage.getWidth() <= 0) {
            x1 = x2 + groundImage.getWidth(); // Di chuyển x1 đến phía sau x2
        }
        if (x2 + groundImage.getWidth() <= 0) {
            x2 = x1 + groundImage.getWidth(); // Di chuyển x2 đến phía sau x1
        }
    }


    public void paint(Graphics2D g2) {
        g2.drawImage(groundImage, x1, y1, null);
        g2.drawImage(groundImage, x2, y2, null);
    }

    public int getYGround(){
        return y1;
    }
}
