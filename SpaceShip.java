import java.util.*;
public class SpaceShip extends ImageGamePiece{
    private int timer;
    public SpaceShip(int centerX, int centerY, int height, int width, String colors){
        super(centerX, centerY, height, width, colors);
    }

    public void keepTime(){
        timer++;
    }

    public void powerJump(ArrayList<SpaceJunk> blox){
        if (timer >= 30){
            int x = (int)StdDraw.mouseX();
            int y = (int)StdDraw.mouseY();
            setX(x);
            setY(y);
            for (SpaceJunk object : blox){
                object.destroy(x,y);
            }
            timer=0;
        }
    }
    
}