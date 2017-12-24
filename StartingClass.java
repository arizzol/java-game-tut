//package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener
{
    private Robot robot;
    private Image image, currentSprite, character, background;
    private Graphics second;
    private URL base;
    private static Background bg1, bg2;

    @Override
    public void init()
    {
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame)this.getParent().getParent();
        frame.setTitle("Q-bot Alpha");
        try
        {
            base = StartingClass.class.getResource("/");
        } catch (Exception e)
        {
            // TODO
        }

        character = getImage(base, "data/character.png");
        background = getImage(base, "data/background.png");
    }

    @Override
    public void start()
    {
        bg1 = new Background(0,0);
        bg2 = new Background(2160, 0);
        robot = new Robot();
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
        while (true)
        {
            robot.update();
            bg1.update();
            bg2.update();
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
    public void paint(Graphics g)
    {

        g.drawImage(character, robot.getCenterX()-61, robot.getCenterY()-63, this);
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
                currentSprite = characterDown;
            System.out.println("down");
            break;

            case KeyEvent.VK_LEFT:
            robot.moveLeft();
            break;

            case KeyEvent.VK_RIGHT:
            robot.moveRight();
            break;

            case KeyEvent.VK_SPACE:
                robot.jump();
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
                robot.stop();
            break;

            case KeyEvent.VK_RIGHT:
                robot.stop();
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