package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Candy extends SuperObj
{
    public Candy(int a)
    {
        if(a == 1)
        {
            name = "Candy1";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/1p1.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        } else if (a == 2)
        {
            name = "Candy2";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/1p2.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        } else if (a == 3)
        {
            name = "Candy3";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/1p3.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
