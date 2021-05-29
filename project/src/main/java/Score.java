import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Score extends FixedObject{

    private int score;


    public Score(Position pos) throws IOException {
        super(pos);

        readSpriteFromFile("score.txt");

        score = 0;

        colour = "#000000";

    }


    public void draw(GUI gui,String background) {
        //draws from bottom to top
        for(int line = sprite.size()-1; line >= 0; line--) {
            for(int col = 0; col < sprite.get(line).size(); col++) {
                Character ch = sprite.get(line).get(col);
                if(ch == '?') {
                    continue;
                }
                gui.drawText(new Position(pos.getX()+col, pos.getY()-(sprite.size()-line)), String.valueOf(ch), colour,background);
            }
        }
    }


    public void updateScore(int score, Number firstD, Number secondD, Number thirdD) throws IOException {
        this.score = score;

        thirdD.setN(score % 10);
        secondD.setN((score/10)%10);
        firstD.setN((score/100)%10);
    }


}
