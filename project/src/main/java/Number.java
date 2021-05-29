import java.io.IOException;

public class Number extends FixedObject{
    private int n;

    Number(Position pos ,int n) throws IOException {

        super(pos);

        this.n = n;

        colour = "#000000";

    }


    public void draw(GUI gui,String background) throws IOException {
        //draws from bottom to top


        for(int line = sprite.size()-1; line >= 0; line--) {
            for(int col = 0; col < sprite.get(line).size(); col++) {
                Character ch = sprite.get(line).get(col);
                if(ch == '?') {
                    continue;
                }
                gui.drawText(new Position(pos.getX()+col, pos.getY()-(sprite.size()-line)), String.valueOf(ch), colour,background);
            }
        }
    }



    public void setN(int n) throws IOException {
        this.n = n;

        switch (n)
        {
            case 1:
                readSpriteFromFile("numbers/1.txt");
                break;
            case 2:
                readSpriteFromFile("numbers/2.txt");
                break;
            case 3:
                readSpriteFromFile("numbers/3.txt");
                break;
            case 4:
                readSpriteFromFile("numbers/4.txt");
                break;
            case 5:
                readSpriteFromFile("numbers/5.txt");
                break;
            case 6:
                readSpriteFromFile("numbers/6.txt");
                break;
            case 7:
                readSpriteFromFile("numbers/7.txt");
                break;
            case 8:
                readSpriteFromFile("numbers/8.txt");
                break;
            case 9:
                readSpriteFromFile("numbers/9.txt");
                break;
            case 0:
                readSpriteFromFile("numbers/0.txt");
                break;
        }
    }
}
