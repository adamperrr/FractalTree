package FractalTree;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TreePanel extends JPanel
{
	public TreePanel()
	{
		this.addLines();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.RED);

		/*
		int width = this.getWidth();
		int height = this.getHeight();
		
		g.setColor(Color.BLACK);
		g.drawString(
				"width: " + Integer.toString(width) + " height: "
						+ Integer.toString(height), 25, 140);
*/
		g.setColor(Color.BLACK);
		for (Line line : lines)
		{
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
	}

	private void addLines()
	{
		int width = 300;
		int height = 300;
		
		Random rand = new Random();
		for (int i = 0; i < 50; i++)
		{
			Line line = new Line(
					rand.nextInt(width), 
					rand.nextInt(height),
					rand.nextInt(width), 
					rand.nextInt(height)
					);
			lines.add(line);
		}
	}

	private final LinkedList<Line> lines = new LinkedList<Line>();

	private class Line
	{
		public Line(int x1, int y1, int x2, int y2)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		private int x1;
		private int y1;
		private int x2;
		private int y2;
	}
}
