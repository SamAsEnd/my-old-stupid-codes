/**
 ******************************************************************************
 * $Id: Program.java 23 2013-02-17 22:50:58Z mkwayisi $
 * ----------------------------------------------------------------------------
 * Authored by Michael Kwayisi. Copyright (c) 2009-2013. All rights reserved.
 * Please send your comments to mkwayisi@gmail.com | Web: michaelkwayisi.com
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * stringently met:
 *   1. Redistributions of source code must retain the above copyright notice,
 *      this list of conditions, and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions, and the following disclaimer in the
 *      documentation and/or other materials provided with the package.
 *   3. The end-user documentation included with the redistribution, if any,
 *      must include the following acknowledgment:
 *         "This product includes software developed by Michael Kwayisi"
 *      Alternately, this acknowledgment may appear in the software itself,
 *      if and wherever such third-party acknowledgments normally appear.
 *   4. Neither the name of the software nor the name of its author and/or
 *      contributors may be used to endorse or promote products derived from
 *      this software without specific prior written permission.
 ******************************************************************************
 */

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Program extends JFrame {
//=============================================================================
// [DATA] Static class instance data fields.
private static final int BUTTON_WIDTH = 50;
private static final int BUTTON_HEIGHT = 30;
private static final int HZ_MARGIN = 8;
private static final int VT_MARGIN = 8;
private static final int PAD_OFFSET_X = 15;
private static final int PAD_OFFSET_Y = 85;
private static final int PAD_GRID_ROW = 6;
private static final int PAD_GRID_COL = 10;
private static final Font GLOBAL_FONT = new Font("Lucida Sans Unicode", Font.PLAIN, 13);
private static final Font MENU_FONT = new Font("Verdana", Font.PLAIN, 13);
private static final Font SCREEN_FONT = new Font("Cambria Math", Font.PLAIN, 24);
private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);
private static final Color BG_GENERIC = new Color(217, 228, 241);
private static final Color BG_SCREEN = new Color(238, 242, 247);

private final JLabel[] scrLabels = new JLabel[3];
private final JButton[] buttons = new JButton[54];
private final Calculator calc = new Calculator();
private String numMode = null;
private String sysMode = null;

//=============================================================================
// [FUNC] Program's main entry point of execution.
public static void main(String[] args)
{
	new Program().launchFrame();
}

//=============================================================================
// [FUNC] Primary constructor for the program frame.
public Program() {
	this.setLayout(null);
	this.setResizable(false);
	this.setSize(608, 373);
	this.setTitle("EasyCalc 0.0.2 - Written by Michael Kwayisi");
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.drawVisualComponents();
	this.getContentPane().setBackground(BG_GENERIC);
}

//=============================================================================
// [FUNC] Draws the various visual components of the JFrame.
private void drawVisualComponents() {
	JMenuBar menuBar = new JMenuBar();
	JMenu[] menus = new JMenu[4];
	JMenuItem[] menuItems = null;
	JPanel scrPanel = new JPanel();
	JPanel hexPanel = new JPanel();
	ButtonGroup buttonGroup = null;
	JRadioButton[] radioButtons = new JRadioButton[4];
	String[] texts = {							Calculator.DGA, Calculator.MCX, Calculator.MRX, Calculator.MSX, Calculator.MPX, Calculator.MMX,
		Calculator.XXX, Calculator.NLG, Calculator.BR1, Calculator.BR2, Calculator.DGB, Calculator.BSP, Calculator.CEX, Calculator.CXX, Calculator.NEG, Calculator.SRT,
		Calculator.AVG, Calculator.SIN, Calculator.FCT, Calculator.SQR, Calculator.DGC, Calculator.DG7, Calculator.DG8, Calculator.DG9, Calculator.DIV, Calculator.PER,
		Calculator.SUM, Calculator.COS, Calculator.CRT, Calculator.CUB, Calculator.DGD, Calculator.DG4, Calculator.DG5, Calculator.DG6, Calculator.MUL, Calculator.REC,
		Calculator.LST, Calculator.TAN, Calculator.INT, Calculator.POW, Calculator.DGE, Calculator.DG1, Calculator.DG2, Calculator.DG3, Calculator.SUB, Calculator.EQU,
		Calculator.CLS, Calculator.LOG, Calculator.MOD, Calculator.PWT, Calculator.DGF, Calculator.DG0, Calculator.DOT, Calculator.ADD};
	
	this.setJMenuBar(menuBar);
	for (int i = 0; i < menus.length; i++) {
		menus[i] = new JMenu();
		menus[i].setFont(MENU_FONT);
		
		switch (i) {
			case 0:
				menus[i].setText("Mode");
				menuItems = new JMenuItem[2];
				buttonGroup = new ButtonGroup();
				for (int j = 0; j < 2; j++) {
					menuItems[j] = new JRadioButtonMenuItem(j == 0 ? Calculator.STD : Calculator.SCI);
					menuItems[j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setSysMode(e.getActionCommand());
						}
					});
					buttonGroup.add(menuItems[j]);
				}
				menuItems[0].setSelected(true);
				break;
			case 1:
				menus[i].setText("View");
				menuItems = new JMenuItem[1];
				menuItems[0] = new JCheckBoxMenuItem(Calculator.GRP);
				menuItems[0].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sendKey(e.getActionCommand());
					}
				});
				break;
			case 2:
				menus[i].setText("Action");
				menuItems = new JMenuItem[1];
				menuItems[0] = new JMenuItem("Copy to clipboard");
				menuItems[0].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
							new StringSelection(scrLabels[2].getText()), null);
					}
				});
				break;
			case 3:
				menus[i].setText("Help");
				menuItems = new JMenuItem[1];
				menuItems[0] = new JMenuItem("About...");
				menuItems[0].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null,
							"EasyCalc 0.0.2  \u2015  A Q&D NIIT Java Project (Calculator)\n" +
							"Copyright \u00a9 2012 Michael Kwayisi. All Rights Reserved.",
								"About EasyCalc...", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				break;
		}
		
		for (int j = 0; j < menuItems.length; j++) {
			menuItems[j].setFont(MENU_FONT);
			menus[i].add(menuItems[j]);
		}
		menuBar.add(menus[i]);
	}
	
	scrPanel.setBackground(BG_SCREEN);
	scrPanel.setBorder(new LineBorder(Color.GRAY, 1));
	scrPanel.setLayout(null);
	scrPanel.setLocation(PAD_OFFSET_X, PAD_OFFSET_X);
	scrPanel.setSize((BUTTON_WIDTH + HZ_MARGIN) * PAD_GRID_COL - HZ_MARGIN,
		PAD_OFFSET_Y - scrPanel.getY() - VT_MARGIN);
	
	for (int i = 0; i < scrLabels.length; i++) {
		scrLabels[i] = new JLabel();
		switch (i) {
			case 0:
				scrLabels[i].setBounds(HZ_MARGIN, VT_MARGIN + 2, 15, 15);
				scrLabels[i].setFont(new Font(GLOBAL_FONT.getName(), Font.PLAIN, 13));
				break;
			case 1:
				scrLabels[i].setLocation(scrLabels[i-1].getX() * 2 + scrLabels[i-1].getWidth(),
					scrLabels[i-1].getY());
				scrLabels[i].setSize(scrPanel.getWidth() - (scrLabels[i].getX() + HZ_MARGIN),
						scrLabels[i-1].getHeight());
				scrLabels[i].setFont(scrLabels[i-1].getFont());
				scrLabels[i].setHorizontalAlignment(SwingConstants.RIGHT);
				break;
			case 2:
				scrLabels[i].setBounds(scrLabels[i-2].getX(), 27,
					scrPanel.getWidth() - scrLabels[i-2].getX() * 2, 30);
				scrLabels[i].setFont(SCREEN_FONT);
				scrLabels[i].setHorizontalAlignment(SwingConstants.RIGHT);
				break;
		}
		
		scrPanel.add(scrLabels[i]);
	}
	
	hexPanel.setBackground(BG_GENERIC);
	hexPanel.setBorder(new LineBorder(Color.GRAY, 1));
	hexPanel.setLayout(null);
	hexPanel.setLocation(PAD_OFFSET_X, PAD_OFFSET_Y);
	hexPanel.setSize((BUTTON_WIDTH + HZ_MARGIN) * 4 - HZ_MARGIN, BUTTON_HEIGHT);
	
	buttonGroup = new ButtonGroup();
	for (int i = 0; i < radioButtons.length; i++) {
		radioButtons[i] = new JRadioButton(i == 0 ? Calculator.HEX :
			i == 1 ? Calculator.DEC : i == 2 ? Calculator.OCT : Calculator.BIN);
		radioButtons[i].setBackground(BG_GENERIC);
		radioButtons[i].setFocusPainted(false);
		radioButtons[i].setFont(new Font(GLOBAL_FONT.getName(),
			GLOBAL_FONT.getStyle(), GLOBAL_FONT.getSize() - 2));
		radioButtons[i].setMargin(NO_INSETS);
		radioButtons[i].setSize(hexPanel.getWidth() / 4 - 4, 20);
		radioButtons[i].setLocation(radioButtons[i].getWidth() * i + 9, 5);
		
		radioButtons[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumMode(e.getActionCommand());
				sendKey(e.getActionCommand());
			}
		});
		
		if (i == 1) radioButtons[i].setSelected(true);
		buttonGroup.add(radioButtons[i]);
		hexPanel.add(radioButtons[i]);
	}
	
	for (int i = 0, x = 4, y = 0; i < buttons.length; i++) {
		buttons[i] = new JButton(texts[i]);
		buttons[i].setFocusPainted(false);
		buttons[i].setFont(GLOBAL_FONT);
		buttons[i].setMargin(NO_INSETS);
		buttons[i].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		buttons[i].setLocation(PAD_OFFSET_X + (BUTTON_WIDTH + HZ_MARGIN) * x,
			PAD_OFFSET_Y + (BUTTON_HEIGHT + VT_MARGIN) * y);
		if (i > 0 && i < 6) buttons[i].setBackground(BG_GENERIC);
		
		if (texts[i] == Calculator.XXX || texts[i] == Calculator.PER) {
			buttons[i].setBackground(BG_GENERIC);
			buttons[i].setEnabled(false);
		} else if (texts[i] == Calculator.EQU) {
			buttons[i].setSize(BUTTON_WIDTH, BUTTON_HEIGHT * 2 + VT_MARGIN);
		} else if (texts[i] == Calculator.DG0) {
			buttons[i].setSize(BUTTON_WIDTH * 2 + HZ_MARGIN, BUTTON_HEIGHT);
			x++;
		}
		
		buttons[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendKey(e.getActionCommand());
			}
		});
		
		this.getContentPane().add(buttons[i]);
		if (++x >= PAD_GRID_COL) {
			x = 0; y++;
		}
	}
	
	this.getContentPane().add(scrPanel);
	this.getContentPane().add(hexPanel);
}

//=============================================================================
// [FUNC] Sends the passed key to the internal calculator object and further
// update the screen reflecting any changes.
 private void sendKey(String key) {
	calc.inputKey(key);
	if (key != Calculator.GRP) {
		scrLabels[0].setText(calc.hasMemValue() ? "M" : "");
		if (key != Calculator.MSX)
			scrLabels[1].setText(calc.getSecScreenText());
		buttons[6].setText(calc.getSetSize() + "");
	}
	scrLabels[2].setText(calc.getPrmScreenText());
}

//=============================================================================
// [FUNC] Sets the system mode i.e. either standard or scientific.
private void setSysMode(String mode) {
	boolean b = mode == Calculator.SCI;
	for (int i = 6; i < buttons.length; i += 10)
		for (int j = i > 6 ? i : 7; j < i + 4; j++)	// Exclude XXX
			buttons[j].setEnabled(b);
	sysMode = mode;
	sendKey(Calculator.CXX);
	sendKey(Calculator.CLS);
}

//=============================================================================
// [FUNC] Sets the number system to be used by the calculator engine. Also
// this function updates the click-ability of the buttons based on the number
// system. Therefore is the number system is BIN, buttons 3-9 are disabled.
private void setNumMode(String mode) {
	switch (mode) {
		case Calculator.HEX:
			setDecEnabled(true);
			setHexEnabled(true);
			break;
		case Calculator.DEC:
			setDecEnabled(true);
			setHexEnabled(false);
			break;
		case Calculator.OCT:
			setDecEnabled(true);
			setHexEnabled(false);
			for (int i : new int[]{22, 23})
				buttons[i].setEnabled(false);
			break;
		case Calculator.BIN:
			setDecEnabled(false);
			setHexEnabled(false);
			break;
	}
	buttons[52].setEnabled(mode == Calculator.DEC);
	numMode = mode;
	calc.inputKey(mode);
}

//=============================================================================
// [FUNC] Enables all decimal number system buttons.
private void setDecEnabled(boolean b) {
	int[] arr = {21, 22, 23, 31, 32, 33, 42, 43};
	for (int i : arr) buttons[i].setEnabled(b);
}

//=============================================================================
// [FUNC] Enables the hexadecimal number system *exclusive* buttons. i.e. A-F
private void setHexEnabled(boolean b) {
	for (int i = 0; i < buttons.length; i += 10)
		buttons[i].setEnabled(b);
}

//=============================================================================
// [FUNC] Makes this JFrame visible to the user.
public void launchFrame() {
	//this.pack();
	setSysMode(Calculator.STD);
	setNumMode(Calculator.DEC);
	this.setVisible(true);
}
}

