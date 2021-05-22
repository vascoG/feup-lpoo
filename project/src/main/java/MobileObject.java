public abstract class MobileObject extends Element{

    public MobileObject(Position pos) {
        super(pos);
    }
    abstract void hit(Cowboy cowboy);
}
