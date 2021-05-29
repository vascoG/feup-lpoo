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
}