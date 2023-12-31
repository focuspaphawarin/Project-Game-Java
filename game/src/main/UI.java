package main;

import java.awt.*;

public class UI {
    GamePanel gp;
    Font arial_40, arial_80B ,arial_60;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 35);
        arial_60 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 100);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        g2.setFont(arial_40);
        g2.setColor(Color.BLACK);
        g2.drawString("Score : " + gp.player.sumPoint, 50, 50);

        if (gameFinished == true) {
            g2.setFont(arial_80B);
            g2.setColor(Color.BLACK);
            String text;
            int textLength;
            int x;
            int y;

            text = "GAME OVER";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize);
            g2.drawString(text, x, y);

            g2.setFont(arial_60);
            g2.setColor(Color.BLACK);
            text = "TOTAL SCORES : "+ gp.player.sumPoint;
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight /2 - (gp.tileSize)/3;
            g2.drawString(text, x, y);

            gp.gameThread = null;

        } else {

            if (messageOn == true) {
                g2.setColor(Color.white);
                g2.setFont(g2.getFont().deriveFont(20));
                g2.drawString(message, gp.tileSize * 9, gp.tileSize * 11 + 50);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(33, 10, 200, 60);
        g.setColor(Color.BLACK);
        g.drawRect(33, 10, 200, 60);

    }
}
