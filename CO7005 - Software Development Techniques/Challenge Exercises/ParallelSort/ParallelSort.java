import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ParallelSort {
	public static void main(String[] args) {
		long startTime, endTime;
		ArrayList<Integer> myData = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			myData.add(random.nextInt(1000));
		}
		ArrayList<Integer> dataFull = new ArrayList<Integer>(myData);
		ArrayList<Integer> dataHalf1 = new ArrayList<Integer>(myData.subList(0, myData.size() / 2));
		ArrayList<Integer> dataHalf2= new ArrayList<Integer>(myData.subList(myData.size() / 2, myData.size()));
		Sort data = new Sort(dataFull);
		Thread thread = new Thread(data);
		startTime = System.nanoTime();
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		endTime = System.nanoTime();
		System.out.println("dataFull sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms.");
		Sort data1 = new Sort(dataHalf1);
		Sort data2 = new Sort(dataHalf2);
		Thread thread1 = new Thread(data1);
		Thread thread2 = new Thread(data2);
		startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		endTime = System.nanoTime();
		System.out.println("dataHalfs sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms.");
		System.out.println("Is dataFull sorted? " + isSorted(dataFull));
		System.out.println("Is dataHalf1 sorted? " + isSorted(dataHalf1));
		System.out.println("Is dataHalf2 sorted? " + isSorted(dataHalf2));
		System.out.println("Is myData sorted? " + isSorted(myData));
	}
	public static boolean isSorted(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
}

class Sort implements Runnable {
	public void run() {
		selectionSort();
	}
	ArrayList<Integer> data = new ArrayList<Integer>();
	Sort(ArrayList<Integer> data) {
		this.data = data;
	}
	ArrayList<Integer> selectionSort() {
		int minIndex;
		for (int i = 0; i < data.size() - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < data.size(); j++) {
				if (data.get(j) < data.get(minIndex))
					minIndex = j;
			}
			Collections.swap(data, i, minIndex);
		}
		return data;
	}
	ArrayList<Integer> bubbleSort() {
		int count;
		for (int i = 0; i < data.size(); i++) {
			count = 0;
			for (int j = 0; j < data.size() - 1 - i; j++) {
				if (data.get(j) > data.get(j + 1)) {
					Collections.swap(data, j, j + 1);
					count++;
				}
			}
			if (count == 0)
				break;
		}
		return data;
	}
	ArrayList<Integer> insertionSort() {
		int j, key;
		for (int i = 1; i < data.size(); i++) {
			key = data.get(i);
			j = i - 1;
			while ((j >= 0) && (data.get(j) > key)) {
				Collections.swap(data, j, j + 1);
				j--;
			}
		}
		return data;
	}
}