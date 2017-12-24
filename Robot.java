//package kiloboltgame;

import java.awt.Graphics;

public class Robot
{
    // Constants
    final int JUMPSPEED = -15;
    final int MOVESPEED = 5;
    final int GROUND = 382;

    private int centerX = 100;
    private int centerY = GROUND;
    private boolean jumped = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean ducked = false;

    private static Background bg1 = StartingClass.getBg1();
    private static Background bg2 = StartingClass.getBg2();

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

    public void setCenterx(int centerX)
    {
        this.centerX = centerX;
    }

    public void setCentery(int centerY)
    {
        this.centerY = centerY;
    }

    public void setSpeedx(int speedX)
    {
        this.speedX = speedX;
    }

    public void setSpeedy(int speedY)
    {
        this.speedY = speedY;
    }

    public void setJumped(boolean jumped)
    {
        this.jumped = jumped;
    }


    public void update()
    {
        if (speedX < 0)
        {
            centerX += speedX;
        }
        if (speedX == 0 || speedX < 0)
        {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);
        }
        if (centerX <= 200 && speedX > 0)
        {
            centerX += speedX;
        }
        if (speedX > 0 && centerX > 200)
        {
            bg1.setSpeedX(-MOVESPEED);
            bg2.setSpeedX(-MOVESPEED);
        }

        centerY += speedY;
        if (centerY + speedY >= GROUND)
        {
            centerY = GROUND;
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

            if (centerY + speedY >= GROUND)
            {
                centerY = GROUND;
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
        if (!ducked)
        {
            speedX = MOVESPEED;
        }
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
        //if (!jumped)
        {
            speedY -= 15;
            jumped = true;
        }
    }
}