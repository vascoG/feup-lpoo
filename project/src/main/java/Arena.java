import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;

    private int height;

    private Cowboy cowboy;



    private List<FixedObject> fixed;

    private Score score;

    private List<MobileObject> mobile;

    private ArenaDrawer arenaDrawer;

    private int floorH;


    public Arena(int width, int height, int floor) throws IOException {
        this.width = width;
        this.height = height;
        floorH = floor;
        this.arenaDrawer = new ArenaDrawer(this);

        mobile = new ArrayList<MobileObject>();
        fixed = new ArrayList<FixedObject>();
        cowboy = new Cowboy(new Position(10, height-floorH), new Health(3));
        mobile.add(new Cactus(new Position(16, height-floorH)));
        mobile.add(new Barrel(new Position(24, height-floorH)));
        fixed.add(new SunMoon(new Position(width-10, 6)));
        score = new Score(new Position(10 ,6));
        mobile.add(new Pickpocket(new Position(40, height-floorH)));
        mobile.add(new Robber(new Position(60, height-floorH)));
        mobile.add(new Coin(new Position(70, height-floorH-20)));
        mobile.add(new Beer(new Position(100, height-floorH-20)));
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

    public int getFloorH() {
        return floorH;
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

    public Score getScore() {
        return score;
    }

    public void updateScore() {
        this.score.updateScore();
    }

    public void cowboyDown() {
        if(cowboy.getPos().getY()>cowboy.yInitial)
        cowboy.moveDown();
    }

    public void cowboyJump() {
        cowboy.moveUp();
    }


}
