import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class ArenaDrawer {

    private Arena arena;

    public ArenaDrawer(Arena arena) {
        this.arena = arena;
    }

    public void draw(TextGraphics graphics)
    {
        drawArena(graphics);
        drawFixed(arena.getFixed());
        drawMobiled(arena.getMobile());
        drawCowboy(graphics, arena.getCowboy());
    }

    private void drawCowboy(TextGraphics graphics, Cowboy cowboy) {
        cowboy.draw(graphics);
    }

    private void drawMobiled(List<MobileObject> mobile) {

    }

    private void drawFixed(List<FixedObject> fixed) {

    }

    private void drawArena(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffb700"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5e3a14"));
        graphics.fillRectangle(new TerminalPosition(0, arena.getHeight()- arena.getFloorH()), new TerminalSize(arena.getWidth(), arena.getFloorH()), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffb700"));
    }
}
