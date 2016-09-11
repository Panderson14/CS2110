/*
 * @author Patrick Anderson psa5dg
 * Homework 2
 * Lab 102
*/

public class Song implements Comparable<Song>, Playable {

	private String artist;
	private String title;
	private int minutes;
	private int seconds;
	
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}
	
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds % 60;
		this.minutes += seconds / 60;
	}
	
	public Song(Song s) {
		this.artist = s.getArtist();
		this.title = s.getTitle();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds % 60;
		this.minutes += seconds / 60;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song a = (Song) o;
			if (this.artist.equals(a.getArtist()) &&
				this.title.equals(a.getTitle()) &&
				this.minutes == a.getMinutes() &&
				this.seconds == a.getSeconds()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "{Song: title=" + title + " artist=" + artist + " minutes=" + minutes + " seconds=" + seconds + "}";
	}
	
	/**
	 * Use this code for play EXACTLY
	 */
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}
	
	@Override
	public int compareTo(Song o) {
		if (this.artist.equals(o.getArtist())) {
			return this.title.compareTo(o.getTitle());
		}
		return this.artist.compareTo(o.getArtist());
	}

	@Override
	public String getName() {
		return this.title;
	}

	@Override
	public int getPlayTimeSeconds() {
		return this.seconds + this.minutes * 60;
	}
}
