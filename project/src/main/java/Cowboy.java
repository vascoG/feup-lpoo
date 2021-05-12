import java.io.FileNotFoundException;
import java.io.IOException;

public class Cowboy extends Element{
    Health health;
    int coinsCollected;
    int yInitial ;
    public Cowboy(Position pos, Health h) throws IOException {
        super(pos);
        yInitial = pos.getY();
        health = h;
        coinsCollected = 0;
        readSpriteFromFile("cowboy.txt");
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public void setCoinsCollected(int coinsCollected) {
        this.coinsCollected = coinsCollected;
    }

    public void moveDown() {
        pos.setY(pos.getY()+2);
    }

    public void moveUp() {
        pos.setY(pos.getY()-2);
    }

    public void resetY() {
        pos.setY(yInitial);
    }
}
