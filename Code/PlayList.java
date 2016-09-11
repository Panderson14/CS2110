/*
 * @author Patrick Anderson psa5dg
 * Homework
 * Lab 102
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayList {

	private String name;
	private ArrayList<Song> songList;
	
	public PlayList() {
		this.name = "Untitled";
		this.songList = new ArrayList<Song>();
	}
	
	public PlayList(String newName) {
		this.name = newName;
		this.songList = new ArrayList<Song>();
	}	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}
	
	/**
	 * loads songs from file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public boolean loadSongs(String fileName) throws Exception {
		File myFile = new File(fileName);
		Scanner inputFile = new Scanner(myFile);
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
				this.songList.add(s);
				i = -1;
			}
			i++;
		}
		
		inputFile.close();
		return true;
	}
	
	/**
	 * removes all songs
	 * @return
	 */
	public boolean clear() {
		if (this.songList.size() == 0) {
			return false;
		}
		this.songList.clear();
		return true;
	}
	
	/**
	 * adds Song s to the end of the play list
	 * @param s
	 * @return
	 */
	public boolean addSong(Song s) {
		this.songList.add(s);
		return true;
	}
	
	/**
	 * removes Song at index from the list and returns it
	 * @param index
	 * @return
	 */
	public Song removeSong(int index) {
		if (index >= this.songList.size() || index < 0) {
			return null;
		}
		Song s = this.songList.get(index);
		this.songList.remove(index);
		return s;
	}
	
	/**
	 * removes every occurrence of Song s from the list and returns s
	 * @param s
	 * @return
	 */
	public Song removeSong(Song s) {
		if (!this.songList.contains(s)) {
			return null;
		}
		for (int i = 0; i < this.songList.size(); i++) {
			this.songList.remove(s);
		}
		return s;
	}
	
	/**
	 * returns the song at the appropriate index
	 * @param index
	 * @return
	 */
	public Song getSong(int index) {
		if (index >= this.songList.size() || index < 0) {
			return null;
		}
		return this.songList.get(index);
	}
	
	/**
	 * plays the play list by calling play() on each Song in the play list in order
	 */
	public void play() {
		for (int i = 0; i < this.songList.size(); i++) {
			this.songList.get(i).play();
		}
	}
	
	/**
	 * returns the number of songs in the play list
	 * @return
	 */
	public int size() {
		return this.songList.size();
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.songList.size(); i++) {
			s += this.songList.get(i).getTitle() + " by " + this.songList.get(i).getArtist() + ": " + this.songList.get(i).getMinutes() + ":" + this.songList.get(i).getSeconds() + "\n";
		}
		return "Playlist: " + this.name + "\n" + s;
	}
}
