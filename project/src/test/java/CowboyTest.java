import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CowboyTest {
    Cowboy cowboy;

    @BeforeEach
    void setUp() throws IOException {
       cowboy = new Cowboy(new Position(10,10),new Health(10));

    }

    @Test
    void getHealth() throws IOException {
        Assertions.assertEquals(10.,cowboy.getHealth().getCurrentHealth());
        Assertions.assertEquals(10,cowboy.getHealth().getMaxHealth());
    }

    @Test
    void setHealth() throws IOException {
        Health health = new Health(5);
        cowboy.setHealth(health);
        Assertions.assertEquals(5,cowboy.getHealth().getCurrentHealth());
        Assertions.assertEquals(5,cowboy.getHealth().getMaxHealth());
    }

    @Test
    void getCoinsCollected() {
        Assertions.assertEquals(0,cowboy.getCoinsCollected());

    }

    @Test
    void setCoinsCollected() {
        cowboy.setCoinsCollected(5);
        Assertions.assertEquals(5,cowboy.getCoinsCollected());
    }

    @Test
    void moveDown() {
        cowboy.moveDown();
        Assertions.assertEquals(12,cowboy.getPos().getY());
    }

    @Test
    void moveUp() {
        cowboy.moveUp();
        Assertions.assertEquals(8,cowboy.getPos().getY());
    }
}