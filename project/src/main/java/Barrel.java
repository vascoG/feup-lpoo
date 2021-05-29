import java.io.IOException;

public class Barrel extends DangerousObstacle{

    public Barrel(Position pos) throws IOException {
        super(pos);
        toDamage = 999;
        readSpriteFromFile("barrel.txt");
        colour = "#801e0d";
    }
}
