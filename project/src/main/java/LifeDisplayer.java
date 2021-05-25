import java.io.IOException;
import java.util.List;

public class LifeDisplayer extends FixedObject{



    public LifeDisplayer(Position pos) throws IOException {
        super(pos);


        readSpriteFromFile("health.txt");

        colour = "#FF0000";
    }

    public void displayHealth(GUI gui , Health health)
    {

        switch(health.getCurrentHealth())
        {
            case 1:
                drawCorazons(gui,0);
                break;
            case 2:
                drawCorazons(gui,0);
                drawCorazons(gui, 15);
                break;
            case 3:
                drawCorazons(gui,0);
                drawCorazons(gui, 15);
                drawCorazons(gui, 30);
                break;
            default:
                break;
        }


    }

    private void drawCorazons(GUI gui ,int number)
    {
        pos.x += number;
        super.draw(gui);
        pos.x -= number;
    }


}
