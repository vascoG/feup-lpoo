import java.io.IOException;

public class Score extends FixedObject{

    private int score;


    public Score(Position pos) throws IOException {
        super(pos);

        readSpriteFromFile("score.txt");

        score = 0;

        colour = "#ffb700";

    }

    public void draw(GUI gui) {
        //draws from bottom to top
        for(int line = sprite.size()-1; line >= 0; line--) {
            for(int col = 0; col < sprite.get(line).size(); col++) {
                Character ch = sprite.get(line).get(col);
                if(ch == '?') {
                    continue;
                }
                gui.drawText(new Position(pos.getX()+col, pos.getY()-(sprite.size()-line)), String.valueOf(ch), colour);
                //se calhar usamos so quadrados e em função da letra definia uma cor de fundo
            }
        }
    }

}
