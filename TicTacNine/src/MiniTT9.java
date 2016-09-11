import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class MiniTT9 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Mini Tic-Tac-Toe";
	private static final int HEIGHT = 1000;
	private static final int WIDTH = 1000;
	private static boolean xo = true;
	private boolean gameover = false;
	private static JFrame frame;
	static int source;

	JPanel tGUI;
	ArrayList<JButton> jbu;
	ImageIcon o = new ImageIcon("O.png");
	ImageIcon x = new ImageIcon("X.png");
	ImageIcon d = new ImageIcon("Idefault.png");

	public JPanel createContent() {
		tGUI = new JPanel();
		tGUI.setBackground(Color.orange);
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

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == jbu.get(i)) {
				if (xo) {
					jbu.get(i).setIcon(o);
					jbu.get(i).setDisabledIcon(o);
				} else {
					jbu.get(i).setIcon(x);
					jbu.get(i).setDisabledIcon(x);
				}
				if (xo)
					xo = false;
				else
					xo = true;
				jbu.get(i).setEnabled(false);
			}
		}
		winCon();
		if (gameover) {
			for (int i = 0; i < 9; i++) {
				jbu.get(i).setEnabled(false);
			}
			for (int i = 0; i < 9; i++) {
				if (TicTac9.jbu.get(i).getIcon().equals(TicTac9.d)) {
					TicTac9.jbu.get(i).setEnabled(true);
				}
			}
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int j = 0; j < 9; j++) {
					TicTac9.jbu.get(j).setEnabled(false);
				}
			}
		}
	}

	private void winCon() {

		if (jbu.get(0).getIcon().equals(o) && jbu.get(1).getIcon().equals(o) && jbu.get(2).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(0).getIcon().equals(x) && jbu.get(1).getIcon().equals(x) && jbu.get(2).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;

		}

		if (jbu.get(3).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(5).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(3).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(5).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(6).getIcon().equals(o) && jbu.get(7).getIcon().equals(o) && jbu.get(8).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(6).getIcon().equals(x) && jbu.get(7).getIcon().equals(x) && jbu.get(8).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(0).getIcon().equals(o) && jbu.get(3).getIcon().equals(o) && jbu.get(6).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(0).getIcon().equals(x) && jbu.get(3).getIcon().equals(x) && jbu.get(6).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(1).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(7).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(1).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(7).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(2).getIcon().equals(o) && jbu.get(5).getIcon().equals(o) && jbu.get(8).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(2).getIcon().equals(x) && jbu.get(5).getIcon().equals(x) && jbu.get(8).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(0).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(8).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(0).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(8).getIcon().equals(x)) {

			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(2).getIcon().equals(o) && jbu.get(4).getIcon().equals(o) && jbu.get(6).getIcon().equals(o)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.oWon = true;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		if (jbu.get(2).getIcon().equals(x) && jbu.get(4).getIcon().equals(x) && jbu.get(6).getIcon().equals(x)) {
			gameover = true;
			frame.dispose();
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.oWon = false;
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
				TicTac9.createAndShowEnd();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}

		else if (!jbu.get(0).getIcon().equals(d) && !jbu.get(1).getIcon().equals(d) && !jbu.get(2).getIcon().equals(d)
				&& !jbu.get(3).getIcon().equals(d) && !jbu.get(4).getIcon().equals(d) && !jbu.get(5).getIcon().equals(d)
				&& !jbu.get(6).getIcon().equals(d) && !jbu.get(7).getIcon().equals(d)
				&& !jbu.get(8).getIcon().equals(d)) {
			gameover = true;
			frame.dispose();
			tieMethod();
			TicTac9.createAndShowEnd();
		}
	}

	public static void tieMethod() {
		Random rand = new Random();
		int randomNum = rand.nextInt((1 - 0) + 1);
		if (randomNum == 0) {
			TicTac9.oWon = true;
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.o);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.o);
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		} else {
			TicTac9.oWon = false;
			TicTac9.jbu.get(MiniTT9.source).setIcon(TicTac9.x);
			TicTac9.jbu.get(MiniTT9.source).setDisabledIcon(TicTac9.x);
			TicTac9.winCon();
			if (TicTac9.gameover) {
				for (int i = 0; i < 9; i++) {
					TicTac9.jbu.get(i).setEnabled(false);
				}
				TicTac9.frame.dispose();
				TicTac9.createAndShowGO();
			}
			TicTac9.jbu.get(MiniTT9.source).setEnabled(false);
			return;
		}
	}

	public static void createAndShowGUI() {
		if (TicTac9.oWon) {
			xo = false;
		}
		for (int i = 0; i < 9; i++) {
			TicTac9.jbu.get(i).setEnabled(false);
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		String str = "O goes first";
		if (TicTac9.oWon)
			str = "X goes first";
		frame = new JFrame("Mini Tic Tac 9"
				+ "                                                                                                                          "
				+ str);
		MiniTT9 game = new MiniTT9();
		frame.setContentPane(game.createContent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}
}