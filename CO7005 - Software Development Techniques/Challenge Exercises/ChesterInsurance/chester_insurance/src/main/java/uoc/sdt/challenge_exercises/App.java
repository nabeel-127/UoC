package uoc.sdt.challenge_exercises;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
// import javafx.scene.control.*;
import java.io.IOException;

public class App extends Application {
	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("Layout"), 640, 480);
		// stage.getIcons().add(new Image("https://example.com/javaicon.png"));
		stage.setScene(scene);
		// stage.getIcons().add(new Image(App.class.getResource("/uoc/sdt/challenge_exercises/Icon.png").toString()));
		stage.getIcons().add(new Image(App.class.getResourceAsStream("Icon.png")));
		stage.setTitle("Chester Insurance");
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}
}