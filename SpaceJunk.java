public class SpaceJunk extends ImageGamePiece{
    private boolean isDestroyed;
    public SpaceJunk(int centerX, int centerY, int height, int width, String colors){
        super(centerX, centerY, height, width, colors);
        this.isDestroyed=false;
    }

    public boolean getIsDestroyed(){
        return isDestroyed;
    }

    public void drawPiece(){
        if (isDestroyed == false){
            super.drawPiece();
        }
    }

    public void destroy(int x ,int y){
        if (x <super.getRightBound()){
            if (x >super.getLeftBound()){
                if (y <super.getUpperBound()){
                    if (y >super.getLowerBound()){
                        isDestroyed = true;
                    }
                }
            }
        }
    }
}