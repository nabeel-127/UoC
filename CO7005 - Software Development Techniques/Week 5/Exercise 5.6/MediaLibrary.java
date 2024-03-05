import java.util.ArrayList;

public class MediaLibrary {
    ArrayList<Song> mediaLibrary = new ArrayList<Song>();

	void addSong(Song song) {
		mediaLibrary.add(song);
	}
	void displaySongs() {
		for (Song song : mediaLibrary) {
			System.out.println("Title: " + song.getTitle());
			System.out.println("Artist: " + song.getArtist());
			System.out.println("Year: " + song.getYear() + "\n");
		}
	}
}