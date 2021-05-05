public  class Thief extends Obstacle{
    double toSteal;
    public Thief(Position pos) {
        super(pos);
    }
    void hit(Cowboy cowboy) {
        cowboy.setCoinsCollected((int) (cowboy.getCoinsCollected()-cowboy.getCoinsCollected()*toSteal));
    }
}
