package kiloboltgame;

import java.awt.Graphics;

public class Robot
{
    private int centerX = 100;
    private int center = 382;
    private boolean jumped = false;

    private int speedX = 0;
    private int speedY = 1;

    public void update()
    {
        if (speedX < 0)
        {
            centerX += speedX;
        }
        else if (speed == 0)
        {
            System.out.println("do not scroll background");
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