import java.io.IOException;

public class SunMoon extends FixedObject{
    public SunMoon(Position pos) throws IOException {
        super(pos);
        readSpriteFromFile("sun.txt");
        colour="#ff6f00";
    }
}
