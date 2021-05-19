import java.io.IOException;

public class SunMoon extends FixedObject{
    boolean state;
    public SunMoon(Position pos) throws IOException {
        super(pos);
        readSpriteFromFile("sun.txt");
        state = true;
        colour="#ff6f00";
    }

    @Override
    public void draw(GUI gui) {
        if(state)
            colour="#ff6f00";
        else
            colour="#f2f2f2";
        super.draw(gui);
    }

    public void switchState() {
        state = !state;
    }
}
