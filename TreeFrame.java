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
		frame.setSize(400, 250);
		frame.setVisible(true);

		frame.addComponentListener(this);
	}

	public void componentMoved(ComponentEvent e)
	{
		String text = " --- Moved";
		// JOptionPane.showMessageDialog(frame, text, "Question",
		// JOptionPane.WARNING_MESSAGE);
	}

	public void componentResized(ComponentEvent e)
	{
		String text = " --- Resized ";
		// JOptionPane.showMessageDialog(frame, text, "Question",
		// JOptionPane.WARNING_MESSAGE);
		tree.repaint();
	}

	public void componentShown(ComponentEvent e)
	{
		String text = " --- Shown";
		// JOptionPane.showMessageDialog(frame, text, "Question",
		// JOptionPane.WARNING_MESSAGE);
	}

	public void componentHidden(ComponentEvent e)
	{
		String text = " --- Hidden";
		// JOptionPane.showMessageDialog(frame, text, "Question",
		// JOptionPane.WARNING_MESSAGE);
	}
	
	private JFrame frame = null;
	private TreePanel tree = null;
}
