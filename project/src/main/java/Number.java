import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Number extends FixedObject{
    private int n;
    private List<List<List<Character>>> spriteList;

    Number(Position pos) throws IOException {
        super(pos);
        this.n = 0;
        this.colour = "#000000";
        this.spriteList = new ArrayList<List<List<Character>>>();
        for(int i = 0; i < 10; i++) {
            String toRead = String.format("numbers/%d.txt", i);
            this.spriteList.add(readSpriteFromFile(toRead));
        }
    }

    public void draw(GUI gui) {
        this.sprite = this.spriteList.get(this.n);
        super.draw(gui);
    }



    public void setN(int n) {
        this.n = n;
    }
}
