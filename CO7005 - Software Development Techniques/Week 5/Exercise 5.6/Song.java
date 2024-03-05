public class Song {
	private String title;
	private String artist;
	private int year;

	public Song(String _title, String _artist, int _year) {
		title = _title;
		artist = _artist;
		year = _year;
	}

	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public int getYear() {
		return year;
	}
}