package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity
{
    GamePanel gp;
    public int x,y;
    public int speed;

    public BufferedImage wl1,wl2,wr1,wr2,wl,wr;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX , solidAreaDefaultY;
    public boolean collisionOn = false;

    public Entity(GamePanel gp)
    {
        this.gp = gp;
    }

}
