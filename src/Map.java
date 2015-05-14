import java.io.*;
import java.util.ArrayList;

/**
 * Created by harrisonbrewton on 5/14/15.
 */
public class Map
{
    //list of game objects to be created
    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    //the window of the game
    private GWindow gWindow;

    //
    public Map(File file, GWindow gWindow)
    {
        this.gWindow = gWindow;

        BufferedReader bufferedReader = null;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(file));

            String curLine = "";

            while ( (curLine = bufferedReader.readLine()) != null)
            {
                addObject(curLine); //create an object with each line
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void addObject (String line)
    {
        ArrayList<Integer> parameters = new ArrayList<Integer>();
        String name = line.substring(0,  line.indexOf("("));
        String curWord = "";
        for (int i = line.indexOf("("); i < line.length(); i++)
        {
            char curChar = line.charAt(i);

            if (curChar == '(')
            {
                continue;
            }
            if (curChar == ',')
            {
                parameters.add(Integer.parseInt(curWord));
                curWord = "";
                continue;
            }
            if (curChar == ' ')
            {
                continue;
            }
            if (curChar == ')')
            {
                parameters.add(Integer.parseInt(curWord));
            }

            curWord += curChar;
        }

        if(name.equals("BOX"))
        {
            gameObjects.add(new Box(parameters.get(0), parameters.get(1), "redsqr.png", gWindow));
        }
        if(name.equals("PLAYER"))
        {
            gameObjects.add(new Player(parameters.get(0), parameters.get(1), gWindow));
        }
    }
}
