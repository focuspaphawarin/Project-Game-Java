package Object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CarPoint extends SuperObj
{
    public CarPoint()
    {
        name = "Reindeer";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/point/reindeer.PNG"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
        solidArea.x = 500;
        solidArea.y = 10;
        solidArea.width = 290;
        solidArea.height = 180;
    }
    @Override
    public void draw(Graphics2D g2, GamePanel gp)
    {
        g2.drawImage(image,x,y,290,180,null);
    }
}
