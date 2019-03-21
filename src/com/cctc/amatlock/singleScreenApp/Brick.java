package com.cctc.amatlock.singleScreenApp;

import java.awt.*;

public class Brick extends CoreObject
{

    public Brick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void tick()
    {
        Player player = Screen.getInstance().getPlayer();
        Point topLeft = new Point(player.x, player.y);
        Point topRight = new Point(player.x + player.width, player.y);
        Point bottomLeft = new Point(player.x, player.y + height);
        Point bottomRight = new Point(player.x + width, player.y + height);

        // Bottom collision detection
        if(this.contains(bottomLeft) || this.contains(bottomRight))
        {
            System.out.println("Collision: " + bottomLeft + " velY : " + player.velY);
            System.out.println(player.y);
            System.out.println(this.y);
            System.out.println(bottomLeft.y);

            if(player.getVelY() > 0)
            {
                player.y = player.y + (this.y - bottomLeft.y) - 1;
                player.setVelY( player.getVelY()/2 );
            }
        }

        // top collision detection
        if(this.contains(topLeft) || this.contains(topRight))
        {
            System.out.println("Collision: " + topLeft + " velY : " + player.velY);
            System.out.println(player.y);
            System.out.println(this.y);
            System.out.println(bottomLeft.y);

            if(player.getVelY() < 0)
            {
                player.y = player.y - (this.y - bottomLeft.y) + 1;
                player.setVelY( player.getVelY()/2 );
            }
        }
    }
}
