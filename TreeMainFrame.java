package FractalTree;

import javax.swing.*;

public class TreeMainFrame extends JFrame
{

	public TreeMainFrame()
	{
		initComponents();
	}

	public TreeMainFrame(String title)
	{
		this.setTitle(title);
		initComponents();
	}	
	
	private void sliderRatioStateChanged(javax.swing.event.ChangeEvent evt)
	{
		int ratioPercent = sliderRatio.getValue();
		ratioValueLabel.setText(ratioPercent + "%");

		JSlider source = (JSlider) evt.getSource();
		if (!source.getValueIsAdjusting())
		{
			treePanel.setRatio(ratioPercent);
			treePanel.startTreeCreation();
			treePanel.repaint();
		}
	}

	private void sliderAngleDegStateChanged(javax.swing.event.ChangeEvent evt)
	{
		int angleDeg = sliderAngleDeg.getValue();
		angleValueLabel.setText(angleDeg + "deg");

		JSlider source = (JSlider) evt.getSource();
		if (!source.getValueIsAdjusting())
		{
			treePanel.setAngle(angleDeg);
			treePanel.startTreeCreation();
			treePanel.repaint();
		}
	}

	private void sliderLevelsStateChanged(javax.swing.event.ChangeEvent evt)
	{
		int levelsNum = sliderLevels.getValue();
		levelsValueLabel.setText(Integer.toString(levelsNum));

		JSlider source = (JSlider) evt.getSource();
		if (!source.getValueIsAdjusting())
		{
			treePanel.setLevels(levelsNum);
			treePanel.startTreeCreation();
			treePanel.repaint();
		}
	}

	public static void main(String args[])
	{
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(TreeMainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(TreeMainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(TreeMainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(TreeMainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new TreeMainFrame("Fractal Tree").setVisible(true);
			}
		});
	}

	private void initComponents()
	{

		sliderRatio = new javax.swing.JSlider();
		sliderAngleDeg = new javax.swing.JSlider();
		sliderLevels = new javax.swing.JSlider();
		ratioNameLabel = new javax.swing.JLabel();
		treePanel = new TreePanel();
		angleNameLabel = new javax.swing.JLabel();
		levelsNameLabel = new javax.swing.JLabel();
		ratioValueLabel = new javax.swing.JLabel();
		angleValueLabel = new javax.swing.JLabel();
		levelsValueLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(500, 600));
		setSize(new java.awt.Dimension(500, 600));

		sliderRatio.setMaximum(200);
		sliderRatio.setMinorTickSpacing(1);
		sliderRatio.setValue(75);
		sliderRatio.addChangeListener(new javax.swing.event.ChangeListener()
		{
			public void stateChanged(javax.swing.event.ChangeEvent evt)
			{
				sliderRatioStateChanged(evt);
			}
		});

		sliderAngleDeg.setMaximum(180);
		sliderAngleDeg.setMinimum(-180);
		sliderAngleDeg.setValue(30);
		sliderAngleDeg.addChangeListener(new javax.swing.event.ChangeListener()
		{
			public void stateChanged(javax.swing.event.ChangeEvent evt)
			{
				sliderAngleDegStateChanged(evt);
			}
		});

		sliderLevels.setMaximum(30);
		sliderLevels.setValue(5);
		sliderLevels.addChangeListener(new javax.swing.event.ChangeListener()
		{
			public void stateChanged(javax.swing.event.ChangeEvent evt)
			{
				sliderLevelsStateChanged(evt);
			}
		});

		ratioNameLabel.setText("Ratio");
		ratioNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		treePanel.setBackground(new java.awt.Color(255, 0, 0));

		javax.swing.GroupLayout treePanelLayout = new javax.swing.GroupLayout(
				treePanel);
		treePanel.setLayout(treePanelLayout);
		treePanelLayout.setHorizontalGroup(treePanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		treePanelLayout.setVerticalGroup(treePanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 207,
				Short.MAX_VALUE));

		angleNameLabel.setText("Angle:");

		levelsNameLabel.setText("Levels:");

		ratioValueLabel.setText("75%");

		angleValueLabel.setText("30deg");

		levelsValueLabel.setText("5");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(sliderRatio,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(sliderAngleDeg,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(sliderLevels,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(treePanel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												angleNameLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												angleValueLabel))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												levelsNameLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												levelsValueLabel))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												ratioNameLabel,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												41,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												ratioValueLabel)))
																		.addGap(0, 0, Short.MAX_VALUE)))
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(ratioNameLabel,
														javax.swing.GroupLayout.PREFERRED_SIZE, 18,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(ratioValueLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sliderRatio,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(angleNameLabel)
												.addComponent(angleValueLabel))
								.addGap(1, 1, 1)
								.addComponent(sliderAngleDeg,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(levelsNameLabel)
												.addComponent(levelsValueLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sliderLevels,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(treePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		pack();
	}

	private JLabel angleNameLabel;
	private JLabel angleValueLabel;
	private JLabel levelsNameLabel;
	private JLabel levelsValueLabel;
	private JLabel ratioNameLabel;
	private JLabel ratioValueLabel;
	private JSlider sliderAngleDeg;
	private JSlider sliderLevels;
	private JSlider sliderRatio;
	private TreePanel treePanel;
}
