import java.awt.*;

/**
 * Created by harrisonbrewton on 5/14/15.
 *
 * used for any visible object on screen
 */
public interface GameObject
{

    public void draw(Graphics2D graphics2D, GWindow gWindow); //to draw

    public String toString(); //obvious

    public Rectangle getBoundingRectangle(); //to be used with collison
}
