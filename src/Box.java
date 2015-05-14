import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

/**
 * Created by harrisonbrewton on 5/14/15.
 *
 * Box class which will be extended upon for most game objects
 */
public class Box implements GameObject
{
    protected int x, y;
    protected int width, height;
    protected Color color;
    private GWindow gWindow;
    private Image image;

    public Box(int x, int y, String string, GWindow gWindow)
    {
        this.gWindow = gWindow;
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 100;
        color = Color.GREEN;
        try
        {
            image = ImageIO.read(new File(string));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D graphics2D, GWindow gWindow)
    {
        //draw based on ratio
        graphics2D.setColor(color);
        AffineTransform affineTransform = new AffineTransform(1, 0, 0, 1, 0, 0);
        affineTransform.translate((int) (gWindow.getDisplayRectangle().x + ( (x-gWindow.getGameRectangle().x) * gWindow.ratio)), (int) (gWindow.getDisplayRectangle().y + ( (y-gWindow.getGameRectangle().y) * gWindow.ratio)));

        graphics2D.fillRect((int) (gWindow.getDisplayRectangle().x + ( (x-gWindow.getGameRectangle().x) * gWindow.ratio)), (int) (gWindow.getDisplayRectangle().y + ( (y-gWindow.getGameRectangle().y) * gWindow.ratio)), ((int) (100 * gWindow.ratio)), ((int) (100 * gWindow.ratio)));
        graphics2D.drawImage(image.getScaledInstance(((int) (100 * gWindow.ratio)), ((int) (100 * gWindow.ratio)), Image.SCALE_FAST), affineTransform, gWindow);
    }

    @Override
    //to be used with collision
    public Rectangle getBoundingRectangle()
    {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void update(boolean[] input)
    {

    }

    @Override
    public String toString()
    {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
