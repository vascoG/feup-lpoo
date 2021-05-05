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

import static com.googlecode.lanterna.input.KeyType.*;

public class Game {


    private Screen screen;
    private KeyStroke key;
    private Arena arena;


    public Game() {

        try {
            //Configure Default Terminal Factory
            TerminalSize terminalSize = new TerminalSize(150, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            arena = new Arena(150,40, 7);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void draw() throws IOException
    {
        screen.clear();
        arena.getArenaDrawer().draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run()
    {
        while(true)
        {
            try
            {
                draw();
                key = screen.readInput();
                /*
                if(processKey() != 0)
                {
                    screen.close();
                }
                */
                if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                {
                    screen.close();
                }

                if(key.getKeyType() == KeyType.EOF)
                {
                    break;
                }

            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}


