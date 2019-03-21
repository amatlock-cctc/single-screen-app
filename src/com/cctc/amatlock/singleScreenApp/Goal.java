package com.cctc.amatlock.singleScreenApp;

import java.awt.*;

public class Goal extends CoreObject
{
    private boolean scored = false;

    public Goal(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Screen.GOLD);
        g.drawRect(x, y, width, height);

        if(scored)
        {
            Screen.getInstance().drawAnnouncement(g, "You Scored!!!");
        }
    }

    @Override
    public void tick()
    {
        if(this.intersects(Screen.getInstance().getPlayer()))
        {
            this.color = Screen.GOLD;
            scored = true;
        }
        else
        {
            this.color = Color.WHITE;
            scored = false;
        }
    }
}
