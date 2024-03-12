import java.util.*;
public class GameManager {
    private SpaceShip hero;
    private boolean runGame;
    private ArrayList<SpaceJunk> blox;

    public GameManager() {
        runGame = true;
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 500);
        StdDraw.setYscale(0, 500);
        String color = "Ship1.gif"; 
        this.hero = new SpaceShip(250, 250, 15, 15, color);
        this.blox = new ArrayList<SpaceJunk>();
        int y = 400;
        int x = 0;
        for (int i = 0; i < 3; i++){
            String temp1 = "SpaceJunk.gif";
            blox.add(new SpaceJunk(25+x,y,15,200,temp1));
            blox.add(new SpaceJunk(475+x,y,15,200,temp1));
            y += 200;
            x = (int)(Math.random()*300) - 150;
        }
    }

    public void run() {
        while (runGame) {
            StdDraw.clear();
            
            hero.keepTime();
            if(StdDraw.isMousePressed())
            {
                hero.powerJump(blox);
            }
            if(StdDraw.isKeyPressed(87))
            {
                hero.moveY(10);
            }
            if(StdDraw.isKeyPressed(65))
            {
                hero.moveX(-10);
            }
            if(StdDraw.isKeyPressed(68))
            {
                hero.moveX(10);
            }
            if(StdDraw.isKeyPressed(83))
            {
                hero.moveY(-10);
            }
            this.collision();
            this.drawGamePieces();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawGamePieces() {

        hero.drawPiece();
        for (int i = 0; blox.size()> i; i++){
            blox.get(i).drawPiece();
            blox.get(i).moveY(-8);
        }
        for(int i =0; i< blox.size(); i+=2){
            if (blox.get(i).returnY() < 0){
                int x = (int) (Math.random()*300) - 150;
                int y = (int) (Math.random()*200) + 500;
                blox.get(i).setY(y);
                blox.get(i+1).setY(y);
                blox.get(i).moveX(x);
                blox.get(i+1).moveX(x);
            }
        }
    }

    public void collision() {
        for(GamePiece object: this.blox) {
            if(this.hero.getLowerBound() < object.getUpperBound() && 
            this.hero.getUpperBound() > object.getLowerBound() &&
            this.hero.getLeftBound() < object.getRightBound() && this.hero.getRightBound() > object.getLeftBound()) {

                this.runGame = false;

            }
        }

    }
}

