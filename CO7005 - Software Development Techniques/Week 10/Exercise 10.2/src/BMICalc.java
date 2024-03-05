import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMICalc {
	public static double calculateBMI(float weight, float height) {
		double BMI;
		BMI = weight / (height * height);
		BigDecimal bd = new BigDecimal(BMI);
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}