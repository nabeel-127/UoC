class LyricsThread
	{
	public static void main(String args[]) throws InterruptedException {
		Thread lyrics1 = new Thread(new Lyrics1());
		Thread lyrics2 = new Thread(new Lyrics2());
		lyrics1.start();
		lyrics1.join();
		System.out.println();
		lyrics2.start();
		lyrics2.join();
	}
	private static class Lyrics1 implements Runnable {
		public void run() {
			try {
				System.out.println("Daisy, Daisy");
				Thread.sleep(1000);
				System.out.println("Give me your answer do");
				Thread.sleep(1000);
				System.out.println("I'm half crazy");
				Thread.sleep(1000);
				System.out.println("All for the love of you");
				Thread.sleep(1000);
				System.out.println("It won't be a stylish marriage");
				Thread.sleep(1000);
				System.out.println("I can't afford a carriage");
				Thread.sleep(1000);
				System.out.println("But you'll look sweet on the seat");
				Thread.sleep(1000);
				System.out.println("Of a bicycle built for two");
			} catch (InterruptedException e) {
				System.out.println("Lyrics1 error: " + e);
			}
		}
	}
	private static class Lyrics2 implements Runnable {
		public void run() {
			try {
			System.out.println("Twinkle, twinkle, little star");
				Thread.sleep(1000);
			System.out.println("How I wonder what you are");
				Thread.sleep(1000);
			System.out.println("Up above the world so high");
				Thread.sleep(1000);
			System.out.println("Like a diamond in the sky");
				Thread.sleep(1000);
			System.out.println("When the blazing sun is gone");
				Thread.sleep(1000);
			System.out.println("When he nothing shines upon");
				Thread.sleep(1000);
			System.out.println("Then you show your little light");
				Thread.sleep(1000);
			System.out.println("Twinkle, twinkle, all the night");
			} catch (InterruptedException e) {
				System.out.println("Lyrics2 error: " + e);
			}
		}
	}
}