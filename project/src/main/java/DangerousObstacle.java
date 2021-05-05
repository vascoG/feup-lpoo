public class DangerousObstacle extends Obstacle{
    int toDamage;
    public DangerousObstacle(Position pos) {
        super(pos);
    }

    void hit(Cowboy cowboy) {
        cowboy.getHealth().setCurrentHealth(cowboy.getHealth().getCurrentHealth()-toDamage);
    }
}
