public class ImageGamePiece extends GamePiece{
    private String picture;
    private double scaledHeight;
    private double scaledWidth;
    public ImageGamePiece(int centerX, int centerY, int height, int width, String colors) {
        super(centerX, centerY, height, width,new int[] {0,0,0});
        this.scaledHeight = 2*height;
        this.scaledWidth = 2*width;
        this.picture = colors;
    }

    public void drawPiece()
    {
        StdDraw.picture(super.returnX(), super.returnY(), picture, scaledWidth, scaledHeight);
    }
}
