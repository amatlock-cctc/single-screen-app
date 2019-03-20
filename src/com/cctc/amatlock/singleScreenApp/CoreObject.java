package com.cctc.amatlock.singleScreenApp;

import java.awt.*;

public abstract class CoreObject extends Rectangle
{
    public double velX;
    public double velY;
    public Color color;

    public CoreObject(int x, int y, int width, int height, Color color)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract void render(Graphics g);
    public abstract void tick();
    public Point getPoint()
    {
        return new Point(this.x, (int) (this.y + velY));
    }
}
