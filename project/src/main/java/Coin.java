import java.io.IOException;

public class Coin extends Collect{

    public Coin(Position pos) throws IOException {
        super(pos);
        readSpriteFromFile("coin.txt");
        colour="#f2ff00";
    }
    void hit(Cowboy cowboy) {
        cowboy.setCoinsCollected(cowboy.getCoinsCollected()+1);
    }
}
