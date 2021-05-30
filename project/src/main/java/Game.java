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
        arenaDrawer.draw(gui);
    }




    public void run() {

        int FPS = 30;
        int frametime = 1000 / FPS;
        long acculmillis = 0;
        long millistospawn = 2000;
        long seconds = 0;
        long initTime = System.currentTimeMillis();
        while (true) {
            try {
                long startTime = System.currentTimeMillis() - initTime;
                if(arena.isCowboyDead())
                {
                    gui.close();
                    return;
                }
                if (acculmillis > millistospawn) {
                    acculmillis = 0;
                    arenaController.spawnObjects();
                    arenaController.cleanupObjs();
                    if ((startTime/1000) > seconds) {
                        seconds = startTime/1000;
                        if(seconds % 10 == 0) {
                            arenaController.switchTime();
                            FPS += 5;
                            millistospawn *= 0.9;
                            frametime = 1000 / FPS;
                        }
                    }
                }
                arenaController.updateCowboy();
                arenaController.updateMobiles();
                draw();
                if(!arenaController.nextMove(gui.getNextMovement())) {
                    gui.close();
                    return;
                }
                long elaspedTime = (System.currentTimeMillis()-initTime) - startTime;
                acculmillis += elaspedTime;
                long sleepTime = frametime - elaspedTime;
                if(sleepTime > 0) {
                    acculmillis+=sleepTime;
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


