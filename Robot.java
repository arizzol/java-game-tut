//package kiloboltgame;

import java.awt.Graphics;

public class Robot
{
    private int centerX = 100;
    private int centerY = 382;
    private boolean jumped = false;

    private int speedX = 0;
    private int speedY = 1;
    private int width = 20;
    private int height = 10;

    public int getCenterX()
    {
        return centerX;
    }

    public int getCenterY()
    {
        return centerY;
    }

    public int getSpeedX()
    {
        return speedX;
    }
    
    public int getSpeedY()
    {
        return speedY;
    }

    public boolean getJumped()
    {
        return jumped;
    }



    public void update()
    {
        if (speedX < 0)
        {
            centerX += speedX;
        }
        else if (speedX == 0)
        {
            //System.out.println("do not scroll background");
        }
        else
        {
            if (centerX <= 150)
            {
                centerX += speedX;
            }
            else
            {
                System.out.println("scroll background here");
            }
        }

        // Updates Y position
        if (centerY + speedY >= 382)
        {
            centerY = 382;
        }
        else
        {
            centerY += speedY;
        }

        if (jumped == true)
        {
            speedY += 1;

            if (centerY + speedY >= 382)
            {
                centerY = 382;
                speedY = 0;
                jumped = false;
            }
        }

        if (centerX + speedX <= 60)
        {
            centerX = 61;
        }
    }

    public void moveRight()
    {
        speedX = 6;
    }

    public void moveLeft()
    {
        speedX = -6;
    }

    public void stop()
    {
        speedX = 0;
    }

    public void jump()
    {
        if (jumped == false)
        {
            speedY -= 15;
            jumped = true;
        }
    }
}