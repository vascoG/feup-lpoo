import java.io.IOException;

public class Pickpocket extends Thief{

    public Pickpocket(Position pos) throws IOException {
        super(pos);
        toSteal = 0.5;
        readSpriteFromFile("pickpocket.txt");
        colour = "#565921";
    }
}
