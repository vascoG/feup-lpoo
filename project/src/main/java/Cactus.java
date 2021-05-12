import java.io.IOException;

public class Cactus extends DangerousObstacle{
    public Cactus(Position pos) throws IOException {
        super(pos);
        toDamage = 1;
        readSpriteFromFile("cactus.txt");
        colour="#0a6121";
    }
}
