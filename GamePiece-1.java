public class GamePiece {

    private int centerX, centerY, height, width;
    private int[] color;
    public GamePiece(int x, int y, int h, int w, int[] colors) {
        centerX = x;
        centerY = y;
        height = h;
        width = w;
        color = colors;
    }


    public int returnX() {
        return centerX;
    }

    public int returnY() {
        return centerY;
    }


    public void moveY(int n) {
        centerY += n;
    }

    public void moveX(int n) {
        centerX += n;
    }

    public void setY(int n) {
        centerY = n;
    }

    public void setX(int n) {
        centerX = n;
    }


    public void drawPiece() {
        StdDraw.setPenColor(color[0], color[1], color[2]);
        StdDraw.filledRectangle(centerX, centerY, width, height);
    }
    
    public int getUpperBound()
    {
        return centerY + height;
    }
    
    public int getLowerBound()
    {
        return centerY - height;
    }
    
    public int getRightBound()
    {
        return centerY + width;
    }
    public int getLeftBound()
    {
        return centerY - width;
    }
}
