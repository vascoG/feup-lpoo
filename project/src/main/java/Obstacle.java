public abstract class Obstacle extends MobileObject{
    public Obstacle(Position pos) {
        super(pos);
    }
    abstract void hit(Cowboy cowboy);
}
