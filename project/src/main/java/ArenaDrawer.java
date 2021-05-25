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

    public void draw(GUI gui)
    {
        drawArena(gui);
        //drawFixed(gui);
        drawMobiled(gui, arena.getMobile());
        drawCowboy(gui, arena.getCowboy());
        drawHealth(gui,arena.getLf());
    }

    private void drawCowboy(GUI gui, Cowboy cowboy) {
        cowboy.draw(gui);
    }

    private void drawMobiled(GUI gui, List<MobileObject> mobile) {
        for(MobileObject obj: mobile) {
            obj.draw(gui);
        }
    }

    private void drawHealth(GUI gui , LifeDisplayer lf)
    {
        lf.displayHealth(gui, arena.getHealth());
    }
    /**private void drawFixed(GUI gui) {
        arena.getSunmoon().draw(gui);

        arena.getScore().draw(gui, arena.isNight());
    }**/


    private void drawArena(GUI gui){
        String background;
        if(arena.day())
            background = "#ffb700";
        else
            background = "#40317d";
        gui.fillRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), background, ' ');
        gui.fillRectangle(new Position(0, arena.getHeight()- arena.getFloorH()), new Position(arena.getWidth(), arena.getFloorH()), "#5e3a14", ' ');
        arena.getSunmoon().draw(gui);
        arena.getScore().draw(gui, background);


        /**graphics.setBackgroundColor(TextColor.Factory.fromString("#ffb700"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5e3a14"));
        graphics.fillRectangle(new TerminalPosition(0, arena.getHeight()- arena.getFloorH()), new TerminalSize(arena.getWidth(), arena.getFloorH()), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffb700"));**/
    }
}
