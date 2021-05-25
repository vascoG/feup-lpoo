import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    Position pos; //left bottom corner
    int width;
    int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    List<List<Character>> sprite;
    String colour;


    public Element(Position pos) {
        this.pos = pos;
        sprite = new ArrayList<List<Character>>();
        width = 0;
        height = 0;
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
            List<Character> newL = new ArrayList<>();
            int curwidth = 0;
            for(Character c: line.toCharArray()) {
                newL.add(c);
                curwidth++;
            }
            if(curwidth > width)
                width = curwidth;
            sprite.add(newL);
            height++;
        }
    }



    public void draw(GUI gui) {
        //draws from bottom to top
        for(int line = sprite.size()-1; line >= 0; line--) {
            for(int col = 0; col < sprite.get(line).size(); col++) {
                Character ch = sprite.get(line).get(col);
                if(ch == '?') {
                    continue;
                }
                gui.drawObj(new Position(pos.getX()+col, pos.getY()-(sprite.size()-line)), String.valueOf(ch), colour);
            }
        }
    }
}
