import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {
    Arena arena;

    @BeforeEach
    void setUp() throws IOException {
        arena = new Arena(150,40, 7);
    }

    @Test
    void getWidth() {
        Assertions.assertEquals(150,arena.getWidth());
    }

    @Test
    void setWidth() {
        arena.setWidth(100);
        Assertions.assertEquals(100,arena.getWidth());
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(40,arena.getHeight());
    }

    @Test
    void setHeight() {
        arena.setHeight(30);
        Assertions.assertEquals(30,arena.getHeight());
    }

    @Test
    void getFloorH() {
        Assertions.assertEquals(7,arena.getFloorH());
    }

    /*
    @Test
    void setCowboy() throws IOException {
        arena.setCowboy(new Cowboy(new Position(5,5),new Health(4)));
        Assertions.assertEquals(4,arena.getCowboy().getHealth());
    }
    */
    @Test
    void getFixed() {
    }

    @Test
    void setFixed() {
    }

    @Test
    void getMobile() {
    }

    @Test
    void setMobile() {
    }

    @Test
    void getArenaDrawer() {
    }

    @Test
    void setArenaDrawer() {
    }

    @Test
    void cowboyDown() {
    }

    @Test
    void cowboyJump() {
    }
}