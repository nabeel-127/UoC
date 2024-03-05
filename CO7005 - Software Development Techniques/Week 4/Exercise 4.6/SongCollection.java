import java.util.Scanner;

public class SongCollection {
	public static void main(String[] args) {
		String title, artist;
		int year;

		Scanner input = new Scanner(System.in);
		
		Song[] mySong = new Song[5];
		for (int i = 0; i < mySong.length; i++) {
			System.out.print("Enter title: ");
			title = input.nextLine();
			System.out.print("Enter artist: ");
			artist = input.nextLine();
			System.out.print("Enter year: ");
			year = input.nextInt();
			input.nextLine();
			mySong[i] = new Song(title, artist, year);
		}
		input.close();
		System.out.println();
		for (int i = 0; i < mySong.length; i++) {
			System.out.println("Title: " + mySong[i].getTitle());
			System.out.println("Artist: " + mySong[i].getArtist());
			System.out.println("Year: " + mySong[i].getYear());
		}
	}
}