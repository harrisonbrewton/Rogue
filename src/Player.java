import java.awt.*;

/**
 * Created by harrisonbrewton on 5/14/15.
 */
public class Player extends Box
{

    private Rectangle gameRectangle;
    private GWindow window;

    public Player(int x, int y, GWindow window)
    {
        super(x, y, "Octorok.png", window);
        color = Color.RED;
        this.window = window;
        this.gameRectangle = window.getGameRectangle();
    }

    public void update(boolean[] input)
    {
        int[] moveVector = new int[2];
        if(input[0])
        {
            moveVector[1] -= 5;
            //gameRectangle.translate(0, -2);
        }
        if(input[1])
        {
            moveVector[0] -= 5;
            //gameRectangle.translate(-2, 0);
        }
        if(input[2])
        {
            moveVector[1] += 5;
            //gameRectangle.translate(0, 2);
        }
        if(input[3])
        {
            moveVector[0] += 5;
            //gameRectangle.translate(2, 0);
        }

        safeMove(moveVector);

        gameRectangle.x = x - gameRectangle.width/2 + width/2;
        gameRectangle.y = y - gameRectangle.height/2 + height/2;

        System.out.println(gameRectangle);
    }

    public void safeMove(int[] movementVector)
    {

        x += movementVector[0];

        for (GameObject object : window.getObjects())
        {
            if(object == this)
            {
                continue;
            }
            if(this.getBoundingRectangle().intersects(object.getBoundingRectangle()))
            {
                x-=movementVector[0];
            }
        }

        y += movementVector[1];

        for (GameObject object : window.getObjects() )
        {
            if (object == this)
                continue;
            if (object.getBoundingRectangle().intersects(this.getBoundingRectangle()))
                y -= movementVector[1];
        }



    }
}
