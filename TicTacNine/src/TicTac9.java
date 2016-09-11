import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class TicTac9 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Tic-Tac-Nine";
	private static final int HEIGHT = 1000;
	private static final int WIDTH = 1000;
	public static boolean gameover = false;
	static JFrame frame;
	static boolean oWon = true;
	JPanel tGUI;
	static ArrayList<JButton> jbu;
	JButton exit;
	JButton restart;
	ExitA exitA;
	RestartA restartA;
	static ImageIcon o = new ImageIcon("O.png");
	static ImageIcon x = new ImageIcon("X.png");
	static ImageIcon d = new ImageIcon("Idefault.png");
	static ImageIcon owin = new ImageIcon("Owin.jpg");
	static ImageIcon xwin = new ImageIcon("Xwin.jpg");
	static ImageIcon tie = new ImageIcon("Tie.jpg");
	static ImageIcon rest = new ImageIcon("restart.png");
	static ImageIcon ex = new ImageIcon("exit.png");

	public JPanel createContent() {

		tGUI = new JPanel();
		tGUI.setBackground(Color.blue);
		tGUI.setForeground(Color.blue);
		tGUI.setLayout(new GridLayout(3, 3));
		tGUI.setName(TITLE);
		tGUI.setBounds(0, 0, WIDTH, HEIGHT);
		jbu = new ArrayList<JButton>();
		for (int i = 0; i < 9; i++) {
			JButton j = new JButton();
			j.addActionListener(this);
			j.setIcon(d);
			j.setDisabledIcon(d);
			tGUI.add(j);
			jbu.add(i, j);
		}
		tGUI.setOpaque(true);
		return tGUI;
	}

	public JPanel createEnd() {
		this.exitA = new ExitA();
		this.restartA = new RestartA();
		tGUI = new JPanel();
		tGUI.setBackground(Color.yellow);
		tGUI.setLayout(new GridLayout(1, 2));
		tGUI.setName(TITLE);
		tGUI.setBounds(0, 0, WIDTH, HEIGHT);
		exit = new JButton();
		exit.addActionListener(exitA);
		exit.setIcon(ex);
		restart = new JButton();
		restart.addActionListener(restartA);
		restart.setIcon(rest);
		tGUI.add(restart);
		tGUI.add(exit);
		tGUI.setOpaque(true);
		return tGUI;
	}

	public JPanel createGO() {
		tGUI = new JPanel();
		tGUI.setBackground(Color.yellow);
		tGUI.setLayout(new GridLayout(1, 2));
		tGUI.setName(TITLE);
		tGUI.setBounds(0, 0, WIDTH, HEIGHT);
		JLabel winner = new JLabel(tie, SwingConstants.CENTER);
		if (oWon) {
			winner.setIcon(owin);
		} else {
			winner.setIcon(xwin);
		}
		tGUI.add(winner);
		tGUI.setOpaque(true);
		return tGUI;
	}

	public class ExitA implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public class RestartA implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < frame.getFrames().length; i++) {
				frame.getFrames()[i].dispose();
				gameover = false;
			}
			createAndShowGUI();
			createAndShowEnd();
		}
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == jbu.get(i)) {
				MiniTT9.createAndShowGUI();
				MiniTT9.source = i;
			}
		}
	}

	public static void winCon() {
		if (jbu.get(0).getIcon().equals(o) && jbu.get(1).getIcon().equals(o) && jbu.get(2).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(0).getIcon().equals(x) && jbu.get(1).getIcon().equals(x) && jbu.get(2).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(3).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(5).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(3).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(5).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(6).getIcon().equals(o) && jbu.get(7).getIcon().equals(o) && jbu.get(8).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(6).getIcon().equals(x) && jbu.get(7).getIcon().equals(x) && jbu.get(8).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(0).getIcon().equals(o) && jbu.get(3).getIcon().equals(o) && jbu.get(6).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(0).getIcon().equals(x) && jbu.get(3).getIcon().equals(x) && jbu.get(6).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(1).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(7).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(1).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(7).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(2).getIcon().equals(o) && jbu.get(5).getIcon().equals(o) && jbu.get(8).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(2).getIcon().equals(x) && jbu.get(5).getIcon().equals(x) && jbu.get(8).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(0).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(8).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(0).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(8).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		if (jbu.get(2).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(6).getIcon().equals(o)) {
			gameover = true;
			return;
		}

		if (jbu.get(2).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(6).getIcon().equals(x)) {
			gameover = true;
			return;
		}

		else if (!jbu.get(0).getIcon().equals(d) && !jbu.get(1).getIcon().equals(d) && !jbu.get(2).getIcon().equals(d)
				&& !jbu.get(3).getIcon().equals(d) && !jbu.get(4).getIcon().equals(d) && !jbu.get(5).getIcon().equals(d)
				&& !jbu.get(6).getIcon().equals(d) && !jbu.get(7).getIcon().equals(d)
				&& !jbu.get(8).getIcon().equals(d)) {
			gameover = true;
		}
	}

	public static void createAndShowEnd() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Restart or Exit");
		TicTac9 game = new TicTac9();
		frame.setContentPane(game.createEnd());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(270, 150);
		frame.setVisible(true);
		frame.setBounds(1000, 0, 270, 150);
	}

	public static void createAndShowGO() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Tic Tac 9");
		TicTac9 game = new TicTac9();
		frame.setContentPane(game.createGO());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}

	public static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Tic Tic Tac 9" + "                                  "
				+ "If this is a new game, X chooses the square. Otherwise, the player who lost the last square gets to choose.");
		TicTac9 game = new TicTac9();
		frame.setContentPane(game.createContent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		createAndShowGUI();
		createAndShowEnd();
	}
}