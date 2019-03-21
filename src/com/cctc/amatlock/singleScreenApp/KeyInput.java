package com.cctc.amatlock.singleScreenApp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{
    private boolean aPressed = false;
    private boolean dPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_A:
                Screen.getInstance().getPlayer().setVelX(-1.0);
                aPressed = true;
                break;
            case KeyEvent.VK_D:
                Screen.getInstance().getPlayer().setVelX(1.0);
                dPressed = true;
                break;
            case KeyEvent.VK_W:
                Screen.getInstance().getPlayer().setVelY(-1.0);
                wPressed = true;
                break;
            case KeyEvent.VK_S:
                Screen.getInstance().getPlayer().setVelY(1.0);
                sPressed = true;
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_A:
                aPressed = false;
                if(dPressed)
                {
                    Screen.getInstance().getPlayer().setVelX(1.0);
                }
                else
                {
                    Screen.getInstance().getPlayer().setVelX(0);
                }
                break;
            case KeyEvent.VK_D:
                dPressed = false;
                if(aPressed)
                {
                    Screen.getInstance().getPlayer().setVelX(-1.0);
                }
                else
                {
                    Screen.getInstance().getPlayer().setVelX(0);
                }
                break;
            case KeyEvent.VK_W:
                wPressed = false;
                if(wPressed)
                {
                    Screen.getInstance().getPlayer().setVelY(1.0);
                }
                else
                {
                    Screen.getInstance().getPlayer().setVelY(0);
                }
                break;
            case KeyEvent.VK_S:
                sPressed = false;
                if(wPressed)
                {
                    Screen.getInstance().getPlayer().setVelY(-1.0);
                }
                else
                {
                    Screen.getInstance().getPlayer().setVelY(0);
                }
                break;
        }

    }
}
