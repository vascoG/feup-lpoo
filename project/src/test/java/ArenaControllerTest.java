import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaControllerTest {
    Arena arena;
    ArenaController arenaController;
    List<MobileObject> mobileObjectList;

    @BeforeEach
    void setUp() throws IOException {
        arena = new Arena(150,40, 7);
        arenaController = new ArenaController(arena);
        mobileObjectList = new ArrayList<MobileObject>();
    }

    @Test
    void collisions() throws IOException {
        Cactus obj1 = Mockito.mock(Cactus.class);
        Cactus obj2 = Mockito.mock(Cactus.class);
        Mockito.when(obj1.getPos()).thenReturn(arena.getCowboy().getPos());
        Mockito.when(obj1.getWidth()).thenReturn(10);
        Mockito.when(obj1.getHeight()).thenReturn(10);
        Mockito.when(obj2.getPos()).thenReturn(new Position(300, 300));
        Mockito.when(obj2.getWidth()).thenReturn(10);
        Mockito.when(obj2.getHeight()).thenReturn(10);
        List<MobileObject> mobileObjectList = new ArrayList<MobileObject>();
        mobileObjectList.add(obj1);
        mobileObjectList.add(obj2);
        arena.setMobile(mobileObjectList);
        arenaController.updateMobiles();
        Mockito.verify(obj1, Mockito.times(1)).hit(arena.getCowboy());
        Mockito.verify(obj2, Mockito.times(0)).hit(arena.getCowboy());
    }

    @Test
    void movement() throws IOException {
        Cactus moveboi = new Cactus(new Position(100, 7));
        mobileObjectList.add(moveboi);
        arena.setMobile(mobileObjectList);
        arenaController.updateMobiles();
        Assertions.assertEquals(moveboi.getPos().getX(), 99);
    }

    @Test
    void cleanup() throws IOException {
        Cactus moveboi = new Cactus(new Position(-50, 7));
        mobileObjectList.add(moveboi);
        arena.setMobile(mobileObjectList);
        arenaController.cleanupObjs();
        Assertions.assertEquals(arena.getMobile().size(), 0);
    }

    @Test
    void nightSwitch() throws IOException {
        SunMoon sun = Mockito.mock(SunMoon.class);
        arena.setSunmoon(sun);
        Assertions.assertEquals(arena.day(), true);
        arenaController.switchTime();
        Assertions.assertEquals(arena.day(), false);
        Mockito.verify(sun, Mockito.times(1)).switchState();
        arenaController.switchTime();
        Assertions.assertEquals(arena.day(), true);
        Mockito.verify(sun, Mockito.times(2)).switchState();
    }
}
