package FractalTree;

import java.util.*;

public class Line
{
    public Line(Point pointA, Point pointB)
    {
        pointA_ = new Point(pointA);
        pointB_ = new Point(pointB);
    }

    public Line(Line line)
    {
        pointA_ = new Point( line.getA() );
        pointB_ = new Point( line.getB() );
    }

    public double getLength()
    {
        double differenceX = pointB_.getX() - pointA_.getX();
        double differenceY = pointB_.getY() - pointA_.getY();

        return Math.sqrt( differenceX*differenceX + differenceY*differenceY );
    }

    public void rotate(double angle_deg)
    {
    	boolean rad = false;
    	rotate(angle_deg, rad);
    }
    
    public void rotate(double angle, boolean rad)
    {
        angle *= -1.0; // Negative angles on the right, positive on the left
        double angle_rad = 2.0 * Math.PI * angle / 360.0;

        if (rad == true)
        {
            angle_rad = angle;
        }

        assignPointBUsingAngle(angle_rad);
    }

    public void changeLinesLength(double ratio)
    {
        int Ax = pointA_.getX();
        int Ay = pointA_.getY();
        int Bx = pointB_.getX();
        int By = pointB_.getY();

        // Line's formula: y = a*x + b so:
        double a = (double)(Ay - By) / (double)(Ax - Bx);
        double b = Ay - a * Ax;
        double newLengthSq = ratio * ratio * this.getLength() * this.getLength();

        pointB_ = getBUsingLength(a, b, newLengthSq);
    }

    public void moveOnXAxis(int dx)
    {
        pointA_.moveOnXAxis(dx);
        pointB_.moveOnXAxis(dx);
    }

    public void moveOnYAxis(int dx)
    {
        pointA_.moveOnYAxis(dx);
        pointB_.moveOnYAxis(dx);
    }

    public Point getA()
    {
        return pointA_;
    }

    public Point getB()
    {
        return pointB_;
    }

    public String ToString()
    {
        return "A: (" + pointA_.ToString() + "), B: (" + pointB_.ToString() + ")";
    }

    private Point getBUsingLength(double a, double b, double newLengthSq)
    {
        int xA = pointA_.getX(), yA = pointA_.getY();
        int xB = pointB_.getX(), yB = pointB_.getY();

        Point result = null;
        if (xA == xB)
        {
            result = new Point(xB, (int)Math.sqrt(newLengthSq) + yA);
        }
        else
        {
            // Square equation coefficients:
            double coeffA = 1.0 + a * a;
            double coeffB = 2 * (a * (b - yA) - xA);
            double coeffC = xA * xA + (b - yA) * (b - yA) - newLengthSq;

            double delta = coeffB * coeffB - 4.0 * coeffA * coeffC;
            double sqrtDelta = Math.sqrt(delta);

            double newXB_1 = (-coeffB - sqrtDelta) / (2.0 * coeffA);
            double newXB_2 = (-coeffB + sqrtDelta) / (2.0 * coeffA);

            Point newB_1 = new Point((int)newXB_1, (int)(a * newXB_1 + b));
            Point newB_2 = new Point((int)newXB_2, (int)(a * newXB_2 + b));

            double lengthNew1 = (new Line(pointB_, newB_1)).getLength();
            double lengthNew2 = (new Line(pointB_, newB_2)).getLength();

            if(lengthNew1 < lengthNew2)
            {
                result = newB_1;
            }
            else
            {
                result = newB_2;
            }
        }

        return result;
    }

    private void assignPointBUsingAngle(double angle_rad)
    {
        double differenceX = (double)pointB_.getX() - (double)pointA_.getX();
        double differenceY = (double)pointB_.getY() - (double)pointA_.getY();

        double newBPointX = differenceX * Math.cos(angle_rad) + differenceY * Math.sin(angle_rad) + (double)pointA_.getX();
        double newBPointY = -differenceX * Math.sin(angle_rad) + differenceY * Math.cos(angle_rad) + (double)pointA_.getY();

        pointB_ = new Point((int)newBPointX, (int)newBPointY);
    }

    private Point pointA_ = null;
    private Point pointB_ = null;
}
