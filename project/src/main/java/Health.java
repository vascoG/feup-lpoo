public class Health {
    private int currentHealth;
    private int maxHealth;

    public Health(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int health) {
        this.currentHealth = health;
        checkLimits();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        checkLimits();
    }

    public void checkLimits() {
        if(this.currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else if(this.currentHealth < 0) {
            this.currentHealth = 0;
        }
    }
}
