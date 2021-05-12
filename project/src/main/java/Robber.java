import java.io.IOException;

public class Robber extends Thief{

    public Robber(Position pos) throws IOException {
        super(pos);
        toSteal = 1;
        readSpriteFromFile("robber.txt");
        colour="#b00b69";
    }
}
