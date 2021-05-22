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

    private Score score;
  
    private SunMoon sunmoon;

    public SunMoon getSunmoon() {
        return sunmoon;
    }

    private List<MobileObject> mobile;

    private ArenaDrawer arenaDrawer;

    private int floorH;

    private boolean night;

    public boolean isNight() {
        return night;
    }

    public Arena(int width, int height, int floor) throws IOException {
        night = false;
        this.width = width;
        this.height = height;
        floorH = floor;
        this.arenaDrawer = new ArenaDrawer(this);

        mobile = new ArrayList<MobileObject>();
        cowboy = new Cowboy(new Position(10, height-floorH), new Health(3));
        sunmoon = new SunMoon(new Position(width-10, 6));
        score = new Score(new Position(10 ,6));
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

    /**public List<FixedObject> getFixed() {
        return fixed;
    }

    public void setFixed(List<FixedObject> fixed) {
        this.fixed = fixed;
    }**/

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
  
    public void moveMobiles() {
        for(int i = 0; i < mobile.size(); i++) {
            MobileObject newM = mobile.get(i);
            newM.setPos(new Position(newM.getPos().getX()-1, newM.getPos().getY()));
            mobile.set(i, newM);
        }
    }

    public boolean day() {
        return !night;
    }

    public void switchTime() {
        night = !night;
        sunmoon.switchState();
    }

    private void spawnObstacle() throws IOException {
        double gen = Math.random();
        double ext = Math.random();
        int pos = (int) (width+Math.round(Math.random()*20));
        MobileObject mobileAdd;
        if(gen > 0.75) {
            if(ext > 0.8) {
                mobileAdd = new Robber(new Position(pos, height-floorH));
            } else {
                mobileAdd = new Pickpocket(new Position(pos, height-floorH));
            }
        } else {
            if(ext > 0.95) {
                mobileAdd = new Barrel(new Position(pos, height-floorH));
            } else {
                mobileAdd = new Cactus(new Position(pos, height-floorH));
            }
        }
        mobile.add(mobileAdd);
    }

    private void spawnBonus() throws IOException {
        double gen = Math.random();
        double ext = Math.random();
        int pos = (int) (width+Math.round(Math.random()*10));
        int floater = (int) (Math.round(Math.random()*height/3));
        MobileObject mobileAdd;
        if(gen > 0.7) {
            if(ext > 0.7) {
                mobileAdd = new Beer(new Position(pos, height-floorH*2-floater));
            } else {
                mobileAdd = new Coin(new Position(pos, height-floorH*2-floater));
            }
            mobile.add(mobileAdd);
        }
    }

    public void spawnObjects() throws IOException {
        spawnObstacle();
        spawnBonus();
    }

    public void cleanupObjs() {
        for(int i = 0; i < mobile.size(); i++) {
            if(mobile.get(i).getPos().getX() < -10) {
                mobile.remove(i);
                i--;
            }
        }
    }

    public void iterateCollisions() {
        for(MobileObject mob: mobile) {
            checkForHit(mob);
        }
    }

    private void checkForHit(MobileObject mob) {
        if(collCheck(cowboy.getPos(), mob.getPos(), cowboy.getWidth(), mob.getWidth(), 'x')) {
            if(collCheck(cowboy.getPos(), mob.getPos(), cowboy.getHeight(), mob.getHeight(), 'y')) {
                mob.hit(cowboy);
                mobile.remove(mob);
            }
        }
    }

    private boolean collCheck(Position a, Position b, int whA, int whB, Character type) {
        if(type == 'x')
            return a.getX() + whA > b.getX() && a.getX() < b.getX() + whB;
        else if(type == 'y')
            return a.getY() + whA > b.getY() && a.getY() < b.getY() + whB;
        return false;
    }
}
