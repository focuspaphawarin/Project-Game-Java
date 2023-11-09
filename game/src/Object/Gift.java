package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Gift extends SuperObj
{
    public Gift(int a)
    {
        if(a == 1)
        {
            name = "Gift1";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/5p1.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        } else if (a == 2) {
            name = "Gift2";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/5p2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
