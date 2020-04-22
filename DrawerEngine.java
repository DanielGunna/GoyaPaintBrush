

public interface DrawerEngine {

    public void drawLineWithDDA();

    public void drawLineWithBresenham();

    public void drawRectangle();

    public void drawOvalBresenham();

    public void translation();

    public void rotation(); 

    public void scale();

    public void reflection(); 

    public void extractRegionCohenSutherland();

    public void extractRegionLiangBarsky();

}