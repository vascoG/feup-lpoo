import java.io.IOException;

public class Beer extends Collect{

    public Beer(Position pos) throws IOException {
        super(pos);
        readSpriteFromFile("beer.txt");
        colour="#473d00";
    }
    void hit(Cowboy cowboy) {
        Health health = cowboy.getHealth();
        health.setCurrentHealth(health.getMaxHealth());
        cowboy.setHealth(health);

    }
}
