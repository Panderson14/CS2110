/*
 * @author Patrick Anderson psa5dg
 * Homework
 * Lab 102
*/

public class Song {

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
		return "{Song: title=" + title + " artist=" + artist + "}";
	}
	
	/**
	 * Use this code for play EXACTLY
	 */
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}
	
	public static void main(String[] args) throws Exception {
		Song s = new Song("hi", "patrick", 2, 60);
		System.out.println(s.minutes);
		System.out.println(s.seconds);
	}
}
