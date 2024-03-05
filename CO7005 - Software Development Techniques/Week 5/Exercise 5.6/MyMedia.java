import java.util.Scanner;

public class MyMedia {
    public static void main(String[] args) {
		MediaLibrary myMedia = new MediaLibrary();
		Song[] mySongs = new Song[3];
		String title, artist;
		int year;
		Scanner input = new Scanner(System.in);
		for (Song song : mySongs) {
			System.out.print("Enter song title: ");
			title = input.nextLine();
			System.out.print("Enter song artist: ");
			artist = input.nextLine();
			System.out.print("Enter song year: ");
			year = input.nextInt();
			input.nextLine();
			song = new Song(title, artist, year);
			myMedia.addSong(song);
		}
		input.close();

		myMedia.displaySongs();
	}
}