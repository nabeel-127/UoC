import java.util.ArrayList;
import java.util.Collections;

public class GradeRank {
	public static void main(String[] args) {
		long startTime, endTime;
		ArrayList<Student> student = new ArrayList<Student>();

		String[] names = {"Nabeel", "Ali", "Muhammad", "Sam", "Smith", "Ahmed", "Mark", "Carl"};
		int[] ages = {27, 26, 30, 20, 22, 24, 34, 54};
		char[] grades = {'B', 'C', 'A', 'F', 'D', 'A', 'F', 'C'};
		
		for (int i = 0; i < names.length; i++) {
			student.add(new Student(names[i], ages[i], grades[i]));
		}

		System.out.println("Before sorting:");
		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i).getName() + ", ");
			System.out.print(student.get(i).getAge() + ", ");
			System.out.println(student.get(i).getGrade());
		}

		ArrayList<Student> selection = student;
		ArrayList<Student> bubble = student;
		ArrayList<Student> insertion = student;
		
		startTime = System.nanoTime();
		selection = selectionSort(selection);
		endTime = System.nanoTime();
		System.out.println("\nSelection sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms.");
		
		startTime = System.nanoTime();		
		bubble = bubbleSort(bubble);
		endTime = System.nanoTime();
		System.out.println("Bubble sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms.");

		startTime = System.nanoTime();	
		insertion = insertionSort(insertion);
		endTime = System.nanoTime();
		System.out.println("Insertion sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms.");

		startTime = System.nanoTime();
		Collections.sort(student, Collections.reverseOrder());
		endTime = System.nanoTime();
		System.out.println("Collections sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms");

		System.out.println("\nAfter sorting:");
		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i).getName() + ", ");
			System.out.print(student.get(i).getAge() + ", ");
			System.out.println(student.get(i).getGrade());
		}
	}

	static ArrayList<Student> selectionSort(ArrayList<Student> list) {
		int minIndex;
		for (int i = 0; i < list.size() - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).getGrade() < list.get(minIndex).getGrade())
					minIndex = j;
			}
			Collections.swap(list, i, minIndex);
		}
		return list;
	}
	static ArrayList<Student> bubbleSort(ArrayList<Student> list) {
		int count;
		for (int i = 0; i < list.size(); i++) {
			count = 0;
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if (list.get(j).getGrade() > list.get(j + 1).getGrade()) {
					Collections.swap(list, j, j + 1);
					count++;
				}
			}
			if (count == 0)
				break;
		}
		return list;
	}
	static ArrayList<Student> insertionSort(ArrayList<Student> list) {
		int j, key;
		for (int i = 1; i < list.size(); i++) {
			key = list.get(i).getGrade();
			j = i - 1;
			while ((j >= 0) && (list.get(j).getGrade() > key)) {
				Collections.swap(list, j, j + 1);
				j--;
			}
		}
		return list;
	}
}