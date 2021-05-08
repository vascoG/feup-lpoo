import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void clear() {
        gui.clear();

        Mockito.verify(screen,Mockito.times(1)).clear();
    }

    @Test
    void refresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen,Mockito.times(1)).refresh();
    }

    @Test
    void close() throws IOException {
        gui.close();

        Mockito.verify(screen,Mockito.times(1)).close();
    }

    @Test
    void getNextMovement() throws IOException {

    }

    @Test
    void drawText() {
        gui.drawText(new Position(5,5),"Test","#336699");

        Mockito.verify(textGraphics,Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(textGraphics,Mockito.times(1)).putString(5,5,"Test");
    }

    @Test
    void fillRectangle() {
        gui.fillRectangle(new Position(5,5),new Position(10,10),"#336699", 'X');

        Mockito.verify(textGraphics,Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(textGraphics,Mockito.times(1)).fillRectangle(new TerminalPosition(5,5),new TerminalSize(10,10),'X');
    }

    @Test
    void pollInput() throws IOException {
        gui.pollInput();

        Mockito.verify(screen,Mockito.times(1)).pollInput();
    }
}