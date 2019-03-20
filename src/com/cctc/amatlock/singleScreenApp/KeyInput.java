package com.cctc.amatlock.singleScreenApp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{
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
                Screen.getInstance().getPlayer().setVelX(1.0);
                System.out.println("A");
                break;
            case KeyEvent.VK_D:
                Screen.getInstance().getPlayer().setVelX(-1.0);
                break;
            case KeyEvent.VK_W:
                Screen.getInstance().getPlayer().setVelY(1.0);
                break;
            case KeyEvent.VK_S:
                Screen.getInstance().getPlayer().setVelY(-1.0);
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
