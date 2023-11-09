package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CandyCane extends SuperObj
{
    public CandyCane(int a)
    {
        if(a == 1)
        {
            name = "Cane1";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/3p1.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        } else if (a == 2)
        {
            name = "Cane2";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/3p2.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        } else if (a == 3)
        {
            name = "Cane3";
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream("/res/candy/3p3.png"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
