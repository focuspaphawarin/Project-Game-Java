package main;

import Object.*;
import java.util.Random;
public class AssetSetter
{
    GamePanel gp;
    Random random = new Random();

    public int xGhost = 16;
    public int xGhost1 = 16;
    public int xGhostReverse = 1300;
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        //candy
        gp.obj[0] = new Candy(random.nextInt(3 - 1 + 1) + 1);
        gp.obj[0].x = random.nextInt(760 - 380) + 380;
        gp.obj[0].y = random.nextInt(650 - 450) + 450;

        gp.obj[1] = new Candy(random.nextInt(3 - 1 + 1) + 1);
        gp.obj[1].x = random.nextInt(760 - 380) + 380;
        gp.obj[1].y = random.nextInt(650 - 450) + 450;

        gp.obj[2] = new Candy(random.nextInt(3 - 1 + 1) + 1);
        gp.obj[2].x = random.nextInt(760 - 380) + 380;
        gp.obj[2].y = random.nextInt(650 - 450) + 450;

        //2
        gp.obj[3] = new CandyCane(random.nextInt(3 - 1 + 1) + 1);
        gp.obj[3].x = random.nextInt(820 - 300) + 300;
        gp.obj[3].y = random.nextInt(600 - 500) + 500;

        gp.obj[4] = new CandyCane(random.nextInt(3 - 1 + 1) + 1);
        gp.obj[4].x = random.nextInt(820 - 250) + 250;
        gp.obj[4].y = random.nextInt(600 - 500) + 500;

        //gift
        gp.obj[5] = new Gift(random.nextInt(3 - 1 + 1) + 1);
        gp.obj[5].x = random.nextInt(820 - 300) + 300;
        gp.obj[5].y = random.nextInt(650 - 550) + 550;

        //point
        gp.obj[6] = new CarPoint();
        gp.obj[6].x = 500;
        gp.obj[6].y = 10;
    }

    public void setGhost() {
        gp.obj[7] = new Ghost(2);
        gp.obj[7].name = "GhostL"; // Set the name for the first ghost
        gp.obj[7].x = random.nextInt(1000 - 300 ) + 300;
        gp.obj[7].y = gp.tileSize * 3;

        gp.obj[8] = new Ghost(1);
        gp.obj[8].name = "GhostR"; // Set the name for the second ghost
        gp.obj[8].x = random.nextInt(1300 - 20 ) + 20;
        gp.obj[8].y = gp.tileSize * 4;

        gp.obj[9] = new Ghost(2);
        gp.obj[9].name = "GhostL"; // Set the name for the third ghost
        gp.obj[9].x = random.nextInt(1300 - 100 ) + 100;
        gp.obj[9].y = gp.tileSize * 5;
    }

    public void updateGhost() {
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null && gp.obj[i].getEntityType().equals("Ghost")) {
                if (i == 7) {
                    gp.obj[i].x = xGhost;
                } else if (i == 8) {
                    gp.obj[i].x = xGhostReverse;
                } else if (i == 9) {
                    gp.obj[i].x = xGhost1;
                }
            }
        }
    }
}
