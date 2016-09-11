/*
 * @author Patrick Anderson psa5dg
 * Homework 2
 * Lab 102
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Mp3Player extends ArrayList<PlayList> {

	private static final long serialVersionUID = 1L;
	private PlayList p;
	private ArrayList<PlayList> a;
	
	public Mp3Player() {
		p = new PlayList("Main Playlist");
		a = new ArrayList<PlayList>();
		a.add(p);
	}
	
	@Override
	public boolean add(PlayList play) {
		if (a.contains(play.getName())) return false;
		return this.a.add(play);
	}
	
	public PlayList getDefaultPlayList() {
		return this.p;
	}
	
	public ArrayList<PlayList> getPlayLists() {
		return this.a;
	}
	
	/**
	 * starts the Mp3Player UI
	 */
	public void start() {
		System.out.println("Please enter the name of a file: ");
		Scanner keyboard = new Scanner(System.in);
		String s = keyboard.nextLine();
		p.loadSongs(s);
		System.out.println(p);
		keyboard.close();
	}
}
