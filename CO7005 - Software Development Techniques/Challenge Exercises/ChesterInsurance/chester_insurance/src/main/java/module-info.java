module uoc.sdt.challenge_exercises {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

	opens uoc.sdt.challenge_exercises to javafx.fxml;
	exports uoc.sdt.challenge_exercises;
}