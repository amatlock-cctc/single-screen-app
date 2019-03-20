package com.cctc.amatlock.singleScreenApp;

import java.awt.*;

public class Brick extends Rectangle
{
    private Color color;        // Color of rectangle.
    private double velX = 0;    // We uses velocity so that we can accelerate and decelerate objects naturally.
    private double velY = 0;
    private boolean falling = true;

    /**
     * Brick extends Rectangle and adds a color, and the tick (used for movement)
     * and render (used for displaying).
     */
    public Brick(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    /**
     * Draws the brick on the screen at its location.
     * @param g library that draws to the screen.
     */
    public void render(Graphics g)
    {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    /**
     * Moves the rectangle based on its velX and velY.
     * This happens 60 times every second.
     */
    public void tick()
    {
        // Update falling
        isFalling();

        // Move along the x axis (horizontally)
        x += velX;

        // If falling accelerate by gravity.
        if(falling)
        {
            velY += FallingBrick.GRAVITY;
        }
        else
        {
            velY = 0;
        }

        // Move along the y axis (vertically)
        y += velY;
    }

    /**
     * Updates whether the brick is currently falling.
     * @return true if the brick is still falling.
     */
    public boolean isFalling()
    {
        // We create a point at the bottom left corner.
        // Technically we create the point where the point will be next render, hence adding velY.
        Point p = new Point(x, (int) (y + height + velY) );

        // If the brick is falling, check if our point is contained within the floor.
        if(falling && FallingBrick.getInstance().floor.contains(p) )
        {
            falling = false;
        }
        return falling;
    }
}
