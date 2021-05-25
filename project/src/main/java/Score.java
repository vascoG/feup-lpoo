import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Score extends FixedObject{

    private int score;


    public Score(Position pos) throws IOException {
        super(pos);

        readSpriteFromFile("score.txt");

        score = 0;

        colour = "#ffb700";

    }

    public void draw(GUI gui, String background)  {
        colour = background;
        //draws from bottom to top

            List<List<Character>>sprite_copy = clone(sprite);

            addScoreToSprite(sprite_copy);

            for(int col = 0; col < sprite_copy.get(0).size(); col++) {
                Character ch = sprite_copy.get(0).get(col);
                if(ch == '?') {
                    continue;
                }
                gui.drawText(new Position(pos.getX()+col, pos.getY()-(sprite_copy.size())), String.valueOf(ch), colour);
            }




    }

    private void addScoreToSprite(List<List<Character>> sprite)
    {
        String sc = String.valueOf(score);

        for (int i = 0; i < sc.length() ; i++)
        {
            sprite.get(0).add(sc.charAt(i));
        }

    }

    private List<List<Character>> clone(List<List<Character>> sprite)
    {
        List<List<Character>>sprite_copy = new ArrayList<List<Character>>();
        sprite_copy.add(new ArrayList<>());

        for(int col = 0 ;  col < sprite.get(0).size();col++)
        {
            sprite_copy.get(0).add(sprite.get(0).get(col));
        }

        return sprite_copy;
    }

    public void updateScore(int score)
    {
        this.score = score;
    }


}
