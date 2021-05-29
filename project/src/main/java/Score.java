import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Score extends FixedObject{

    private int score;
    private Number firstD, secondD, thirdD;


    public Score(Position pos) throws IOException {
        super(pos);

        readSpriteFromFile("score.txt");

        score = 0;

        colour = "#000000";

        firstD = new Number(new Position(pos.getX()+width+1, pos.getY()));
        secondD = new Number(new Position(firstD.getPos().getX()+firstD.getWidth(),pos.getY()));
        thirdD = new Number(new Position(secondD.getPos().getX()+secondD.getWidth(),pos.getY()));

    }


    public void draw(GUI gui) {
        super.draw(gui);
        firstD.draw(gui);
        secondD.draw(gui);
        thirdD.draw(gui);
    }


    public void updateScore(int score) {
        this.score = score;

        thirdD.setN(score % 10);
        secondD.setN((score/10)%10);
        firstD.setN((score/100)%10);
    }


}
