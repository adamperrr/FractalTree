package FractalTree;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TreePanel extends JPanel
{
	public TreePanel()
	{
		startTreeCreation();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		g.setColor(Color.BLACK);
		for (Line line : lines)
		{
			Point A = line.getA();
			Point B = line.getB();
			g.drawLine(A.getX()+this.getWidth()/2, this.getHeight()-A.getY(),
					B.getX()+this.getWidth()/2, this.getHeight()-B.getY());
		}
	}

	public void startTreeCreation()
	{
		lines = new LinkedList<Line>();
		Line firstLine = new Line(new Point(0, 0), new Point(0, 100));
		this.createTree(firstLine, ratio, angleDeg, levels);
	}
	
	public void setRatio(int ratioPercent)
	{
		this.ratio = ratioPercent / 100.0;
	}

	public void setAngle(int angleDeg)
	{
		this.angleDeg = angleDeg;
	}

	public void setLevels(int levels)
	{
		this.levels = levels;
	}
	
	private void createTree(Line line, double ratio, int angle_deg, int levels)
	{
		lines.add(line);

		if (levels > 0)
		{
			int xB = line.getB().getX();
			int yB = line.getB().getY();

			Line left = new Line(line);
			left.rotate(+angle_deg);
			left.changeLinesLength(ratio);
			left.moveOnXAxis(xB-left.getA().getX());
			left.moveOnYAxis(yB-left.getA().getY());
			createTree(left, ratio, angle_deg, levels - 1);

			Line right = new Line(line);
			right.rotate(-angle_deg);
			right.changeLinesLength(ratio);
			right.moveOnXAxis(xB-right.getA().getX());
			right.moveOnYAxis(yB-right.getA().getY());
			createTree(right, ratio, angle_deg, levels - 1);
		}
	}

	private LinkedList<Line> lines = new LinkedList<Line>();
	
	private double ratio = 0.75;
	private int angleDeg = 30;
	private int levels = 5;
}
