import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by harrison_brewton on 5/14/15.
 *
 * The main GWindow used for creating a scalable screen, good smileness
 * keep this as clean as possible
 */
public class GWindow extends JPanel implements ActionListener
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Rouger");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new GWindow());
        frame.pack();
        frame.setVisible(true);
    }

    private Rectangle gameRectangle; //this is the 800 by 600 window to be used for consistent graphics
    private Rectangle displayRectangle; //this is the rectangle used to show what will be drawn on screen

    public double ratio;

    public GWindow()
    {
        //sets the perefred size of shape
        setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());

        //iniates our two beloved rectangles
        gameRectangle = new Rectangle(0, 0, 800, 600);
        displayRectangle = new Rectangle();

        //a rad timer
        Timer timer = new Timer(33, this);
        timer.start();

        ratio = 0;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        updateDisplayRectangle();
        repaint();
    }

    private void updateDisplayRectangle()
    {
        //find the ratio of the 800 by 600 game rectangle compared to screen given
        double ratioX = getWidth()/gameRectangle.getWidth();
        double ratioY = getHeight()/gameRectangle.getHeight();

        //other wise tries to fit the ratios as bust as possible based on the limiting reagent
        if(ratioX > ratioY)
        {
            displayRectangle.height = getHeight();
            displayRectangle.y = 0;
            displayRectangle.width = ((int) (4.0 * displayRectangle.height / 3));
            displayRectangle.x = (getWidth()-displayRectangle.width)/2;
            ratio = ratioY;
        }
        if(ratioY >= ratioX)
        {
            displayRectangle.width = getWidth();
            displayRectangle.x = 0;
            displayRectangle.height = ((int) (3.0 * displayRectangle.width / 4));
            displayRectangle.y = (getHeight()-displayRectangle.height)/2;
            ratio = ratioX;
        }

    }

    public void paint (Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(displayRectangle);

        graphics2D.setColor(Color.GREEN);
        Box box = new Box(100, 100);
        box.draw(graphics2D, this);
    }

    public Rectangle getGameRectangle()
    {
        return gameRectangle;
    }

    public Rectangle getDisplayRectangle()
    {
        return displayRectangle;
    }
}
