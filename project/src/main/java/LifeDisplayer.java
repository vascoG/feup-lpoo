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
        for(int line = sprite.size()-1; line >= 0; line--) {
            for(int col = 0; col < sprite.get(line).size(); col++) {
                Character ch = sprite.get(line).get(col);
                if(ch == '?') {
                    continue;
                }
                gui.drawObj(new Position(pos.getX()+col + number, pos.getY()-(sprite.size()-line)), String.valueOf(ch), colour);
                //se calhar usamos so quadrados e em função da letra definia uma cor de fundo
            }
        }
    }


}
