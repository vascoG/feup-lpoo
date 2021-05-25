import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthTest {
    Health health;

    @BeforeEach
    void setUp() {
        health = new Health(3);
    }

    @Test
    void setCurrentHealth() {
        health.setCurrentHealth(2);
        Assertions.assertEquals(2,health.getCurrentHealth());
    }

    @Test
    void setMaxHealth() {
        health.setMaxHealth(4);
        Assertions.assertEquals(4,health.getMaxHealth());
    }

    @Test
    void checkLimits() {
        health.setCurrentHealth(10);
        health.checkLimits();
        Assertions.assertEquals(3,health.getCurrentHealth());

        health.setCurrentHealth(-2);
        health.checkLimits();
        Assertions.assertEquals(0,health.getCurrentHealth());
    }
}