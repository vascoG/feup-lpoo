public abstract class Collect extends MobileObject{
    public Collect(Position pos) {
        super(pos);
    }
    abstract void hit(Cowboy cowboy);
}
