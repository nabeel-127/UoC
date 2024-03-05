import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FacultyGradeRank {
	public static void main(String[] args) {
		long startTime, endTime;
		ArrayList<Student> student = new ArrayList<Student>();
		Comparator<Student> facultyGradeComparator = new Student();
		String[] 
			names = {"Nabeel", "Ali", "Muhammad", "Sam", "Smith", "Ahmed", "Mark", "Carl"},
			faculty = {"CS", "EE", "EE", "CS", "EE", "CE", "CE", "CE"};
		int[] ages = {27, 26, 30, 20, 22, 24, 34, 54};
		char[] grades = {'B', 'C', 'A', 'F', 'D', 'A', 'F', 'C'};
		for (int i = 0; i < names.length; i++) {
			student.add(new Student(names[i], faculty[i], ages[i], grades[i]));
		}

		System.out.println("Before sorting:");
		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i).getName() + ", ");
			System.out.print(student.get(i).getFaculty() + ", ");
			System.out.print(student.get(i).getAge() + ", ");
			System.out.println(student.get(i).getGrade());
		}

		startTime = System.nanoTime();
		Collections.sort(student, facultyGradeComparator);
		endTime = System.nanoTime();
		System.out.println("\nCollections sorting time elapse: " + ((double) (endTime - startTime) / (double) 1000000) + " ms");
		
		System.out.println("\nAfter sorting:");
		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i).getName() + ", ");
			System.out.print(student.get(i).getFaculty() + ", ");
			System.out.print(student.get(i).getAge() + ", ");
			System.out.println(student.get(i).getGrade());
		}
	}
}
