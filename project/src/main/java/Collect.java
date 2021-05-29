import java.io.IOException;
import java.util.List;

public abstract class Collect extends MobileObject{
    public Collect(Position pos) {
        super(pos);
    }
    @Override
    public List<List<Character>> readSpriteFromFile(String filename) throws IOException {
        width = 5;
        height = 5;
        return super.readSpriteFromFile(filename);
    }
}
