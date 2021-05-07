import java.io.IOException;

public interface GUI {
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    MOVEMENT getNextMovement() throws IOException;
    void drawText(Position position, String text, String color);


    enum MOVEMENT{ UP, DOWN, DOUBLEUP, QUIT, NONE}
}
