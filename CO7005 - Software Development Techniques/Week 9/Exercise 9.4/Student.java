public class Student implements Comparable <Student> {
	private enum Grade {
		A(90),
		B(80),
		C(70),
		D(50),
		F(0);
		int score;
		Grade(int score) {
			this.score = score;
		}
		public int getHigherGrade(Grade otherStudentGrade) {
			if (this.score > otherStudentGrade.score)
				return 1;
			else if (this.score < otherStudentGrade.score)
				return -1;
			else
				return 0;
		}
		public char getGrade() {
			switch (score) {
				case 90:
					return 'A';
				case 80:
					return 'B';
				case 70:
					return 'C';
				case 50:
					return 'D';
				case 0:
					return 'F';
				default:
					return 'E';
			}
		}
	}

	private String name;
	private int age;
	Grade grade;

	@Override
	public int compareTo(Student otherStudent) {
		return this.grade.getHigherGrade(otherStudent.grade);
	}

	Student(String name, int age, char grade) {
		this.name = name;
		this.age = age;
		setGrade(grade);
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public char getGrade() {
		return grade.getGrade();
	}
	public void setGrade(char grade) {
		switch (grade) {
			case 'A':
				this.grade = Grade.A;
				break;
			case 'B':
				this.grade = Grade.B;
				break;
			case 'C':
				this.grade = Grade.C;
				break;
			case 'D':
				this.grade = Grade.D;
				break;
			case 'F':
				this.grade = Grade.F;
				break;
		}
	}
}