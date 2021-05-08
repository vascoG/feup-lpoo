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


    private GUI gui;
    private KeyStroke key;
    private Arena arena;


    public Game() {

        try {
            gui = new LanternaGUI(150, 40);
            arena = new Arena(150,40, 7);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void draw() throws IOException
    {
        gui.clear();
        arena.getArenaDrawer().draw(gui);
        gui.refresh();
    }

    public void run()
    {
        while(true)
        {
            try
            {
                draw();
                key = gui.pollInput();
                /*
                if(processKey() != 0)
                {
                    screen.close();
                }
                */
                if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                {
                    gui.close();
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


