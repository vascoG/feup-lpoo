import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;

    private int height;

    private Cowboy cowboy;

    private List<FixedObject> fixed;

    private List<MobileObject> mobile;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }


    private void ArenaDraw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffb700"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }

    public void draw(TextGraphics graphics)
    {
        ArenaDraw(graphics);
    }
}
