import java.io.IOException;

public abstract class Collect extends MobileObject{
    public Collect(Position pos) {
        super(pos);
    }
    @Override
    public void readSpriteFromFile(String filename) throws IOException {
        super.readSpriteFromFile(filename);
        width = 5;
        height = 5;
    }
}
