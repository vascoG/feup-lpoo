import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class HitTests {
    private Cowboy cowboy;
    private MobileObject hitter;

    @BeforeEach
    void setUp() throws IOException {
        cowboy = new Cowboy(new Position(5, 5), new Health(5));
    }

    @Test
    void hitCactus() throws IOException {
        hitter = new Cactus(new Position(5, 5));
        hitter.hit(cowboy);
        Assertions.assertEquals(4, cowboy.getHealth().getCurrentHealth());
        hitter.hit(cowboy);
        hitter.hit(cowboy);
        Assertions.assertEquals(2, cowboy.getHealth().getCurrentHealth());
    }

    @Test
    void hitBarrel() throws IOException {
        hitter = new Barrel(new Position(0, 0));
        hitter.hit(cowboy);
        Assertions.assertEquals(0, cowboy.getHealth().getCurrentHealth());
    }

    @Test
    void hitPick() throws IOException {
        hitter = new Pickpocket(new Position(13, 37));
        int coins = (int)Math.round(Math.random()*20);
        cowboy.setCoinsCollected(coins);
        hitter.hit(cowboy);
        Assertions.assertEquals((int)(coins*0.5), cowboy.getCoinsCollected());
    }

    @Test
    void hitRob() throws IOException {
        hitter = new Robber(new Position(13, 37));
        int coins = (int)Math.round(Math.random()*20);
        cowboy.setCoinsCollected(coins);
        hitter.hit(cowboy);
        Assertions.assertEquals(0, cowboy.getCoinsCollected());
    }
    @Test
    void hitCoins() throws IOException {
        hitter = new Coin(new Position(13, 37));
        int coins = (int)Math.round(Math.random()*20);
        for(int i = 0; i < coins; i++)
            hitter.hit(cowboy);
        Assertions.assertEquals(coins, cowboy.getCoinsCollected());
    }
    @Test
    void hitBeer() throws IOException {
        hitter = new Beer(new Position(20, 21));
        cowboy.getHealth().setCurrentHealth(cowboy.getHealth().getCurrentHealth()-4);
        hitter.hit(cowboy);
        Assertions.assertEquals(cowboy.getHealth().getMaxHealth(), cowboy.getHealth().getCurrentHealth());
    }
}
