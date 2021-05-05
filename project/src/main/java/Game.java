import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.*;

public class Game {


    private Screen screen;
    private KeyStroke key;
    private Arena arena;


    public Game() {

        arena = new Arena(5000,700);

        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void draw() throws IOException
    {
        screen.clear();
        arena.draw(screen.newTextGraphics());
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


