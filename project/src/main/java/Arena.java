
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Arena {

    private int width;

    private int height;

    private Cowboy cowboy;

    private Score score;

    private SunMoon sunmoon;

    private LifeDisplayer lf;

    private List<MobileObject> mobile;

    private int floorH;

    private boolean night;

    public boolean isNight() {
        return night;
    }

    public void setDay(){
        night=false;
    }

    public void setNight()
    {
        night = true;
    }

    public SunMoon getSunmoon() {
        return sunmoon;
    }

    public void setSunmoon(SunMoon sunmoon) {
        this.sunmoon = sunmoon;
    }

    public Arena(int width, int height, int floor) throws IOException {
        night = false;
        this.width = width;
        this.height = height;
        floorH = floor;
        mobile = new ArrayList<MobileObject>();
        cowboy = new Cowboy(new Position(10, height-floorH), new Health(3));
        sunmoon = new SunMoon(new Position(width-10, 6));
        score = new Score(new Position(3 ,7));
        lf = new LifeDisplayer(new Position(50, 10));
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


    public List<MobileObject> getMobile() {
        return mobile;
    }

    public void setMobile(List<MobileObject> mobile) {
        this.mobile = mobile;
    }

    public Score getScore() throws IOException {
        score.updateScore(cowboy.coinsCollected);
        return score;
    }

    public LifeDisplayer getLf() {
        return lf;
    }

    public void setLf(LifeDisplayer lf) {
        this.lf = lf;
    }

    public boolean day() {
        return !night;
    }

    public boolean isCowboyDead()
    {
        return cowboy.getHealth().getCurrentHealth()==0;
    }

}
