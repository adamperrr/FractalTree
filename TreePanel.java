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
			g.drawLine((int)A.getX()+this.getWidth()/2, this.getHeight()-(int)A.getY(),
					(int)B.getX()+this.getWidth()/2, this.getHeight()-(int)B.getY());
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
			int xB = (int) line.getB().getX();
			int yB = (int) line.getB().getY();

			Line left = line.clone();
			left.rotate(+angle_deg);
			left.changeLinesLength(ratio);
			left.moveOnXAxis((int)xB - (int)left.getA().getX());
			left.moveOnYAxis((int)yB - (int)left.getA().getY());
			createTree(left, ratio, angle_deg, levels - 1);

			Line right = line.clone();
			right.rotate(-angle_deg);
			right.changeLinesLength(ratio);
			right.moveOnXAxis((int)xB - (int)right.getA().getX());
			right.moveOnYAxis((int)yB - (int)right.getA().getY());
			createTree(right, ratio, angle_deg, levels - 1);
		}
	}

	private LinkedList<Line> lines = new LinkedList<Line>();
	
	private double ratio = 0.75;
	private int angleDeg = 30;
	private int levels = 5;
}
