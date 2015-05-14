import java.awt.*;

/**
 * Created by harrisonbrewton on 5/14/15.
 *
 * Box class which will be extended upon for most game objects
 */
public class Box implements GameObject
{
    private int x, y;
    private int width, height;

    public Box(int x, int y /*, int width, int height*/)
    {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 100;
    }
    
    public void draw(Graphics2D graphics2D, GWindow gWindow)
    {
        //draw based on ratio
        graphics2D.fillRect(((int) (gWindow.getDisplayRectangle().x + x * gWindow.ratio)), ((int) (gWindow.getDisplayRectangle().y + y * gWindow.ratio)), ((int) (100 * gWindow.ratio)), ((int) (100 * gWindow.ratio)));
    }

    @Override
    //to be used with collision
    public Rectangle getBoundingRectangle()
    {
        return new Rectangle(x, y, width, height);
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
