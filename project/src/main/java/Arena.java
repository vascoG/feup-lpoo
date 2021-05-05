import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;

    private int height;

    private Cowboy cowboy;

    private List<FixedObject> fixed;

    private List<MobileObject> mobile;

    private ArenaDrawer arenaDrawer;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.arenaDrawer = new ArenaDrawer(this);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cowboy getCowboy() {
        return cowboy;
    }

    public void setCowboy(Cowboy cowboy) {
        this.cowboy = cowboy;
    }

    public List<FixedObject> getFixed() {
        return fixed;
    }

    public void setFixed(List<FixedObject> fixed) {
        this.fixed = fixed;
    }

    public List<MobileObject> getMobile() {
        return mobile;
    }

    public void setMobile(List<MobileObject> mobile) {
        this.mobile = mobile;
    }

    public ArenaDrawer getArenaDrawer() {
        return arenaDrawer;
    }

    public void setArenaDrawer(ArenaDrawer arenaDrawer) {
        this.arenaDrawer = arenaDrawer;
    }
}
