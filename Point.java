package FractalTree;

public class Point
{
    public Point(int x, int y)
    {
        x_ = x;
        y_ = y;
    }

    public Point(Point point)
    {
        x_ = point.getX();
        y_ = point.getY();
    }

    public void moveOnXAxis(int dx)
    {
        x_ = x_ + dx;
    }

    public void moveOnYAxis(int dy)
    {
        y_ = y_ + dy;
    }

    public int getX()
    {
        return x_;
    }

    public int getY()
    {
        return y_;
    }

    public String ToString()
    {
        return " X:" + Integer.toString(x_) + " Y:" + Integer.toString(y_);
    }

    private int x_ = 0;
    private int y_ = 0;
}
