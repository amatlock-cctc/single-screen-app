package com.cctc.amatlock.singleScreenApp;

import java.awt.*;

public class Player extends CoreObject
{
    public boolean falling;
    public Player(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void setVelX(double velX)
    {
        this.velX = velX;
    }

    public void setVelY(double velY)
    {
        this.velY = velY;
    }

    public double getVelX()
    {
        return velX;
    }
    public double getVelY()
    {
        return velY;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;
        if(falling)
        {
//            velY += Screen.GRAVITY;
        }

    }
}
