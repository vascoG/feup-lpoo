import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GUI{
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width,height);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width,height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        return terminalFactory.createTerminal();
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public MOVEMENT getNextMovement() throws IOException {
        KeyStroke keyStroke = screen.readInput();
        if(keyStroke.getKeyType() == KeyType.EOF)
            return MOVEMENT.QUIT;
        if(keyStroke.getKeyType()!= KeyType.Character)
            return MOVEMENT.NONE;
        if(keyStroke.getCharacter()=='q')
            return MOVEMENT.QUIT;
        if(keyStroke.getCharacter()=='w')
            return MOVEMENT.UP;
        if(keyStroke.getCharacter()=='s')
            return MOVEMENT.DOWN;
        if(keyStroke.getCharacter()=='e')
            return MOVEMENT.DOUBLEUP;
        return MOVEMENT.NONE;
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.putString(position.getX(),position.getY(),text);


    }
    @Override
    public void drawObj(Position position, String text, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(),position.getY(),text);


    }
    @Override
    public void fillRectangle(Position position, Position size, String color, Character character) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(size.getX(), size.getY()), character);
    }

    @Override
    public KeyStroke readInput() throws IOException {
        return screen.readInput();
    }
}
