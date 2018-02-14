package FractalTree;

import java.util.*;

public class Line implements Cloneable
{
    public Line(java.awt.Point pointA, java.awt.Point pointB)
    {
        pointA_ = new java.awt.Point(pointA);
        pointB_ = new java.awt.Point(pointB);
    }

    public Line clone()
    {
      java.awt.Point pointA = new java.awt.Point( this.getA() );
      java.awt.Point pointB = new java.awt.Point( this.getB() );
    	return new Line(pointA, pointB);
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
        int Ax = (int) pointA_.getX();
        int Ay = (int) pointA_.getY();
        int Bx = (int) pointB_.getX();
        int By = (int) pointB_.getY();

        // Line's formula: y = a*x + b so:
        double a = (double)(Ay - By) / (double)(Ax - Bx);
        double b = Ay - a * Ax;
        double newLengthSq = ratio * ratio * this.getLength() * this.getLength();

        pointB_ = getBUsingLength(a, b, newLengthSq);
    }

    public void moveOnXAxis(int dx)
    {
        pointA_.translate(dx, 0);
        pointB_.translate(dx, 0);
    }

    public void moveOnYAxis(int dy)
    {
      pointA_.translate(0, dy);
      pointB_.translate(0, dy);
    }

    public java.awt.Point getA()
    {
        return pointA_;
    }

    public java.awt.Point getB()
    {
        return pointB_;
    }

    public String ToString()
    {
        return "A: (" + pointA_.toString() + "), B: (" + pointB_.toString() + ")";
    }

    private java.awt.Point getBUsingLength(double a, double b, double newLengthSq)
    {
        int xA = (int) pointA_.getX();
        int yA = (int) pointA_.getY();
        int xB = (int) pointB_.getX();
        int yB = (int) pointB_.getY();

        java.awt.Point result = null;
        if (xA == xB)
        {
            result = new java.awt.Point(xB, (int)Math.sqrt(newLengthSq) + yA);
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

            java.awt.Point newB_1 = new java.awt.Point((int)newXB_1, (int)(a * newXB_1 + b));
            java.awt.Point newB_2 = new java.awt.Point((int)newXB_2, (int)(a * newXB_2 + b));

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

        pointB_ = new java.awt.Point((int)newBPointX, (int)newBPointY);
    }

    private java.awt.Point pointA_ = null;
    private java.awt.Point pointB_ = null;
}
