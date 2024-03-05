import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.*;

public class ThreadCount {
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();
		Thread oddThread = new Thread(new OddNumbers(sharedResource));
		Thread evenThread = new Thread(new EvenNumbers(sharedResource));
		evenThread.start();
		oddThread.start();
		try {
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class SharedResource {
	Lock lock = new ReentrantLock();
	private List<Integer> numbers = new LinkedList<>();
	SharedResource() {
		for (int i = 1; i <= 16; i++) {
			numbers.add(i);
		}
	}
	int getNext() {
		return numbers.isEmpty() ? -1 : numbers.get(0);
	}
	void processNumber() {
		if (!numbers.isEmpty()) {
			numbers.remove(0);
		}
	}
}
class OddNumbers implements Runnable {
	private SharedResource sharedResource;
	OddNumbers(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}
	public void run() {
		try {
			while (true) {
				int currentNumber = sharedResource.getNext();
				if (currentNumber == -1)
					break;
				if (currentNumber % 2 != 0) {
					sharedResource.lock.lock();
					System.out.println(currentNumber);
					sharedResource.processNumber();
					sharedResource.lock.unlock();
					Thread.sleep(10);
				}
			}
		} catch (Exception e) {
			System.out.println("OddNumbers error: " + e);
		}
	}
}
class EvenNumbers implements Runnable {
	private SharedResource sharedResource;
	EvenNumbers(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}
	public void run() {
		try {
			while (true) {
				int currentNumber = sharedResource.getNext();
				if (currentNumber == -1) {
					break;
				}
				if (currentNumber % 2 == 0) {
					sharedResource.lock.lock();
					System.out.println(currentNumber);
					sharedResource.processNumber();
					sharedResource.lock.unlock();
					Thread.sleep(10);
				}
			}
		} catch (Exception e) {
			System.out.println("EvenNumbers error: " + e);
		}
	}
}