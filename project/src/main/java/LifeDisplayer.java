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
        for(int i = 0; i < health.getCurrentHealth(); i++) {
            drawCorazons(gui, i*15);
        }
    }

    private void drawCorazons(GUI gui ,int number)
    {
        pos.x += number;
        super.draw(gui);
        pos.x -= number;
    }


}
