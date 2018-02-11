package FractalTree;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeFrame implements ComponentListener
{
	public TreeFrame()
	{
		frame = new JFrame("Fractal Tree");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tree = new TreePanel();
		frame.add(tree);
		frame.setSize(700, 500);
		frame.setVisible(true);

		frame.addComponentListener(this);
	}

	public void componentMoved(ComponentEvent e){}
	public void componentResized(ComponentEvent e)
	{
		tree.repaint();
	}

	public void componentShown(ComponentEvent e){}
	public void componentHidden(ComponentEvent e){}
	
	private JFrame frame = null;
	private TreePanel tree = null;
}
