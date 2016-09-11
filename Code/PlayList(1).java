/*
 * @author Patrick Anderson psa5dg
 * Homework 2
 * Lab 102
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PlayList implements Playable {

	private String name;
	private ArrayList<Playable> playableList;
	
	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}
	
	public PlayList(String newName) {
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
	}	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}
	
	/**
	 * loads songs from file
	 */
	public boolean loadSongs(String fileName)  {
		File myFile = new File(fileName);
		Scanner inputFile;
		try {
			inputFile = new Scanner(myFile);
			String title = "";
			String artist = "";
			int minutes = 0;
			int seconds = 0;
			
			int i = 0;
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				if (i != 3) {
					for (int j = 0; j < line.length(); j++) {
						if (line.charAt(0) != ' ') {
							break;
						}
						if ((line.charAt(j) == ' ') && (line.charAt(j + 1) != ' ')) {
							line = line.substring(j + 1);
							break;
						}
					}
					for (int k = line.length() - 1; k >= 0; k--) {
						if (line.charAt(line.length() - 1) != ' ') {
							break;
						}
						if ((line.charAt(k) == ' ') && (line.charAt(k - 1) != ' ')) {
							line = line.substring(0, k);
							break;
						}
					}
					if (i == 0) {
						title = line;
					}
					if (i == 1) {
						artist = line;
					}
					if (i == 2) {
						String[] ints = line.split(":");
						minutes = Integer.parseInt(ints[0]);
						seconds = Integer.parseInt(ints[1]) % 60;
						minutes += Integer.parseInt(ints[1]) / 60;
					}
				}
				if (i == 3) {
					Song s = new Song(artist, title, minutes, seconds);
					this.playableList.add(s);
					i = -1;
				}
				i++;
			}
			
			inputFile.close();
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * removes all songs
	 */
	public boolean clear() {
		if (this.playableList.size() == 0) {
			return false;
		}
		this.playableList.clear();
		return true;
	}
	
	/**
	 * adds Song s to the end of the play list
	 */
	public boolean addSong(Song s) {
		this.playableList.add(s);
		return true;
	}
		
	/**
	 * returns the song at the appropriate index
	 */
	public Playable getPlayable(int index) {
		if (index >= this.playableList.size() || index < 0) {
			return null;
		}
		return this.playableList.get(index);
	}
	
	/**
	 * plays the play list by calling play() on each Song in the play list in order
	 */
	public void play() {
		for (int i = 0; i < this.playableList.size(); i++) {
			this.playableList.get(i).play();
		}
	}
	
	/**
	 * returns the number of songs in the play list
	 */
	public int size() {
		return this.playableList.size();
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.playableList.size(); i++) {
			s += this.playableList.get(i).toString();
		}
		return "Playlist: " + this.name + "\n" + s;
	}
	
	/**
	 * Recursive method used to get total seconds of all songs within all playlists
	 */
	public int getRealPlayTimeSeconds(ArrayList<Playable> p) {
		int r = 0;
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i) instanceof Song) {
				r += p.get(i).getPlayTimeSeconds();
			}
			else if (p.get(i) instanceof PlayList) {
				ArrayList<Playable> w = ((PlayList) p.get(i)).getPlayableList();
				r += getRealPlayTimeSeconds(w);
			}
		}
		return r;
	}

	/**
	 * Calls recursive method
	 */
	public int getPlayTimeSeconds() {	
		return getRealPlayTimeSeconds(this.playableList);
	}
	
	/**
	 * Adds a playlist to this playableList
	 */
	public boolean addPlayList(PlayList pl) {
		if (this.playableList.contains(pl)) return false;
		return this.playableList.add(pl);
	}
	
	/**
	 * Sorts by the name.
	 */
	public void sortByName() {
		Collections.sort(this.playableList, new SortByName());
	}
	
	/**
	 * Sorts by the total time in seconds.
	 */
	public void sortByTime() {
		Collections.sort(this.playableList, new SortByTime());
	}

	private class SortByName implements Comparator<Playable> {
		
		/**
		 * compares by name
		 */
		public int compare(Playable o1, Playable o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	private class SortByTime implements Comparator<Playable> {
		
		/**
		 * compares by play time seconds
		 */
		public int compare(Playable o1, Playable o2) {
			return o1.getPlayTimeSeconds() - o2.getPlayTimeSeconds();
		}
	}
}