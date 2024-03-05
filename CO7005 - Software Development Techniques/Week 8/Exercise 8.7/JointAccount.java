import java.util.concurrent.Semaphore;

public class JointAccount {
	public static void main(String args[]) throws InterruptedException {
		Thread MyThread1 = new Thread(new Thread1());
		Thread MyThread2 = new Thread(new Thread2());
		MyThread1.start();
		MyThread2.start();
		MyThread1.join();
		MyThread2.join();
		System.out.println("Balance: " + balance);
	}
	private static float balance;
	private static final Semaphore semaphore = new Semaphore(1);
	public static synchronized void Deposit(float increment) {
		try {
			semaphore.acquire();
			balance += increment;
			semaphore.release();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	public static synchronized void Withdraw(float decrement) {
		try {
			semaphore.acquire();
			if (decrement <= balance)
				balance -= decrement;
			else
				System.out.println("Not enough balance...");
			semaphore.release();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	private static class Thread1 implements Runnable {
		public void run() {
			try {
				Deposit(10);
				Deposit(20);
				Deposit(30);
				Withdraw(5);
				Withdraw(5);
			} catch (Exception e) {
				System.out.println("Thread1 error: " + e);
			}
		}
	}
	private static class Thread2 implements Runnable {
		public void run() {
			try {
				Deposit(9);
				Deposit(18);
				Withdraw(1);
				Withdraw(11);
				Withdraw(21);
			} catch (Exception e) {
				System.out.println("Thread2 error: " + e);
			}
		}
	}
}