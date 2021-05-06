import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    Position pos; //left bottom corner
    List<List<Character>> sprite;

    public Element(Position pos) {
        this.pos = pos;
        sprite = new ArrayList<List<Character>>();
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void readSpriteFromFile(String filename) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (reader.ready()) {
            String line = reader.readLine();
            List<Character> newL = new ArrayList<Character>();
            for(Character c: line.toCharArray()) {
                newL.add(c);
            }
            sprite.add(newL);
        }
    }

    public void draw(TextGraphics graphics) {
        //draws from bottom to top
        for(int line = sprite.size()-1; line >= 0; line--) {
            for(int col = 0; col < sprite.get(line).size(); col++) {
                Character ch = sprite.get(line).get(col);
                if(ch == ' ') {
                    continue;
                }
                graphics.putString(new TerminalPosition(pos.getX()+col, pos.getY()-(sprite.size()-line)), String.valueOf(ch));
            }
        }
    }
}
