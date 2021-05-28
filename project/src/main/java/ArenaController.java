import java.io.IOException;

public class ArenaController {
    private final Arena arena;
    private boolean jumping ;
    private boolean jumpingDown ;
    private boolean doubleJumping;

    public ArenaController(Arena arena) {
        this.arena = arena;
        jumping = false;
        doubleJumping = false;
        jumpingDown = false;
    }
    private void cowboyDown() {
        if(arena.getCowboy().getPos().getY()>arena.getCowboy().yInitial)
            arena.getCowboy().moveDown();
    }
    private void moveMobiles() {
        for(int i = 0; i < arena.getMobile().size(); i++) {
            MobileObject newM = arena.getMobile().get(i);
            newM.setPos(new Position(newM.getPos().getX()-1, newM.getPos().getY()));
            arena.getMobile().set(i, newM);
        }
    }

    public void switchTime() {
        if(arena.day())
            arena.setNight();
        else
            arena.setDay();
        arena.getSunmoon().switchState();
    }

    private void spawnObstacle() throws IOException {
        double gen = Math.random();
        double ext = Math.random();
        int pos = (int) (arena.getWidth()+Math.round(Math.random()*20));
        MobileObject mobileAdd;
        if(gen > 0.75) {
            if(ext > 0.8) {
                mobileAdd = new Robber(new Position(pos, arena.getHeight()-arena.getFloorH()));
            } else {
                mobileAdd = new Pickpocket(new Position(pos, arena.getHeight()-arena.getFloorH()));
            }
        } else {
            if(ext > 0.95) {
                mobileAdd = new Barrel(new Position(pos, arena.getHeight()-arena.getFloorH()));
            } else {
                mobileAdd = new Cactus(new Position(pos, arena.getHeight()-arena.getFloorH()));
            }
        }
        arena.getMobile().add(mobileAdd);
    }

    private void spawnBonus() throws IOException {
        double gen = Math.random();
        double ext = Math.random();
        int pos = (int) (arena.getWidth()+Math.round(Math.random()*10));
        int floater = (int) (Math.round(Math.random()*arena.getHeight()/3));
        MobileObject mobileAdd;
        if(gen > 0.4) {
            if(ext > 0.9) {
                mobileAdd = new Beer(new Position(pos, arena.getHeight()-arena.getFloorH()*2-floater));
            } else {
                mobileAdd = new Coin(new Position(pos, arena.getHeight()-arena.getFloorH()*2-floater));
            }
            arena.getMobile().add(mobileAdd);
        }
    }

    public void spawnObjects() throws IOException {
        spawnObstacle();
        spawnBonus();
    }

    public void cleanupObjs() {
        for(int i = 0; i < arena.getMobile().size(); i++) {
            if(arena.getMobile().get(i).getPos().getX() < -10) {
                arena.getMobile().remove(i);
                i--;
            }
        }
    }

    private void iterateCollisions() {
        for(int i = 0; i < arena.getMobile().size(); i++) {
            if(checkForHit(arena.getMobile().get(i))) {
                i--;
            }
        }
    }

    private boolean checkForHit(MobileObject mob) {
        if(collCheck(arena.getCowboy().getPos(), mob.getPos(), arena.getCowboy().getWidth()-1, mob.getWidth()-1, 'x')) {
            if(collCheck(arena.getCowboy().getPos(), mob.getPos(), arena.getCowboy().getHeight()+1, mob.getHeight()-1, 'y')) {
                mob.hit(arena.getCowboy());
                arena.getMobile().remove(mob);
                return true;
            }
        }
        return false;
    }

    private boolean collCheck(Position a, Position b, int whA, int whB, Character type) {
        if(type == 'x')
            return a.getX() + whA > b.getX() && a.getX() < b.getX() + whB;
        else if(type == 'y')
            return a.getY() - whA < b.getY() && a.getY() > b.getY() - whB;
        return false;
    }

    public void updateCowboy()
    {
        if (jumping) {
            arena.getCowboy().pos.y--;
            if (arena.getCowboy().yInitial - 15 >= arena.getCowboy().pos.y) {
                jumping = false;
                jumpingDown = true;
            }
        }
        else if (doubleJumping) {
            arena.getCowboy().pos.y--;
            if (arena.getCowboy().yInitial - 20 >= arena.getCowboy().pos.y) {
                doubleJumping = false;
                jumpingDown = true;
            }
        } else if (jumpingDown) {
            arena.getCowboy().pos.y++;
            if (arena.getCowboy().yInitial == arena.getCowboy().pos.y)
                jumpingDown = false;
        }
    }

    public void updateMobiles()
    {
        moveMobiles();
        iterateCollisions();
    }

    public boolean nextMove(GUI.MOVEMENT movement)
    {
        switch (movement) {
            case UP:
                if (!jumpingDown)
                    jumping = true;
                break;
            case DOWN:
                if(jumping || doubleJumping) {
                    jumping = false;
                    doubleJumping = false;
                    jumpingDown = true;
                }
                break;
            case DOUBLEUP:
                if (!jumpingDown)
                    doubleJumping = true;
                break;
            case QUIT:
                return false;
            case NONE:
                break;
        }
        return true;
    }
}
