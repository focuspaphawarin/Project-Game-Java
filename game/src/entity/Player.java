package entity;

import main.GamePanel;
import main.KeyHandler;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    KeyHandler keyH;
    public int hasPoint = 0;
    public int sumPoint = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 10 * 2;
        solidArea.y = 36 * 2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 10 * 2;
        solidArea.height = 10 * 2;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 550;
        y = 400;
        speed = 5;
        direction = "up";
    }

    public void getPlayerImage() {
        try {
            wl1 = ImageIO.read(getClass().getResourceAsStream("/res/player/SantaStopL.PNG"));
            wl2 = ImageIO.read(getClass().getResourceAsStream("/res/player/SantaWalkL.PNG"));
            wr1 = ImageIO.read(getClass().getResourceAsStream("/res/player/SantaStopR.PNG"));
            wr2 = ImageIO.read(getClass().getResourceAsStream("/res/player/SantaWalkR.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            //check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //check obj collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObj(objIndex);

            //if collision is false , player can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObj(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;
            System.out.println(gp.ghost[i]);

            if ((objectName.equals("Candy1") || objectName.equals("Candy2") || objectName.equals("Candy3"))) {
                hasPoint++;
                gp.obj[i] = null;
                gp.ui.showMessage("+ 1 Point !");
            } else if ((objectName.equals("Cane1") || objectName.equals("Cane2") || objectName.equals("Cane3"))) {
                hasPoint += 2;
                gp.obj[i] = null;
                gp.ui.showMessage("+ 2 Points !");
            } else if (objectName.equals("Gift1") || objectName.equals("Gift2")) {
                hasPoint += 5;
                gp.obj[i] = null;
                gp.ui.showMessage("+ 5 Points !");
            } else if (objectName.equals("Reindeer")) {
                sumPoint += hasPoint;
                hasPoint = 0;
                System.out.println("Score : " + sumPoint);
            } else if (gp.obj[i] != null && gp.obj[i].getEntityType().equals("Ghost")) {
                String ghostName = gp.obj[i].name;
                if (ghostName.equals("GhostL") || ghostName.equals("GhostR"))
                {
                    gp.ui.gameFinished = true; //game over
                }
            }
        }
    }


    public void draw(Graphics2D g2) {
//        g2.setColor(Color.magenta);
//        g2.fillRect(x,y,gp.titleSize,gp.titleSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = wl1;
                }
                if (spriteNum == 2) {
                    image = wl2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = wr1;
                }
                if (spriteNum == 2) {
                    image = wr2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = wl1;
                }
                if (spriteNum == 2) {
                    image = wl2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = wr1;
                }
                if (spriteNum == 2) {
                    image = wr2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
    }
}
