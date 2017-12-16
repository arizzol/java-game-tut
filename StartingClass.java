package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyListener;
import java.awt.Graphics;

import java.awt.event.KeyEvent;

public class StartingClass extends Applet implements Runnable, KeyListener
{
    private Robot robot;

    @Override
    public void init()
    {
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame)this.getParent().getParent();
        frame.setTitle("Q-bot Alpha");
    }

    @Override
    public void start()
    {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
        while (true)
        {
            repaint();
            try
            {
                Thread.sleep(17);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void stop()
    {
        super.stop();
    }

    @Override
    public void update(Graphics g)
    {
        if (image == null)
        {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            System.out.println("up");
            break;

            case KeyEvent.VK_DOWN:
            System.out.println("down");
            break;

            case KeyEvent.VK_LEFT:
            System.out.println("left");
            break;

            case KeyEvent.VK_RIGHT:
            System.out.println("right");
            break;

            case KeyEvent.VK_SPACE:
            System.out.println("jump");
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            break;

            case KeyEvent.VK_DOWN:
            break;

            case KeyEvent.VK_LEFT:
            break;

            case KeyEvent.VK_RIGHT:
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            System.out.println("clicked up");
            break;
        }
    }
}