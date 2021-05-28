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

    public Game() {

        try {
            gui = new LanternaGUI(150, 40);
            arena = new Arena(150,40, 7);
            arenaDrawer = new ArenaDrawer(arena);

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
        boolean jumping = false;
        boolean jumpingDown = false;
        boolean doubleJumping = false;
        long seconds = 0;
        while (true) {



            try {

                long startTime = System.currentTimeMillis();
                long nseconds = startTime / 1000;

                if(arena.getCowboy().getHealth().getCurrentHealth() == 0)
                {
                    gui.close();
                }

                if (nseconds > seconds+1) {
                    seconds = nseconds;
                    arena.spawnObjects();
                    if (seconds % 10 == 0) {
                        arena.switchTime();
                        arena.cleanupObjs();
                        FPS += 10;
                    }
                }
                if (jumping) {
                    arena.getCowboy().pos.y--;
                    if (arena.getCowboy().yInitial - 15 >= arena.getCowboy().pos.y) {
                        jumping = false;
                        jumpingDown = true;
                    }
                }
                if (doubleJumping) {
                    arena.getCowboy().pos.y--;
                    if (arena.getCowboy().yInitial - 20 >= arena.getCowboy().pos.y) {
                        doubleJumping = false;
                        jumpingDown = true;
                    }
                } else if (jumpingDown) {
                    arena.getCowboy().pos.y++;
                    if (arena.getCowboy().yInitial == arena.getCowboy().pos.y)
                        jumpingDown = false;
                }
                arena.moveMobiles();
                arena.iterateCollisions();
                draw();
                switch (gui.getNextMovement()) {
                    case UP:
                        if (!jumpingDown)
                            jumping = true;
                        break;
                        case DOWN:
                            if(jumping || doubleJumping) {
                                jumping = false;
                                doubleJumping = false;
                                jumpingDown = true;
                            }
                            break;
                        case DOUBLEUP:
                            if (!jumpingDown)
                                doubleJumping = true;
                            break;
                        case QUIT:
                            gui.close();
                            return;
                        case NONE:
                            break;
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


