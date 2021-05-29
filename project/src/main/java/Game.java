import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static com.googlecode.lanterna.input.KeyType.*;
import static java.lang.Thread.sleep;

public class Game {


    private GUI gui;
    private Arena arena;
    private ArenaDrawer arenaDrawer;
    private ArenaController arenaController;

    public Game() {

        try {
            gui = new LanternaGUI(150, 40);
            arena = new Arena(150,40, 7);
            arenaDrawer = new ArenaDrawer(arena);
            arenaController = new ArenaController(arena);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void draw() throws IOException
    {
        gui.clear();
        arenaDrawer.draw(gui);
        gui.refresh();
    }




    public void run() {

        int FPS = 30;
        int frametime = 1000 / FPS;
        long seconds = 0;
        long initTime = System.currentTimeMillis();
        while (true) {
            try {
                long startTime = System.currentTimeMillis();
                double nseconds = (startTime-initTime) / 1000;
                if(arena.isCowboyDead())
                {
                    gui.close();
                    return;
                }
                if (nseconds > seconds) {
                    seconds = Math.round(nseconds);
                    arenaController.spawnObjects();
                    if (seconds % 10 == 0) {
                        arenaController.switchTime();
                        arenaController.cleanupObjs();
                        FPS += 10;
                        frametime = 1000 / FPS;
                    }
                }
                arenaController.updateCowboy();
                arenaController.updateMobiles();
                draw();
                if(!arenaController.nextMove(gui.getNextMovement())) {
                    gui.close();
                    return;
                }
                long elaspedTime = System.currentTimeMillis() - startTime;
                long sleepTime = frametime - elaspedTime;
                try {
                    if (sleepTime > 0) Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


