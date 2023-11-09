package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ghost extends SuperObj {
    public Ghost(int a) {
        setEntityType("Ghost");

        if (a == 1) {
            name = "GhostL";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/ghost/GhostL.PNG"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            collision = true;
        } else if (a == 2) {
            name = "GhostR";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/ghost/GhostR.PNG"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            collision = true;
            solidArea.width = 50;
            solidArea.height = 50;
        }
    }
}
