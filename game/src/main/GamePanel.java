package main;

import Tile.Tile;
import entity.Entity;
import entity.Player;
import Object.SuperObj;
import java.util.Random;

import javax.imageio.ImageIO;

import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {
    //Screen Setting
    final int originalTitleSize = 20;
    final int scale = 3;

    public final int tileSize = originalTitleSize * scale;
    public final int maxScreeCol = 20; //16
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreeCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    //system
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    public UI ui =  new UI(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);

    //obj
    public Player player = new Player(this,keyH);
    public SuperObj obj[] = new SuperObj[10];
    public SuperObj ghost[] = new SuperObj[10];
    Random random = new Random();

    public Image backgroundImage;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        //background
        try
        {
            backgroundImage = ImageIO.read(getClass().getResource("/res/background/bgGame.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setupGame()
    {
        aSetter.setObject();
        aSetter.setGhost();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run ()
    {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while (gameThread != null)
        {
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer>=1000000000)
            {
//                System.out.println("FPS : "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        player.update();
        aSetter.updateGhost(); // Update the ghost's position
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (backgroundImage != null)
        {
            g2.drawImage(backgroundImage, 0, 0, screenWidth, screenHeight, this);
        }
        //tile
        tileM.draw(g2);

        //object
        for(int i=0; i<obj.length;i++)
        {
            if(obj[i] != null && obj[i].getEntityType().equals("Gift"))
            {
                obj[i].draw(g2,this);
            }
        }
        //ghost
        for(int i=0; i<obj.length;i++)
        {
            if(obj[i] != null && obj[i].getEntityType().equals("Ghost"))
            {
                obj[i].draw(g2,this);
            }
        }
        if(aSetter.xGhost < 1300)
        {
            aSetter.xGhost = aSetter.xGhost + random.nextInt(10 - 1) + 1;
            aSetter.xGhost1 = aSetter.xGhost1 + random.nextInt(10 - 1) + 1;
        }
        else{
            aSetter.xGhost = 0;
            aSetter.xGhost1 = 0;
        }
        if(aSetter.xGhostReverse > 0){
            aSetter.xGhostReverse = aSetter.xGhostReverse - random.nextInt(10 - 1)+1;
        }
        else {
            aSetter.xGhostReverse = 1300;
        }

        //player
        player.draw(g2);

        ui.paintComponent(g);
        ui.draw(g2);

        g2.dispose();
    }
}

